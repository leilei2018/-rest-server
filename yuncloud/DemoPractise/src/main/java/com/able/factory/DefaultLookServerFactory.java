package com.able.factory;

import com.able.LookService;
import com.able.factory.LookServerFactory;

public class DefaultLookServerFactory implements LookServerFactory {

    @Override
    public LookService createLook() {
        return ()->{
            return "haah";
        };
    }
}
