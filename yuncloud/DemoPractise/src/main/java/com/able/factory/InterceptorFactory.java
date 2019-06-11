package com.able.factory;

import com.able.InterceptorLookServiceImpl;
import com.able.LookServerInterceptor;
import com.able.LookService;
import com.able.chain.LookServiceExecution;

import java.util.ArrayList;
import java.util.List;

public class InterceptorFactory extends DefaultLookServerFactory implements LookServerFactory {

    List<LookServerInterceptor> intes = new ArrayList<>();

    @Override
    public LookService createLook() {
        return new InterceptorLookServiceImpl(super.createLook() ,intes);
    }
    public void addIntes(LookServerInterceptor ite){
        intes.add(ite);
    }
}
