package openverticalmedia.opennav.advert.mapper;

import openverticalmedia.opennav.advert.dto.admin.AdminAdvertScheduleDto;
import openverticalmedia.opennav.advert.dto.ajax.AjaxAdvertScheduleDto;
import openverticalmedia.opennav.advert.entity.ScheduleEntity;

public class AdvertScheduleMapper {
    public static AjaxAdvertScheduleDto entityToAjax(ScheduleEntity entity) {
        AjaxAdvertScheduleDto dto = new AjaxAdvertScheduleDto();
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

    public static AdminAdvertScheduleDto entityToAdmin(ScheduleEntity entity) {
        AdminAdvertScheduleDto dto = new AdminAdvertScheduleDto();
        dto.setBlockIndex(entity.getBlockIndex());
        dto.setIcon(entity.getIcon());
        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        dto.setImgUrl(entity.getImgUrl());
        dto.setLinkUrl(entity.getLinkUrl());
        dto.setBlockKey(entity.getBlockKey());
        dto.setId(entity.getId());
        dto.setTitle(entity.getTime());
        return dto;
    }

    public static ScheduleEntity adminToEntity(ScheduleEntity entity, AdminAdvertScheduleDto data) {
        entity.setBlockIndex(data.getBlockIndex());
        entity.setIcon(data.getIcon());
        entity.setDescription(data.getDescription());
        entity.setTitle(data.getTitle());
        entity.setImgUrl(data.getImgUrl());
        entity.setLinkUrl(data.getLinkUrl());
        entity.setBlockKey(data.getBlockKey());
        entity.setTitle(data.getTime());
        return entity;
    }

    public static ScheduleEntity adminToEntity(AdminAdvertScheduleDto data) {
        ScheduleEntity entity = new ScheduleEntity();
        entity.setBlockIndex(data.getBlockIndex());
        entity.setIcon(data.getIcon());
        entity.setDescription(data.getDescription());
        entity.setTitle(data.getTitle());
        entity.setImgUrl(data.getImgUrl());
        entity.setLinkUrl(data.getLinkUrl());
        entity.setBlockKey(data.getBlockKey());
        entity.setId(data.getId());
        entity.setTitle(data.getTime());
        return entity;
    }
}