package com.team404.util.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //AOP클래스를 의미
@Component //컴포넌트 스캔이 읽어서 bean으로 생성
public class LogAdvice {
	
	//log4j.xml에 선언
//	<!-- Aop패키지 등록 --> <!-- 추가시킨애가 얘야ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ -->
//	<logger name="com.team404.util.aop">
//		<level value="info" />
//	</logger>
	//로그를 찍을 수 있게 처리하는 기능
	
	//이 프로젝트의 모든 서비스에 대해서, target, args, signature의 실행정보를 출력하는 aop
	private static final Logger log = LoggerFactory.getLogger(LogAdvice.class); //얘가 로그를 찍는 애...?
	
	//@Around("execution(* com.simple.board.service.BoardServiceImpl*.*(..))")
	@Around("execution(* com.team404.*.service.*ServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) {
		
		long start= System.currentTimeMillis();
		
//		System.out.println("적용클래스:"+jp.getTarget());
//		System.out.println("적용파라미터:"+Arrays.toString(jp.getArgs()));
//		System.out.println("적용메서드:"+jp.getSignature());
		//위에 sysou 대신에 log.info로 변경!
		log.info("적용클래스:"+jp.getTarget());
		log.info("적용파라미터:"+Arrays.toString(jp.getArgs()));
		log.info("적용메서드:"+jp.getSignature());
		
		System.out.println("실행전");
		Object result = null;
		try{ 
			result=jp.proceed(); //타겟메서드를 지칭하고,이 메서드가 실행되어야 타겟메서드가 실행
		}catch(Throwable e){
			e.printStackTrace();
		}
		System.out.println("실행후");
		
		long end=System.currentTimeMillis();
		//System.out.println("메서드 수행시간:"+(end-start)*0.001+"초");
		log.info("메서드 수행시간:"+(end-start)*0.001+"초");
		
		return result;
	}
	
//	@Around("execution(* com.team404.freereply.service.FreeReplyServiceImpl*.*(..))")
//	public Object freereplyservice(ProceedingJoinPoint jp) {
//		
//		long start= System.currentTimeMillis();
//		
////		System.out.println("적용클래스:"+jp.getTarget());
////		System.out.println("적용파라미터:"+Arrays.toString(jp.getArgs()));
////		System.out.println("적용메서드:"+jp.getSignature());
//		//위에 sysou 대신에 log.info로 변경!
//		log.info("적용클래스:"+jp.getTarget());
//		log.info("적용파라미터:"+Arrays.toString(jp.getArgs()));
//		log.info("적용메서드:"+jp.getSignature());
//		
//		System.out.println("실행전");
//		Object result = null;
//		try{ 
//			result=jp.proceed(); //타겟메서드를 지칭하고,이 메서드가 실행되어야 타겟메서드가 실행
//		}catch(Throwable e){
//			e.printStackTrace();
//		}
//		System.out.println("실행후");
//		
//		long end=System.currentTimeMillis();
//		//System.out.println("메서드 수행시간:"+(end-start)*0.001+"초");
//		log.info("메서드 수행시간:"+(end-start)*0.001+"초");
//		
//		return result;
//	}
//	
//	@Around("execution(* com.team404.user.service.UserServiceImpl*.*(..))")
//	public Object useraround(ProceedingJoinPoint jp) {
//		
//		long start= System.currentTimeMillis();
//		
////		System.out.println("적용클래스:"+jp.getTarget());
////		System.out.println("적용파라미터:"+Arrays.toString(jp.getArgs()));
////		System.out.println("적용메서드:"+jp.getSignature());
//		//위에 sysou 대신에 log.info로 변경!
//		log.info("적용클래스:"+jp.getTarget());
//		log.info("적용파라미터:"+Arrays.toString(jp.getArgs()));
//		log.info("적용메서드:"+jp.getSignature());
//		
//		System.out.println("실행전");
//		Object result = null;
//		try{ 
//			result=jp.proceed(); //타겟메서드를 지칭하고,이 메서드가 실행되어야 타겟메서드가 실행
//		}catch(Throwable e){
//			e.printStackTrace();
//		}
//		System.out.println("실행후");
//		
//		long end=System.currentTimeMillis();
//		//System.out.println("메서드 수행시간:"+(end-start)*0.001+"초");
//		log.info("메서드 수행시간:"+(end-start)*0.001+"초");
//		
//		return result;
//	}
//	
}
