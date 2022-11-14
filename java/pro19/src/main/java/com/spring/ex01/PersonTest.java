package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
PersonService person = (PersonService) factory.getBean("personService");
//PersonService person = new PersonServiceImpl(); 더 이상 자바코드에서 객체생성을 하지 않아도 됨
person.sayHello();
	}

}
