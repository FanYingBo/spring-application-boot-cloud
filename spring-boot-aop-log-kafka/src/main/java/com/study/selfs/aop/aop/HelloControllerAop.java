package com.study.selfs.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * spring aop  代理模式
 * java {@link Proxy}  {@link InvocationHandler}
 * cglib{@link Enhancer} {@link MethodInterceptor}
 *
 * 切入点
 * {@link JoinPoint}
 *
 */
//@Aspect
@Configuration
public class HelloControllerAop {

//
//    /**
//     * 定义切入点
//     * execution( * com.study.selfs.aop.controller..*.*(..))
//     * execution( * com.study.selfs.aop.controller.HelloAopController(..))
//     */
//    @Pointcut("execution(public * com.study.selfs.aop.controller..*.*(..))")
//    public void executeService(){
//    }
//
//    /**
//     * 切入点所标记的方法被调用前
//     * value 可替换为 execution(public * com.study.selfs.aop.controller..*.*(..))
//     *
//     * @param joinPoint
//     */
//    @Before(value = "executeService()")
//    public void beforeSay(JoinPoint joinPoint){
//        System.out.println("before execute");
//        System.out.println("AOP 代理的名字："+joinPoint.getThis());
//        Signature signature = joinPoint.getSignature();
//        System.out.println("方法签名： "+signature);
//        System.out.println("被代理的方法名："+signature.getName());
//        System.out.println("AOP代理的名字："+signature.getDeclaringTypeName());
//
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        //获取servletRequest
//        HttpServletRequest servletRequest = (HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
//        Enumeration<String> attributeNames = servletRequest.getParameterNames();
//        HashMap<String,Object> valueMap = new HashMap<>();
//        while(attributeNames.hasMoreElements()) {
//            String str = attributeNames.nextElement();
//            valueMap.put(str, servletRequest.getParameter(str));
//        }
//        Gson gson = new Gson();
//        String json = gson.toJson(valueMap);
//        System.out.println("请求参数和值："+json);
//    }
//
//    /**
//     * 切入点方法之后被调用
//     */
//    @After("executeService()")
//    public void afterSay(){
//        System.out.println("after execute...");
//    }
//
//    /**
//     * 增强方法，可以对切入的方法进行一些其他操作
//     * @param proceedingJoinPoint
//     * @return
//     */
//    @Around("executeService()")
//    public String twiceAsOld(ProceedingJoinPoint proceedingJoinPoint){
//        System.out.println("aspect execute..");
//        Object proceed = null;
//        try {
//            proceed = proceedingJoinPoint.proceed();
//            System.out.println("proceed "+proceed);
//        } catch (Throwable throwable) {
//            proceed = throwable.getMessage();
//        }
//        return proceed.toString();
//    }
//
//    /**
//     *
//     * 后置异常通知
//     * throwing 为定义异常的名字，需要和方法参数对应，JoinPoint只能作为第一个参数
//     * throwing 主方法异常之后 @Around方法还会执行，需要对其进行校验
//     * @param joinPoint
//     * @param exception
//     */
//    @AfterThrowing(value = "executeService()",throwing = "exception")
//    public void doAfterThrowException(JoinPoint joinPoint,Throwable exception){
//        System.out.println("joinPoint: "+joinPoint.getSignature().getName());
//        if(exception instanceof NullPointerException){
//            System.out.println("nullPointerException...");
//        }
//    }
//
//    /**
//     *后置返回通知
//     * 参数为切入点的方法，returning是返回的值
//     *
//     * */
//    @AfterReturning(value = "executeService()",returning = "value")
//    public void afterRunning(JoinPoint joinPoint,Object value){
//        System.out.println("后置返回通知的返回值："+value);
//    }

}
