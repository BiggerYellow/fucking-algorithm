import numpy as np

def EuclideanDistance(x, y):
    x = np.array(x)
    y = np.array(y)
    return np.sqrt(np.sum(np.square(x-y)))



if __name__ == '__main__':
    print(EuclideanDistance(3,3))