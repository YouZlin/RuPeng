package test;

public class MyArrayList {

	private Object []data;
	private int currentSize;
	
	public MyArrayList(){
		this.data=new Object[5];
	}
	public void add(Object obj){
		if (currentSize>=this.data.length) {
			Object []new_data=new Object[this.data.length+5];
			for (int i = 0; i < this.data.length; i++) {
				new_data[i]=data[i];
			}
			this.data=new_data;
		}
		data[currentSize]=obj;
		currentSize++;
	}
	
	public int size(){
		return this.currentSize;
	}
	public Object get(int index){
		if (index>=this.data.length||index<0) {
			throw new IllegalArgumentException("index超过集合元素的范围");
		}
		return this.data[index];
	}
}
