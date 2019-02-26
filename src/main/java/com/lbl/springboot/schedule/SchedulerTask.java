package com.lbl.springboot.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author benli
 * @date 2019/2/25 22:05
 */
@Component
public class SchedulerTask {

    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
