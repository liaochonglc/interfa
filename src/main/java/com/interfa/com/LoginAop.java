package com.interfa.com;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Order(100)//这是权重
public class LoginAop {
    @Resource
    private HttpServletRequest request;
    @Around("execution(*xx.*.*(..))&& @annotion(IsLogin的全路径)")//这里要写有效的不然报错
    public String isLogin(ProceedingJoinPoint joinPoint) throws Throwable{
//获得cookie多判断是否为空
        //查询redis拿到用户对象看是否登录如果登录了要把拿到的user对象放入到购物车中的user 这里就用到了
        Object[] args = joinPoint.getArgs();//拿到所有参数
        for(int i=0;i<args.length;i++){
            //如果参数.class instanceof user的 把user赋值给它
        }
        return (String)joinPoint.proceed(args);//放行
        //添加购物车代码那里如果user不为空则说明已经登录了这时候就要把商品信息添加到购物车表,如果cookie中有购物车的信息则要进行合并了每次添加商品放到cookie中如果没有登录
        //把list的json转成对象的形式newGson().fromJson(json,new TypeToken<List<Cart>>(){});这里记得UrlEncoder一下
        //httoclient购物车合并 这不是直接设置请求体而是设置参数 new UrlEncodedFormEntity(list);lst类型是NameValuePair,别忘记设置请求头因为要发送cookie Cookie cart_info=值
        //反正传两个值订单id,用户id 还有就是cookie cookie里面放商品id和数量
        //后面下单的islogin注解只能判断登没登了但是不能去操作登录所以加一个注解mustlogin去登陆页面但是得配合islogin 获得当前页面的url request.getRequestURI()
        //如果想要回到当前页面就要传一个url get形式 还有把gid商品id带过去
    }
}
