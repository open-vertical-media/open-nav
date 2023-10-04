package openverticalmedia.opennav.task.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import openverticalmedia.opennav.sdk.task.ImmediatelyInterface;
import openverticalmedia.opennav.task.entity.TaskItemEntity;
import openverticalmedia.opennav.task.repository.TaskItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class TaskRunnerService {

    @Autowired
    TaskItemRepository repository;

    @Autowired
    Map<String, ImmediatelyInterface> immediatelyMap;

    public void run() {
        if (CollUtil.isEmpty(immediatelyMap)) {
            return;
        }
        while (true) {
            ThreadUtil.sleep(1000);
            TaskItemEntity item = repository.findTopByStatusOrderByIdAsc("Ready");
            if (item == null) {
                ThreadUtil.sleep(1000 * 10);
                continue;
            }
            boolean exists = immediatelyMap.containsKey(item.getFrom());
            if(!exists){
                log.warn("找不到对应的执行器");
                continue;
            }
            ImmediatelyInterface immediately = immediatelyMap.get(item.getFrom());
            item.setStatus("Running");
            repository.saveAndFlush(item);
            try {
                immediately.run(item.getParam());
            }catch (Exception exception){
                item.setStatus("Failed");
                repository.saveAndFlush(item);
            }
            item.setStatus("Success");
            repository.saveAndFlush(item);
        }

    }
}
