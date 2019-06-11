package com.able;

import com.able.chain.LookServiceExecution;

import java.util.List;

public class InterceptorLookServiceImpl implements  LookService {
    List<LookServerInterceptor> intes;
    LookService lookservice;

    public InterceptorLookServiceImpl(LookService lookservice,List<LookServerInterceptor> intes) {
        this.intes = intes;
        this.lookservice = lookservice;
    }

    @Override
    public String get() {
        return new LookServiceExecution(lookservice,intes).get();
    }
}
