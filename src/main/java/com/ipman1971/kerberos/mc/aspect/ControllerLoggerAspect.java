package com.ipman1971.kerberos.mc.aspect;

import com.ipman1971.kerberos.mc.domain.Principal;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by jcorredera on 24/01/17 - 13:17.
 */
@Aspect
@Component
public class ControllerLoggerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLoggerAspect.class);

    @Before("execution(public * com.ipman1971.kerberos.mc.controllers.*Controller.*(..))")
    public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
        LOGGER.info("[REST-LOGGER]: {}",pjp);
        Object[] args=pjp.getArgs();
        for(Object arg:args) {
            if(arg instanceof Principal) {
                LOGGER.info("[REST-LOGGER]: Principal param value => {} ",((Principal)arg).toString());
            }
        }
    }

}