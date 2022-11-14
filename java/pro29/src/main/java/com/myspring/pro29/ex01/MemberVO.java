package com.myspring.pro29.ex01;


import java.sql.Date;

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
public MemberVO()
{
	System.out.println("MemberVO3 생성자 호출");
}

public MemberVO(String id, String pwd, String name, String email)
{
	this.id = id;
	this.pwd = pwd;
	this.name = name;
	this.email = email;
}

public MemberVO(String id, String pwd, String name, String email, Date joinDate)
{
	this.id = id;
	this.pwd = pwd;
	this.name = name;
	this.email = email;
	this.joinDate = joinDate;
}

public String getid() {
	return id;
}
public void setid(String id) {
	this.id = id;
} 
public String getpwd() {
	return pwd;
}
public void setpwd(String pwd) {
	this.pwd = pwd;
}
public String getname() {
	return name;
}
public void setname(String name) {
	this.name = name;
}
public String getemail() {
	return email;
}
public void setemail(String email) {
	this.email = email;
}
public Date getjoinDate() {
	return joinDate;
}

public void setjoinDate(Date joinDate) {
	this.joinDate = joinDate;
}

@Override
public String toString() {//회원 속성 정보를 출력
	String info = id+", "+ pwd+", "+ name+", "+ email;
	return info;
}

}