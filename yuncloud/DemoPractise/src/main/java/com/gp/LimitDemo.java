package com.gp;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class LimitDemo {
    //类似于一种漏桶算法 ，恒定的qps，不能应对突发的流量
    static  Semaphore sm = new Semaphore(1);

    //令牌桶bursty
    static  RateLimiter bursty = RateLimiter.create(30);
    //漏桶算法
    static  RateLimiter aaa = RateLimiter.create(30,3,TimeUnit.SECONDS);

    public static void visit(int n){
        long start = System.currentTimeMillis();
        int req = 100;
        for (int i = 1; i <=req; i++) {
            aaa.acquire();
        }
        long end = (System.currentTimeMillis()-start)/1000;
        System.out.println("实际qbs："+ (end==0?0:(req/end)));
    }

    //qbs 每秒钟执行请求数量 请求总数/多少秒  100/5

    static void a1() throws InterruptedException {
        for (int i = 1; i <=20; i+=5) {
            TimeUnit.SECONDS.sleep(i);
            visit(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
       a1();
    }

}
