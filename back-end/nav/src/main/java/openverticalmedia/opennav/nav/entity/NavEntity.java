package openverticalmedia.opennav.nav.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
@MappedSuperclass
@ToString
public class NavEntity {
    /**
     * 主键自增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    /**
     * 创建时间 默认当前时间
     */
    @Column(name = "gmt_create",updatable = false)
    @CreationTimestamp
    protected Timestamp createTime ;
    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    @UpdateTimestamp
    protected Timestamp modifiedTime;
    /**
     * 伪删除不需要设置true
     * 直接调用delete
     * 此处存在是由于jpa强校验 需要映射后期找方法去除改字段
     */
    private boolean isDelete=false;
}
