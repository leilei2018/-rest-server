package com.able;

import com.able.chain.LookServiceExecution;

import java.lang.reflect.Method;

public interface LookServerInterceptor {

    String interceptor(LookService service, LookServiceExecution exection);

}
