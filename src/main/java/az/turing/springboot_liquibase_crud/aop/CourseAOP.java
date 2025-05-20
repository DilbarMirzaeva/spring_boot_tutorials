package az.turing.springboot_liquibase_crud.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class CourseAOP {

    @Pointcut(value = "execution(* az.turing.springboot_liquibase_crud.service.CourseService.*(..))")
    public void logForCourse(){}

    @Before(value = "logForCourse()")
    public void logBefore(JoinPoint joinPoint){
        log.info("[{}]Method started successfully: {}",Thread.currentThread().getName(),joinPoint.getSignature().getName());
    }

    @After(value = "logForCourse()")
    public void logAfter(JoinPoint joinPoint){
        log.info("[{}]Method finished successfully: {}",Thread.currentThread().getName(),joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "logForCourse()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint,Object result){
        log.info("[{}]Method: {} | returned : {}",Thread.currentThread().getName(),joinPoint.getSignature().getName(),result);
    }

    @AfterThrowing(value = "logForCourse()",throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint,Exception ex){
        log.error("Method: {} | throw exception: {}",joinPoint.getSignature().getName(),ex.getLocalizedMessage());
    }
}
