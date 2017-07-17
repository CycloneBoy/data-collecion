package com.cycloneboy;

import com.cycloneboy.config.DataCollecionApplication;
import com.cycloneboy.utils.Task;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.Future;

@EnableAsync
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DataCollecionApplication.class)
public class DataCollecionApplicationTests {

	private Task task = new Task();

	@Test
	public void test() throws Exception{
		long start = System.currentTimeMillis();

		Future<String> task1 = task.doTaskOne();
		Future<String> task2 = task.doTaskTwo();
		Future<String> task3 = task.doTaskThree();

		while (true){
			if(task1.isDone() && task2.isDone() && task3.isDone()){
				// 三个任务都已经调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成,总耗时: " + (end - start) + "毫秒");
	}

}
