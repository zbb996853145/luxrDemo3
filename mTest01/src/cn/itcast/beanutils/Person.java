package cn.itcast.beanutils;

import java.util.Date;

public class Person {
	private String name;
	private String password;
	private int age;
	private Date birthday;
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
