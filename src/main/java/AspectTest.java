import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AspectTest {

    @Before("execution(* service.PersonService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("@Before - Method name: " + joinPoint.getSignature().getName());
    }

    @Around("execution(* service.PersonService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around - Method name: " + joinPoint.getSignature().getName());
        System.out.println("@Around - Get args: " + Arrays.toString(joinPoint.getArgs()));
        Object ret = joinPoint.proceed();
        System.out.println("@Around - after is running!");
        return ret;
    }

    @AfterReturning(pointcut = "execution(* service.PersonService.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Method name: " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is: " + result);
    }
}
