package te;

/**
 * 对原自定义的ArrayList改造成泛型
 *
 * @param <T>
 */
public class MyGenericArrayList <T>{

	private Object []data;
	private int currentSize;
	
	public MyGenericArrayList(){
		this.data=new Object[5];
	}
	public void add(T[]obj){
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
	
	public T get(int index){
		if (index>=this.data.length||index<0) {
			throw new IllegalArgumentException("index超过集合元素的范围");
		}
		return (T)this.data[index];
	}
}
