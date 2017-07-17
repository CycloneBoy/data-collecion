package com.cycloneboy.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用@Scheduled创建定时任务
 * Created by CycloneBoy on 2017/7/17.
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("现在时间(Current Time)：" + dateFormat.format(new Date()));
    }
}
