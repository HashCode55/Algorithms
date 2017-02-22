#include <iostream>
using namespace std;

class Node{
public:	
	// the value 
	int value;
	// 0->black ; 1->red
	int color; 
	Node *left;
	Node *right;
	Node *parent;

	// constructor for the node
	Node(int val){
		value = val;
		color = 1;
		left = NULL;
		right = NULL;
		parent = NULL;
	}
};

class RBTree{
public:	
	Node *root;
	// sentinel node is used to represent null
	Node *sentinel;
	RBTree(){	
		sentinel = new Node(-1);
		sentinel->color = 0;
		root = sentinel;
	}

	void leftRotate(Node *x){
		// Move anticlockwise from gamma to fix the pointers
		if (x->right == sentinel){
			return;
		}
		Node *y = x->right;
		x->right = y->left; 
		if(y->left != sentinel){
			y->left->parent = x;
		}
		// if x's parent is null, it means it was the root 
		if(x->parent == sentinel){ 
			root = y;
		}else if(x == x->parent->left){
			x->parent->left = y;
		}else{
			x->parent->right = y;
		}
		y->left = x; 
		x->parent = y;
	}

	void rightRotate(Node *x){
		if(x->left == sentinel){
			return;
		}
		Node *y = x->left;
		x->left = y->right;
		if(y->right != sentinel){
			y->right->parent = x;
		}
		y->parent = x->parent;
		// if x's parent is null, it means it was the root 
		if(x->parent == sentinel){ 
			root = y;
		}else if(x == x->parent->right){
			x->parent->right = y;
		}else{
			x->parent->left = y;
		}
		y->right = x; 
		x->parent = y;
	}

	void insert(int n){
		// setting up the new node 


		Node *newNode = new Node(n);
		newNode->left = sentinel;
		newNode->right = sentinel;
		newNode->parent = sentinel;

		// access the root 
		Node *node = root;
		Node *temp = sentinel;
		while(node != sentinel){
			temp = node;
			if(n < node->value){
				node = node->left;				
			}else{
				node = node->right;
			}
		}
		newNode->parent = temp;
		// temp is root 
		if(temp == sentinel){ 
			root = newNode;
		}else if(n < temp->value){
			temp->left = newNode;
		}else{
			temp->right = newNode;
		}
		insertFix(newNode);
	}
	void insertFix(Node *node){
		// this is when the property 4 is violated 
		while(node->parent->color == 1){ 
			// if node's parent is left child of grandparent 
			if(node->parent == node->parent->parent->left){
				Node *uncle = node->parent->parent->right;
				// if the uncle is red and property 4 is violated  
				if(uncle->color == 1){
					node->parent->color = 0;
					uncle->color = 0;
					// make the grandfather red 
					uncle->parent->color = 1; 
					node = node->parent->parent;
				} 
				// if the uncle is not red. 
				else{
					// if node is the right child make it left
					if(node == node->parent->right){
						node = node->parent;
						leftRotate(node);
					}
					node->parent->color = 0;
					node->parent->parent->color = 1;
					rightRotate(node->parent->parent);
				}
			}
			else{
				Node *uncle = node->parent->parent->left;
				// if the uncle is red and property 4 is violated  
				if(uncle->color == 1){
					node->parent->color = 0;
					uncle->color = 0;
					// make the grandfather red 
					uncle->parent->color = 1; 
					node = node->parent->parent;
				} 
				// if the uncle is not red. 
				else{
					// if node is the right child make it left
					if(node == node->parent->left){
						node = node->parent;
						rightRotate(node);
					}
					node->parent->color = 0;
					node->parent->parent->color = 1;
					leftRotate(node->parent->parent);
				}
			}
		}
		// root should be black 	
		root->color = 0; 
	}

	void deleteNode(int n){

	}
	// operations 
	void printTree(Node *node){
		/*
		Inorder traversel of the tree
		*/
		if(node!=sentinel){
			printTree(node->left);
			cout<<node->value<<" "<<(node->color==0?"BLACK\n":"RED\n");
			printTree(node->right);
	}
}
};


int main(){
	RBTree *rbtree = new RBTree();
	rbtree->insert(5);
	rbtree->insert(10);
	rbtree->insert(3);
	rbtree->insert(2);
	rbtree->insert(11);
	rbtree->insert(1);
	rbtree->printTree(rbtree->root);
}