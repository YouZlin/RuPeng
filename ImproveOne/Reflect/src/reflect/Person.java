package reflect;

/**
 * 获得人员信息表的对象
 */
public class Person {
	private String name;
	private int age;
	private String phone;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void sayHello() {
		System.out.println("Hello,everybody,I'm "+name);
	}
	
}
