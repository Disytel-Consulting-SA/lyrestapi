package org.libertya.api.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class EventLogAspect {

    @Value("${logging.request.max.length}")
    private int reqMaxLength;

    @Value("${logging.response.max.length}")
    private int resMaxLength;

    private final Logger logger = LoggerFactory.getLogger(EventLogAspect.class);

    @Around("execution(* org.libertya.api.controller.*.*(..))")
    public Object logEvent(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = classNameToString(joinPoint.getSignature().getDeclaringTypeName());
        String methodName = joinPoint.getSignature().getName();
        String arguments = argumentsToString(joinPoint.getArgs());
        try {
            logger.info("{}.{} {} ", className, methodName, arguments);
            Object res = joinPoint.proceed();
            logger.info("{}.{}: {}", className, methodName, responseToLine(res));
            return res;
        } catch (Throwable t) {
            logger.error("Exception en {}.{} - {}", className, methodName, t);
            throw t;
        }
    }

    protected String requestToLine(Object content) {
        return contentToLine(content, true);
    }

    protected String responseToLine(Object content) {
        return contentToLine(content, false);
    }

    protected String contentToLine(Object content, boolean isRequest) {
        if (content==null)
            return "";
        String result = content.toString().replace("\n", ", ");
        int limit = (isRequest ? reqMaxLength : resMaxLength);
        return result.substring(0, Math.min(limit>0?limit:Integer.MAX_VALUE, result.length()));
    }

    protected String classNameToString(String type) {
        if (type==null)
            return "";
        return type.replace("org.libertya.api.controller.", "");
    }

    protected String argumentsToString(Object[] arguments) {
        if (arguments == null || arguments.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arguments.length; i++) {
            sb.append("Arg").append(i + 1).append(": ").append(requestToLine(arguments[i])).append(", ");
        }
        return sb.toString();
    }
}
