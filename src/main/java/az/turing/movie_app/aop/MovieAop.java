package az.turing.movie_app.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MovieAop {

    @Pointcut("execution(* az.turing.movie_app.service.MovieService.*(..))")
    public void logPointcut(){}

    @Before("logPointcut()")
    public void logBefore(JoinPoint joinPoint){
        log.info("Method started successfully: {}",joinPoint.getSignature().getName());
    }

    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint){
        log.info("Method finished successfully: {}",joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "logPointcut()",throwing = "ex")
    public void AfterThrowing(JoinPoint joinPoint,Exception ex){
        log.error("Method: {} | throw exception: {}",joinPoint.getSignature().getName(),ex.getLocalizedMessage());
    }

    @AfterReturning(value = "logPointcut()",returning = "result")
    public void AfterReturning(JoinPoint joinPoint,Object result){
        log.info("Method: {} | returned : {}",joinPoint.getSignature().getName(),result);
    }
}
