package openverticalmedia.opennav.task.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import openverticalmedia.opennav.sdk.task.ImmediatelyInterface;
import openverticalmedia.opennav.task.entity.TaskItemEntity;
import openverticalmedia.opennav.task.repository.TaskItemRepository;
import openverticalmedia.opennav.task.service.TaskRunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class TaskRunnerController implements ApplicationRunner {
    @Autowired
    TaskRunnerService service;
    @Override
    public void run(ApplicationArguments args) {
       service.run();
    }
}
