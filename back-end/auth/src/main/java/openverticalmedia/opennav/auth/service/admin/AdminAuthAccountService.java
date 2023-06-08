package openverticalmedia.opennav.auth.service.admin;

import openverticalmedia.opennav.auth.dto.admin.AdminAuthAccountDto;
import openverticalmedia.opennav.auth.entity.AccountEntity;
import openverticalmedia.opennav.auth.dto.admin.AdminAuthAccountData;
import openverticalmedia.opennav.auth.mapper.admin.AdminAuthAccountMapper;
import openverticalmedia.opennav.auth.repository.AccountRepository;
import openverticalmedia.opennav.common.exception.NotFoundException;
import openverticalmedia.opennav.common.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminAuthAccountService {
    @Autowired
    AccountRepository repository;

    public Pager<AdminAuthAccountDto> query(String name, int page, int size) {
        Pager<AdminAuthAccountDto> result = new Pager<>();
        Page<AccountEntity> entityPage = repository.query(name, PageRequest.of(page - 1, size));
        result.setCount(entityPage.getTotalElements());
        List<AdminAuthAccountDto> list = entityPage.stream()
                .map(AdminAuthAccountMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }

    public AdminAuthAccountDto get(long id) {
        Optional<AccountEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            AccountEntity entity = entityOptional.get();
            return AdminAuthAccountMapper.entityToDto(entity);
        }
        throw new NotFoundException("找不到该账号："+id);
    }

    public long post(AdminAuthAccountData data) {
        AccountEntity entity = AdminAuthAccountMapper.dataToEntity(data);
        entity = repository.save(entity);
        return entity.getId();
    }

    public boolean put(long id, AdminAuthAccountData data) {
        Optional<AccountEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            AccountEntity entity = entityOptional.get();
            entity = AdminAuthAccountMapper.dataToEntity(entity, data);
            repository.save(entity);
            return true;
        }
        return false;
    }
    public void delete(long id){
        repository.deleteById(id);
    }
}