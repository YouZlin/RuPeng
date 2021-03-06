package lesson6;

import java.util.List;

/**
 * 与users.xml中的user相对应
 */
public class User {

	/*
	id="u003" name="花花">
	<email>4386739219@qq.com</email>
	<phones>
		<phone>186948659604</phone>
		<phone>17586973354</phone>
	</phones>
	*/
	private String id;
	private String name;
	private String email;
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
