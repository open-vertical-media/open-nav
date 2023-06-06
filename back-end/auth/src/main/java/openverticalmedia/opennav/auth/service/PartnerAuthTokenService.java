package openverticalmedia.opennav.auth.service;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import openverticalmedia.opennav.auth.config.AuthProperties;
import openverticalmedia.opennav.auth.dto.TokenData;
import openverticalmedia.opennav.auth.dto.TokenDto;
import openverticalmedia.opennav.auth.entity.AccountEntity;
import openverticalmedia.opennav.auth.model.PowerModel;
import openverticalmedia.opennav.auth.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartnerAuthTokenService {
    @Autowired
    AuthProperties properties;
    @Autowired
    AccountRepository repository;

    public TokenDto post(TokenData data) {
        TokenDto tokenDto = new TokenDto();
        Optional<AccountEntity> userOptional = repository.findByNameAndPassword(data.getName(), data.getPassword());
        if (userOptional.isPresent()) {
            AccountEntity account = userOptional.get();
            Optional<PowerModel> partnerOptional = account.getPowers().stream()
                    .filter(p -> p.getRange().equals("partner"))
                    .findFirst();
            if (partnerOptional.isPresent()) {
                String accessToken = JWT.create()
                        .withKeyId(NumberUtil.toStr(account.getId()))
                        .withClaim("name", account.getName())
                        .withExpiresAt(DateUtil.date().offset(DateField.HOUR, 24))
                        .sign(Algorithm.HMAC256(properties.getPartnerSalt()));
                tokenDto.setAccessToken(accessToken);
                return tokenDto;
            }
        }
        return null;
    }
}