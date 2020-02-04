package test;
import test.BST.Node;

public class Stack {
    int max = 1000;
    Node undo[] = new Node[max];
    int top;
    
    Stack(){
        top = 0;
    }
    
    public Boolean isEmpty(){
        return (top < 0);
	
	}
    public void push(Node data){
        undo[top ]= data;
        top++;
    }
    
    public Node pop() {
       Node data;
       top--;
       data = undo[top];
       undo[top] = null;
       return data;
    } 
  
    public Node peek() {
   
       Node data;
       data = undo[top-1];
       undo[top] = null;
       return data;
    }
}
    

