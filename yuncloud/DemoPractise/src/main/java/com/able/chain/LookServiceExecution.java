package com.able.chain;

import com.able.LookServerInterceptor;
import com.able.LookService;

import java.util.Iterator;
import java.util.List;

public class LookServiceExecution implements LookService{

    List<LookServerInterceptor> intes;
    Iterator<LookServerInterceptor> iterator;
    LookService target;
    public LookServiceExecution(LookService target,List<LookServerInterceptor> intes){
        this.target = target;
        this.intes = intes;
        this.iterator = intes.iterator();
    }
    @Override
    public String get() {
        if(iterator.hasNext()){
            return iterator.next().interceptor(target,this);
        }else{
            return target.get();
        }
    }
}
