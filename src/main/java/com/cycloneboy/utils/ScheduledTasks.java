package com.cycloneboy.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用@Scheduled创建定时任务
 * Created by CycloneBoy on 2017/7/17.
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public ScheduledTasks(){
        new Thread(()->{
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                System.out.println("服务端启动(port:8000) ");

                // Listen for a connection request
                Socket socket = serverSocket.accept();

                // Create data input and output streams
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while(true){
                    // Receive radius from the client
                    double radius = inputFromClient.readDouble();
                    System.out.println("接收到的半径: " + radius);
                    // Computer area
                    double area = radius * radius * Math.PI;

                    // Send area back to the client
                    System.out.println("计算出来的面积: " + area);
                    outputToClient.writeDouble(area);


                }
            } catch (IOException e) {
                System.out.println("通信出现异常: " + e.toString());
                e.printStackTrace();
            }
        });
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("现在时间(Current Time)：" + dateFormat.format(new Date()));

    }
}
