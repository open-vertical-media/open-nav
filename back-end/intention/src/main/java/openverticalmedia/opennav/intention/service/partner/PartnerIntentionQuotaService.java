package openverticalmedia.opennav.intention.service.partner;

import cn.hutool.core.util.StrUtil;
import openverticalmedia.opennav.common.model.PartnerModel;
import openverticalmedia.opennav.intention.entity.IntentionQuotaEntity;
import openverticalmedia.opennav.intention.mapper.partner.PartnerIntentionQuotaMapper;
import openverticalmedia.opennav.intention.repository.IntentionQuotaRepository;
import openverticalmedia.opennav.common.model.ManagerModel;
import openverticalmedia.opennav.common.model.Pager;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionQuotaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerIntentionQuotaService {
    @Autowired
    IntentionQuotaRepository repository;

    public Pager<PartnerIntentionQuotaDto> query(PartnerModel partner, String type, int page, int size) {
        Pager<PartnerIntentionQuotaDto> result = new Pager<>();
        Page<IntentionQuotaEntity> entityPage;
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        if (StrUtil.isNotBlank(type)) {
            entityPage = repository.queryByPartnerIdAndType(partner.getId(), type, pageRequest);
        } else {
            entityPage = repository.queryByPartnerId(partner.getId(), pageRequest);
        }
        result.setCount(entityPage.getTotalElements());
        List<PartnerIntentionQuotaDto> list = entityPage.stream()
                .map(PartnerIntentionQuotaMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }
}
