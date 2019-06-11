package com.able;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class LookChain {

     List<LookServerInterceptor> intercepts = new ArrayList<>();

    public LookService target;
    public LookChain(LookService target){
        this.target = target;
    }
    public LookChain(LookService target,List<LookServerInterceptor> intercepts){
        this.target = target;
        this.intercepts = intercepts;
    }





}
