package openverticalmedia.opennav.spider.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SpiderSiteData {
    @NotBlank
    private String domain;
}
