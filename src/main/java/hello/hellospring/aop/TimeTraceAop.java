package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect

public class TimeTraceAop {
    // 시간 측정 로직을 분리하여 별도의 공통 로직으로 만듦
    // 원하는 적용 대상을 선택 가능

    @Around("execution(* hello.hellospring.*(..)) && !target(hello.hellospring.SpringConfig)")
    // around로 범위 지정 가능
    // hellospring 이하의 모든 클래스에 aop가 적용되는데, springConfig에서 이미 timeTraceAop를 생성하는 코드가 있어 순환참조 발생
    //!target 으로 범위 제외
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}
