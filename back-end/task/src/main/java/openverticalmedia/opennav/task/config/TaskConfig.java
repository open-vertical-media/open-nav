package openverticalmedia.opennav.task.config;

import openverticalmedia.opennav.sdk.task.TaskModel;
import openverticalmedia.opennav.sdk.task.TaskTemplate;
import openverticalmedia.opennav.task.entity.TaskItemEntity;
import openverticalmedia.opennav.task.repository.TaskItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskConfig implements TaskTemplate {
    @Autowired
    TaskItemRepository repository;
    @Override
    public void add(TaskModel model) {
        TaskItemEntity item=new TaskItemEntity();
        item.setFrom(model.getName());
        item.setType("immediately");
        item.setGroup(0);
        item.setParam(model.getParam());
        repository.save(item);
        repository.flush();
    }
}
