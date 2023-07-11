package openverticalmedia.opennav.advert.dto.ajax;

import lombok.Data;

@Data
public class AjaxAdvertScheduleDto {
    private String blockKey;
    private Integer blockIndex;
    private String title;
    private String imgUrl;
    private String linkUrl;
    private String description;
    private String icon;
    private String time;
}
