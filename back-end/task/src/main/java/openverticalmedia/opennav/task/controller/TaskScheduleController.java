package openverticalmedia.opennav.task.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import openverticalmedia.opennav.sdk.task.TimelyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskScheduleController {
    @Autowired(required = false)
    List<TimelyInterface> timelys;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void minutes(){
        int minute = LocalDateTimeUtil.now().getMinute();
        if(CollUtil.isNotEmpty(timelys)){
            List<TimelyInterface> timeRuns = timelys.stream()
                    .sorted(Comparator.comparing(TimelyInterface::sort).reversed())
                    .collect(Collectors.toList());
            for (TimelyInterface timeRun : timeRuns) {
                if (minute % timeRun.minutes() == 0) {
                    timeRun.run();
                }
            }
        }
    }
}
