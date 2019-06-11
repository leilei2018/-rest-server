package com.able;

import com.able.chain.LookServiceExecution;
import com.able.factory.DefaultLookServerFactory;
import com.able.factory.InterceptorFactory;
import com.able.factory.LookServerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LookTemplate {

    LookServerFactory factory = new DefaultLookServerFactory();

    public List<LookServerInterceptor> intes = new ArrayList<>();


    public void setFactory(LookServerFactory factory) {
        this.factory = factory;
    }


    public String execute(){
        LookService look = this.factory.createLook();
        return look.get();
    }

    public static void main(String[] args) {
        LookTemplate lookTemplate = new LookTemplate();
        InterceptorFactory ify = new InterceptorFactory();

        lookTemplate.setFactory(ify);


        System.out.println(lookTemplate.execute());
    }


}
