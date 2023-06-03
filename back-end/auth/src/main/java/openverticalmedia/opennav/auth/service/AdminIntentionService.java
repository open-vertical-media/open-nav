package openverticalmedia.opennav.auth.service;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import openverticalmedia.opennav.auth.config.AuthProperties;
import openverticalmedia.opennav.auth.dto.JwtData;
import openverticalmedia.opennav.auth.dto.JwtDto;
import openverticalmedia.opennav.auth.entity.user.UserEntity;
import openverticalmedia.opennav.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminIntentionService {
    @Autowired
    AuthProperties properties;
    @Autowired
    UserRepository repository;
    public JwtDto post(JwtData data){
        JwtDto jwtDto=new JwtDto();
        Optional<UserEntity> userOptional = repository.findByNameAndPassword(data.getName(), data.getPassword());
        if(userOptional.isPresent()){
            UserEntity user = userOptional.get();
            String accessToken = JWT.create()
                    .withKeyId(NumberUtil.toStr(user.getId()))
                    .withClaim("name", user.getName())
                    .withExpiresAt(DateUtil.date().offset(DateField.HOUR, 24))
                    .sign(Algorithm.HMAC256(properties.getAdminSalt()));
            jwtDto.setAccessToken(accessToken);
            return jwtDto;
        }
        return null;
    }
}
