package com.study.selfs.gupao.springapplication.aano;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface UserTags {

    UserTag[] value();
}
