package openverticalmedia.opennav.nav.vo;

import lombok.Data;

import java.util.List;

@Data
public class NavigationVo {
    /**
     * Logo
     */
    private String logo;
    /**
     * 口号
     */
    private String slogan;
    /**
     * 按钮链接集合
     */
    private List<openverticalmedia.opennav.nav.vo.LinkVo> links;

}
