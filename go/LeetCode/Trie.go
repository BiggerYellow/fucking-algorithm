package main

func main() {
	obj := Constructor()
	 obj.Insert("word")
	 //param_2 := obj.Search(word);
	 //param_3 := obj.StartsWith(prefix);
}

type Trie struct {
	children [26]*Trie
	isEnd bool
}


/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{}
}


/** Inserts a word into the trie. */
func (this *Trie) Insert(word string)  {
	node := this
	for _,ch :=range word{
		ch-='a'
		if node.children[ch] == nil {
			node.children[ch] = &Trie{}
		}
		node = node.children[ch]
	}
	node.isEnd = true
}


/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	node:=this.searchPrefix(word)
	return node!=nil && node.isEnd
}


/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	node:=this.searchPrefix(prefix)
	return node!=nil
}

func (this *Trie) searchPrefix(prefix string) *Trie {
	node:=this
	for _,ch :=range prefix{
		ch-='a'
		if node.children[ch] == nil {
			return nil
		}
		node = node.children[ch]
	}
	return node
}