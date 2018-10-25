package reflect;


/**
 * 反射中主要类<br>
 * 类--Class<br>
 * 构造函数--Constructor<br>
 * 字段--Field<br>
 * 方法--Method<br>
 *
 */
public class MyReflect {

	public static void main(String[] args) {
		reflectTest1();
	}
	
	/**
	 * get Class
	 */
	private static void  reflectTest1(){
		//method one
		Class clz1=Person.class;//获得Person类对应的class类的对象
		//method two
		Person p1=new Person();
		Class clz2=p1.getClass();//根据类的对象,获取类的描述对象
		//method three
		Class clz3=null;
		try {
			clz3=Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(clz1);
		System.out.println(clz2);
		System.out.println(clz3);
		
		System.out.println(clz1==clz2);//类型对象相同
		System.out.println(clz2==clz3);//类型对象相同
		
		Class clz4=String.class;
		System.out.println(clz3==clz4);//不是用一个类型对象
		
		//包装类和基本类不是同一个类型对象,内部存在隐式转换
		Class clz5=int.class;
		Class clz6=Integer.class;
		System.out.println(clz5==clz6);//不是同一个类型对象
	}

	
	
}
