package edu.ssafy.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class PrintAdvice {
	@Before("execution(* edu.ssafy.boot.service.MemberService.selectList())")
	public void printBefore(JoinPoint jp) {
		System.out.println("AOP Beforeprint");
	}

	@After("execution(* edu.ssafy.boot.service.MemberService.selectList())")
	public void printAfter(JoinPoint jp) {
		System.out.println("AOP After print");
	}

	@Around("execution(* edu.ssafy.boot.service.MemberService.selectOne(..))")
	public Object printAround(ProceedingJoinPoint jp) {
		Object proceed = null;
		try {
			System.out.println("AOP Around before print");
			proceed = jp.proceed();
			System.out.println("AOP Around after print");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proceed;
	}
}