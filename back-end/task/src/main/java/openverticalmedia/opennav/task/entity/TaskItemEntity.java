package openverticalmedia.opennav.task.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Where(clause = "is_delete=0")
@Table(name = "nav_task_item")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_task_item set is_delete=1 where id = ?")
public class TaskItemEntity extends TaskEntity {
    /**
     * 运行参数
     */
    private String param;
    /**
     * 类型
     * immediately / timely
     */
    private String type;
    /**
     * 分组
     * 可以做多线程区分
     */
    @Column(name = "item_group")
    private int group;
    /**
     * 状态
     * Ready / Running / Success /Failed
     */
    private String status="Ready";
    /**
     * 来源信息
     */
    @Column(name = "item_from")
    private String from;
}
