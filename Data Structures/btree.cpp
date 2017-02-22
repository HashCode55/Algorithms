#include <iostream>
#define DEGREE 3 // 5 maximum nodes 
using namespace std;


class Node{
	/*
	Node definition
	*/
public:	
	// The number of keys currently stored in the node 
	int n;         
	// The keys stored 
	int *keys;
	// is it a leaf or not
	bool isLeaf; 										
	// Pointers to its children, so an array of pointers  
	Node **nodes;
	// ??
	Node(){	
		keys = new int[2*DEGREE - 1];	
		nodes = new Node*[DEGREE*2+1];
		n = 0;
	}
};

class BTree{
public:	
	Node *root;
	BTree(){
		root = NULL;
	}


	void BtreeCreate(BTree *btree){
		cout<<"BTreeCreate"<<endl;
		Node *node = new Node();
		node->isLeaf = true;
		node->n = 0;
		btree->root = node; 							// make this node the root 
	}
	void BTreeSplit(Node *node, int index){
		/*
		Doc it mofo.
		*/
		// This is the new child
		cout<<"BTreeSplit"<<endl;
		Node *newChild = new Node(); 		       			
		// Child which is full 
		Node *fullChild = node->nodes[index];
		// if the full child was leaf make it a leaf too
		newChild->isLeaf = fullChild->isLeaf;       			
		newChild->n = DEGREE-1;

		for(int i = 0; i < DEGREE-1; i++){
			*(newChild->keys + i) = *(fullChild->keys + i + DEGREE);
		}
		if(!fullChild->isLeaf){
			for(int i = 0; i < DEGREE; i++){
				*(newChild->nodes + i) = *(fullChild->nodes + i + DEGREE);
			}
		}
		fullChild->n = DEGREE - 1;

		// inserting the median as key in the parent 
		for(int i = node->n + 1; i >= index+1; i--){ 		
			*(node->nodes + i + 1) = *(node->nodes + i);
		}

		// TODO : Explanation
		*(node->nodes + index + 1) = newChild;
		for(int i = node->n; i>= index; i--){
			*(node->keys + i + 1) = *(node->keys + i);
		}
		*(node->keys + index) = *(fullChild->keys + index);
		node->n = node->n + 1;
	}

	void BTreeInsertNonFull(Node *node, int k){
		/*
		Docs 
		*/
		cout<<"BTreeInsertNonFull"<<endl;
		int i = node->n;
		if(node->isLeaf){
			while(i > 0 && k < *(node->keys + i)){																
				*(node->keys + i + 1) = *(node->keys + i);
				i--;
			}
			cout<<"BTreeInsertNonFull"<<endl;
			*(node->keys + i + 1) = k;
			node->n += 1;
		}else{
			cout<<"BTreeInsertNonFulllllllll"<<endl;
			while(i >= 1 && k < *(node->keys + i)){
				i--;
			}
			//i++;
			// if this child is full
			cout << node->n << " " << i << endl; 
			if (node->nodes[i]->n == 2*DEGREE - 1){				
				cout<<"BTreeInsertNonFulllllllll"<<endl;
				BTreeSplit(node, i);
				if (k > *(node->keys + i)){
					i++;
				}
			}
			BTreeInsertNonFull(*(node->nodes + i), k);
		}
	}


	void BTreeInsert(BTree *btree, int k){
		/*
		Doc it mofo.
		*/

		// get the address of the root 
		cout<<"BTreeInsert"<<endl;
		Node *start = btree->root;
		if (start->n == 2*DEGREE - 1){
			Node *node = new Node();
			btree->root = node;
			node->isLeaf = false;
			node->n = 0;
			*(node->nodes) = start;
			// split the full child at index 0
			BTreeSplit(node, 0); 
			BTreeInsertNonFull(node, k);
		}else{
			// The root itself is non full 
			BTreeInsertNonFull(start, k); 
		}
	}

};

void printBTree(BTree *btree, Node *node) {
	for(int i = 0; i < node->n; i++){
		cout<<node->keys[i]<<endl;
	}
	cout<<endl;
	for(int i = 0; i <= node->n; i++){
		if(!node->isLeaf){
			printBTree(btree, node->nodes[i]);
		}else{
			return;
		}
	}
	return;
}

int main(){
	BTree *btree = new BTree();
	btree->BtreeCreate(btree); 								// create the btree
	for(int i = 0; i < 15; i++){
		btree->BTreeInsert(btree, i);
	}
	printBTree(btree, btree->root);
}
