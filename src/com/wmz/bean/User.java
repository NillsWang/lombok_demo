package com.wmz.bean;

import lombok.*;
import lombok.extern.java.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangminze
 * @create 2020-06-27-10:56
 */
@Getter //@Getter注解将所有非静态成员变量产生get()方法
@Setter //@Setter注解将所有非静态成员变量产生set()方法
@ToString //@ToString注解只能作用于类级别上会生成toString()方法
          //@ToString(exclude = {“字段”}) 排除某些字段
          //@ToString(of = {“字段”}) 指定某些字段输出
@EqualsAndHashCode // @EqualsAndHashCode(exclude={"字段"}) 去除某些字段
                   // @EqualsAndHashCode(of={"字段"}) 指定某些字段
                   // 添加equals()，
                   // hashCode()方法，
                   // canEquals()方法
@NoArgsConstructor //指定无参构造器
@RequiredArgsConstructor() //指定参数沟槽器，对标识final未给初值，和指定NonNull的成员变量作为参数
@AllArgsConstructor //指定所有参数作为成员变量
//@Data //指定get，set，equals，constructor(指定NonNull参数)，toString，hashCode方法
@Builder //内置一个当前类的对象使用链式编程初始化参数、
@Log //使当前类添加一个内置logger对象
public class User {

    //@Getter //Getter注解将当前成员变量产生get()方法
    //@Setter //Setter注解将当前成员变量产生set()方法
    private String name;

    private static Integer id;

    //final类型成员变量lombok @Setter无法生成set()方法
    private final String password = "123456";

    //@Getter(AccessLevel.NONE) 当前成员变量不会生成get()方法
    //  AccessLevel属性可设置get()，set()方法的访问修饰符
    //@Setter(AccessLevel.NONE) 当前成员变量不会生成set()方法
    private String phone;

    @NonNull //@NonNull 指定不为空
    private String email;

    public void test(@NonNull String s) { //@NonNull 指定参数不为null
        System.out.print(s);

        //log.info("test");
        //UserBuilder builder = User.builder().name("tom");

        //使用lombok来管理流的关闭
        try {
            @Cleanup InputStream is = new FileInputStream("path");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
