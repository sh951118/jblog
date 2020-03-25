package com.douzone.security;

import java.lang.annotation.ElementType;

//import static java.lang.annotation.ElementType.PARAMETER;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface AuthUser {

}
