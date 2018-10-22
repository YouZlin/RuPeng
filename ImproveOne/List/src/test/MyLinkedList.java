package test;

public class MyLinkedList {
	private MyLinkedListNode firstNode;//第一个节点
	
	public void add(Object obj){
		if (firstNode==null) {
			firstNode=new MyLinkedListNode();
			firstNode.setData(obj);
		}else{
			MyLinkedListNode currentNode=null;
			currentNode=firstNode;
			while (currentNode.getNextNode()!=null) {
				currentNode=currentNode.getNextNode();
			}
			MyLinkedListNode newNode=new MyLinkedListNode();
			newNode.setData(obj);
			currentNode.setNextNode(newNode);
			
		}
	}
	
	public int size(){
		if (firstNode==null) {
			return 0;
		}
		MyLinkedListNode currentNode=firstNode;
		int counter=0;
		while (currentNode!=null) {
			currentNode=currentNode.getNextNode();
			counter++;
		}
		return counter;
	}
	
	public Object get(int index){
		MyLinkedListNode currentNode=firstNode;
		int counter=0;
		while(currentNode!=null){
			if (counter==index) {
				return currentNode.getData();
			}
			currentNode=currentNode.getNextNode();
			counter++;
		}
		return index;
	}
	

	
	
	
	class MyLinkedListNode{
		Object data;
		MyLinkedListNode nextNode;
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public MyLinkedListNode getNextNode() {
			return nextNode;
		}
		public void setNextNode(MyLinkedListNode nextNode) {
			this.nextNode = nextNode;
		}
	}
	
}