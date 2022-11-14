package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor // 스프링에서 지원하는 aop기능을 사용하기위해 필요한 클래스 invoke 사용가능하게함 해당 메서드 실행 전/후 예외 발생 시 실행
{
	public Object invoke(MethodInvocation invocation) throws Throwable //대상 객체의 모든 정보를 담고 있는 객체(호출된 메서드, 인자)
	{
		System.out.println("[메서드 호출 전 : LogginAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 전");
		
		Object object = invocation.proceed();
		
		System.out.println("[메서드 호출 후 : loggingAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 후");
		return object; // 정상적으로 실행되었다는 의미만을 가지고 있어서 출력하거나 다른 객체로 쓸 수 없음
	}

}
