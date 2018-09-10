package com.ccr.apt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Created on 2018/9/1.
 * @autthor Acheng
 * @Email 345887272@qq.com
 * @Description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface FCallbackId {
    String id();
}
