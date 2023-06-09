package openverticalmedia.opennav.auth.advice;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import openverticalmedia.opennav.auth.config.AuthProperties;
import openverticalmedia.opennav.common.annotation.PartnerController;
import openverticalmedia.opennav.common.model.PartnerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.security.auth.login.LoginException;

@ControllerAdvice(annotations = PartnerController.class)
public class PartnerAdvice {
    @Autowired
    AuthProperties properties;
    @ModelAttribute(name = "partnerModel")
    public PartnerModel managerModel(@RequestHeader(name = "Authorization", required = false) String jwt) throws LoginException {
        if (StrUtil.isNotBlank(jwt)) {
            Algorithm algorithm = Algorithm.HMAC256(properties.getPartnerSalt());
            JWTVerifier verifier =  JWT.require(algorithm)
                    .build();
            try {
                jwt = jwt.replace("bearer ", "")
                        .replace("Bearer ", "");
                DecodedJWT userJwt = verifier.verify(jwt);
                PartnerModel model = new PartnerModel();
                model.setId(NumberUtil.parseLong(userJwt.getKeyId()));
                model.setName(userJwt.getClaim("name").asString());
                return model;
            } catch (JWTVerificationException ignored) {
                throw new LoginException("校验失败");
            }
        }
        return null;
    }
}
