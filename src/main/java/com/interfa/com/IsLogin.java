package com.interfa.com;

import java.lang.annotation.*;
//自定义注解类

/**
 * @Retention表示该注解的作用范围
 * @Documented当代码生成api时会把注解自动写入到文件 RetentionPolicy.SOURCE 表示作用只在源码中 编译完后消失
 * RetentionPolicy.CLASS 作用可以在.class文件,运行程序时会消失
 * RetentionPolicy.RUNTIME作用在运行时
 * @Target 注解标记的范围
 */
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface IsLogin {
    String abc();//可理解成参数或者属性
    //int[]age() default 0;这种形式用注解的时候用@IsLogin(age={10,20}),如果参数名是value不是abc则可以省略
}
