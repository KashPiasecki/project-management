package pl.kashp.projectmanagement.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(ApplicationLoggerAspect.class);

    @Pointcut("within(pl.kashp.projectmanagement.controllers..*)")
    public void definePackagePointcuts(){
        //empty method just to name the location specified in the pointcut
    }

    @After("definePackagePointcuts()")
    public void log(JoinPoint jp){
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

    }

}
