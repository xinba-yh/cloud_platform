package com.qianli.ilink.cloud_platform.messagecenter.core.aspects;


import com.qianli.ilink.cloud_platform.commons.core.eneity.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class WebAspect {

    @Pointcut("execution(* com.qianli.ilink.cloud_platform.messagecenter.web.*.*(..))")
    public void webAddress() {}
    @Value("${cloudPlatform.requestTimeOut:50000}")
    private long timeOut;

    @Around("webAddress()")
    public ResponseEntity recordingWebLogs(ProceedingJoinPoint point) throws Throwable {
        String url;
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        if (null != ra) {
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();
            url = request.getRequestURL().toString();
        } else
            url = "unknown url";
        StopWatch stopWatch = startStopWatch();
        String methodName = point.getSignature().getName();
        log.info("request from url : {} ,request from method : {} ",url,methodName);
        ResponseEntity result = (ResponseEntity) point.proceed();
        stopWatch.stop();
        long timeConsumMillis = stopWatch.getTotalTimeMillis();
        log.info("request from url : {} ,response result : {} ,time consum : {} millis ",url,methodName, timeConsumMillis);
        if (timeConsumMillis > timeOut)
            log.warn("warning request url time out , url : {} , time consum : {}",url,timeConsumMillis);
        return result;
    }

    private StopWatch startStopWatch() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }


}
