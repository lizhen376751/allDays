package com.dudu.lizhen.jwttest;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Map;

/**
 * jwt代码的封装
 * Created by lizhen on 2018/5/6.
 */
public class JwtTokenProvider {
    SecretKeySpec secretKeySpec;

    /**
     *
     * @param key 秘钥
     */
    public JwtTokenProvider(String key) {
        SecretKeySpec secretKeySpec2 = new SecretKeySpec(key.getBytes(), SignatureAlgorithm.HS512.getJcaName());
        this.secretKeySpec = secretKeySpec2;
    }

    /**
     * 生成token
     * @param claims
     * @return
     */
    public String createToken(Claims claims) {
        String compact = Jwts.builder().setPayload(JSONObject.toJSONString(claims)).compressWith(CompressionCodecs.DEFLATE).signWith(SignatureAlgorithm.HS512, secretKeySpec).compact();

        return compact;
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(secretKeySpec).parseClaimsJws(token).getBody();
    }


//    private static Logger log = LoggerFactory.getLogger(JavaWebToken.class);

    //该方法使用HS256算法和Secret:bankgl生成signKey
    private static Key getKeyInstance() {
        //We will sign our JavaWebToken with our ApiKey secret
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("bankgl");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }

    //使用HS256签名算法和生成的signingKey最终的Token,claims中是有效载荷
    public static String createJavaWebToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();
    }

    //解析Token，同时也能验证Token，当验证失败返回null
    public static Map<String, Object> parserJavaWebToken(String jwt) {
        try {
            Map<String, Object> jwtClaims =
                    Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
            return jwtClaims;
        } catch (Exception e) {
//            log.error("json web token verify failed");
            return null;
        }
    }
}
