package com.dudu.lizhen.timetask.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 定时任务====quartz框架实现
 * Created by lizhen on 2018/4/9 0009.
 */
public class MyJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("quartz MyJob date:" + new Date().getTime());
    }
}
