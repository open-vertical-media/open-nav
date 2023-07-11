package openverticalmedia.opennav.advert.mapper;

import openverticalmedia.opennav.advert.dto.ajax.AjaxAdvertScheduleDto;
import openverticalmedia.opennav.advert.entity.ScheduleEntity;

public class AdvertScheduleMapper {
    public static AjaxAdvertScheduleDto entityToDto(ScheduleEntity entity){
        AjaxAdvertScheduleDto dto=new AjaxAdvertScheduleDto();
        dto.setTitle(entity.getTitle());
        dto.setIcon(entity.getIcon());
        dto.setDescription(entity.getDescription());
        dto.setTime(entity.getTime());
        dto.setBlockKey(entity.getBlockKey());
        dto.setBlockIndex(entity.getBlockIndex());
        dto.setImgUrl(entity.getImgUrl());
        dto.setLinkUrl(entity.getLinkUrl());
        return dto;
    }
}
