package pl.kashp.projectmanagement.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(ApplicationLoggerAspect.class);

    @Pointcut("within(pl.kashp.projectmanagement.controllers..*)")
    public void definePackagePointcuts(){
        //empty method just to name the location specified in the pointcut
    }

    @Around("definePackagePointcuts()")
    public Object log(ProceedingJoinPoint jp){
        log.debug("\n\n\n");
        log.debug("********* Before Method Execution ********* \n {}.{}() with arguments[s] = {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("___________________________________________________________ \n\n\n");

        Object proceed = null;
        try {
            proceed = jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        log.debug("********* After Method Execution ********* \n {}.{}() with arguments[s] = {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("___________________________________________________________ \n\n\n");
        return proceed;
    }

}
