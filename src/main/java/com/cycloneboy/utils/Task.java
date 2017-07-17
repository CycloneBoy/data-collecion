package com.cycloneboy.utils;

import com.sun.org.apache.xpath.internal.functions.FuncTranslate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * 说明: 使用@Async实现异步调用
 * 异步调用”对应的是“同步调用”，同步调用指程序按照定义顺序依次执行，
 * 每一行程序都必须等待上一行程序执行完成之后才能执行；异步调用指程序
 * 在顺序执行时，不等待异步调用的语句返回结果就执行后面的程序
 * Created by CycloneBoy on 2017/7/17.
 */
@Component
public class Task {

    public static Random random = new Random();

    @Async
    public Future<String> doTaskOne() throws  Exception{
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时: " + (end - start) + "毫秒");
        return new AsyncResult<>("任务一已完成");
    }

    @Async
    public Future<String> doTaskTwo() throws  Exception{
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时: " + (end - start) + "毫秒");
        return  new AsyncResult<>("任务二已完成");
    }

    @Async
    public Future<String> doTaskThree() throws  Exception{
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时: " + (end - start) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }
}
