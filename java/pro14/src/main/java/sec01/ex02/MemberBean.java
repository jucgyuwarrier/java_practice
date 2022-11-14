package sec01.ex02;

import java.util.*;

public class MemberBean {
private String id;
private String pwd;
private String name;
private String email;
private Address addr;

public MemberBean() {
	
}
public MemberBean(String id, String pwd, String name, String email) {
	this.id = id;
	this.pwd = pwd;
	this.name = name;
	this.email = email;

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
public Address getaddr() {
	return addr;
}
public void setaddr(Address addr) {
	this.addr = addr;
}
}
