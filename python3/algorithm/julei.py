#!/usr/bin/env python
# coding: utf-8

# In[ ]:


import time

import gensim
import jieba
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import seaborn as sns
import xlsxwriter as xlsxwriter
from gensim.models import *
from sklearn.cluster import KMeans
from sklearn.feature_extraction.text import CountVectorizer, TfidfTransformer


def read_csv(address):
    text=pd.read_csv(address)
#     for i in range(text.shape[0]):
#         if text.iloc[i].shape[0]!=2:
#             text.drop(index=i,axis=0,inplace=True)
#     text.columns=['session','content']
    text.drop_duplicates(keep=False)
    return text

def fenci_new(text):
    cut_words = map(lambda s: list(jieba.cut(s)),text['content'].astype(str))
    cut_words = list(cut_words)
    return cut_words

def drop_stopwords(cut_words):
    with open(r'C:\Users\chunchen.huang\Desktop\满满\工作\聚类\stopwords.txt', encoding='utf-8') as f:
        stopwords = f.readlines()
        stopwords = map(lambda s: s.replace('\n', ''), stopwords)
        stopwords = list(stopwords)
#         for i in stopwords:
#             cut_words.re.sub('{}'.format(i),'')
#         # print(stopwords)

    text_clean = []
    for line in cut_words:
        line_clean = []
        for word in line:
            if word in stopwords:
                continue
            line_clean.append(word)
        text_clean.append(line_clean)
    return text_clean

def X_train(cut_sentence):
    x_train = []
    for i, text in enumerate(cut_sentence):
        document = gensim.models.doc2vec.TaggedDocument(text,tags=[i])
        x_train.append(document)
    return x_train

def train(x_train, size=300):
    model = Doc2Vec(x_train,min_count=1,window=3,vector_size=size,sample=1e-3,negative=5,workers=4)
    model.train(x_train,total_examples=model.corpus_count,epochs=10)
    # model.save('model/model_dm')
    model.save('kmeans_model.pkl')
    return model

def cluster(x_train,n_clusters):
    infered_vectors_list = []
    model_dm = Doc2Vec.load("kmeans_model.pkl")
    i = 0
    for text, label in x_train:
        vector = model_dm.infer_vector(text)
        # print(vector)
        infered_vectors_list.append(vector)
        i += 1
    # print('infer',infered_vectors_list)
    kmean_model = KMeans(n_clusters=n_clusters)
    kmean_model.fit(infered_vectors_list)
    labels = kmean_model.predict(infered_vectors_list[0:])
    cluster_centers = kmean_model.cluster_centers_
    df_result=pd.DataFrame(labels,columns=['label'])
    return df_result,infered_vectors_list

def zhuanyi_matrix(df_result, n_clusters):
    M = np.zeros((n_clusters,n_clusters),dtype=np.int)
    for session in range(df_result.index[-1]+1):
        if len(text[text['session']==session].index)==0:
            continue
        else:
            transitions = df_result[df_result['session']==session].label.values
            if len(transitions)>1:
                for (i, j) in zip(transitions, transitions[1:]):
                    M[i][j] += 1
    return M
#     print(sum(M))

if __name__ == '__main__':
    # text=pd.read_csv(r'C:\Users\chunchen.huang\Desktop\满满\工作\聚类\text_sample_0425.csv')[0:100]
    text=pd.read_csv(r'C:\Users\chunchen.huang\Desktop\满满\工作\在线客服知识点改进\question_20220706_年审.csv', error_bad_lines=False, sep = '')
    # text=pd.read_csv(r'C:\Users\chunchen.huang\Desktop\满满\工作\在线客服知识点改进\20220428_consult.csv')

    cut_words=fenci_new(text)
    text_clean=drop_stopwords(cut_words)
    x_train=X_train(text_clean)
    train(x_train, size=300)
    df_result,infered_vectors_list=cluster(x_train,3)
    # text.index=text['session'].values
    # text=text[['session','label']]
    text=text.join(df_result)
    # M=zhuanyi_matrix(text[['session','label']],75)
    # M=zhuanyi_matrix(text[['session','label']],75)
    # M.to_csv(r'C:\Users\chunchen.huang\Desktop\满满\工作\聚类\julei_result_kmeans.csv')
    text.to_excel(r'C:\Users\chunchen.huang\Desktop\满满\工作\在线客服知识点改进\question_20220706_年审_result.xlsx')

