package openverticalmedia.opennav.auth.mapper.admin;

import openverticalmedia.opennav.auth.dto.admin.AdminAuthAccountDto;
import openverticalmedia.opennav.auth.entity.AccountEntity;
import openverticalmedia.opennav.auth.dto.admin.AdminAuthAccountData;

public class AdminAuthAccountMapper {
    public static AdminAuthAccountDto entityToDto(AccountEntity entity){
        AdminAuthAccountDto dto=new AdminAuthAccountDto();
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setId(entity.getId());
        return dto;
    }
    public static  AccountEntity dataToEntity(AdminAuthAccountData data){
        AccountEntity entity=new AccountEntity();
        entity.setName(data.getName());
        entity.setPassword(data.getPassword());
        entity.setPowers(data.getPowers());
        return entity;
    }
    public static  AccountEntity dataToEntity(AccountEntity entity,AdminAuthAccountData data){
        entity.setName(data.getName());
        entity.setPassword(data.getPassword());
        entity.setPowers(data.getPowers());
        return entity;
    }
}
