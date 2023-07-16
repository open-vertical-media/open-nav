package openverticalmedia.opennav.advert.dto.admin;

import lombok.Data;

@Data
public class AdminAdvertScheduleDto {
    private long id;
    private String blockKey;
    private Integer blockIndex;
    private String title;
    private String imgUrl;
    private String linkUrl;
    private String description;
    private String icon;
    private String time;
}
