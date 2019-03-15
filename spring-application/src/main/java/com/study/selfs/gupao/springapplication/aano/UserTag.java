package com.study.selfs.gupao.springapplication.aano;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Repeatable(UserTags.class)// java 8
public @interface UserTag {

    String value();

}
