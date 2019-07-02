package com.edison.restful.aspect;

import com.edison.restful.util.RequestBodyUtil;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class SessionInterceptor {

  private static final Logger LOGGER = LoggerFactory
      .getLogger(SessionInterceptor.class);

  @Pointcut("execution(* com.edison.restful.api.controller.*.*(..))")
  public void listInterceptor() {
  }


  @Around("listInterceptor()")
  public Object aroundTest(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Object result = joinPoint.proceed();
    long end = System.currentTimeMillis();
    if (result == null) {
      return null;
    }
    String targetClassName = joinPoint.getSignature().getDeclaringTypeName();
    String methodName = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    String returnType = joinPoint.getSignature().toString().split("")[0];
    int argSize = args.length;
    StringBuilder argsTypes = new StringBuilder();
    Map<Object, Object> aopPerformance = Maps.newHashMap();
    aopPerformance.put("类名称", targetClassName);
    if (argSize > 0) {
      for (Object object : args) {
        argsTypes.append(object.getClass().getTypeName()).append(" ");
        if ("org.eclipse.jetty.server.Request"
            .equals(object.getClass().getTypeName())) {
          HttpServletRequest ss = (HttpServletRequest) object;
          LOGGER
              .info("Url = {}, Method = {} ,{}, Body = {} ,Header = {}",
                  ss.getRequestURL().toString(),
                  ss.getMethod(), ss.getQueryString(), RequestBodyUtil.read(ss.getReader()),
                  ss.getHeaderNames().nextElement());
        }
      }
      aopPerformance.put("参数类型", argsTypes);
    }
    aopPerformance.put("耗时(ms)", (end - start));
    aopPerformance.put("参数个数", argSize);
    aopPerformance.put("方法", methodName);
    aopPerformance.put("返回类型", returnType);
    LOGGER.info("[AOP PERFORMANCE METRICS]:" + aopPerformance.toString());
    return result;
  }
}
