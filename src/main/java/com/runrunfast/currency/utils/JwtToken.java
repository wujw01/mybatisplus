package com.runrunfast.currency.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * <p>@Author: james</p>
 * <p>@Description: 添加说明</P>
 * <p>@Date: 创建日期 2018/11/12 14:54</P>
 * <p>@version V1.0</p>
 **/
public class JwtToken {

    /**
     * token秘钥，请勿泄露，请勿随便修改
     * 这里的token将来做动态密钥，每个不同的模块进行不同的密钥切换
     **/
    public static final String SECRET = "poy7go/IVV7+rly0uJY9Vw==";

    /**
     * token 过期时间: 60小时
     **/
    public static final int CALENDARFIELD = Calendar.HOUR;
    public static final int CALENDARINTERVAL = 60;

    /***
     * <p>@author: James</p>
     * <p>@param: [userId :登录成功后用户userId, 参数userId不可传空]</P>
     * <p>@return: java.lang.String</P>
     * <p>@date: 2018/11/12 14:55</P>
     * <p>@description: JWT生成Token</p>
     */
    public static String createToken(String userId) throws Exception {

        Date iatDate = new Date();

        /**
         * expire time
         */
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(CALENDARFIELD, CALENDARINTERVAL);
        Date expiresDate = nowTime.getTime();

        /**
         * header Map
         */
        Map<String, Object> map = new HashMap<>(16);
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        /**
         * build token
         * param backups {iss:Service, aud:APP}
         * withHeader : header
         * withClaim : payload
         * withIssuedAt : sign time
         * withExpiresAt : expire time
         * sign : signature
         */
        return JWT.create().withHeader(map)
                .withClaim("iss", "Service")
                .withClaim("aud", "APP")
                .withClaim("user_id", null == userId || "".equals(userId) ? null : userId.toString())
                .withIssuedAt(iatDate)
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(SECRET));
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [token：生成的token]</P>
     * <p>@return: java.util.Map<java.lang.String,com.auth0.jwt.interfaces.Claim></P>
     * <p>@date: 2018/11/12 14:56</P>
     * <p>@description: 解密Token</p>
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        Map<String, Claim> claims = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
            claims = jwt.getClaims();
            Optional.ofNullable(claims).orElseThrow(IllegalArgumentException::new);
        } catch (Exception e) {
            // e.printStackTrace();
            // token 校验失败, 抛出Token验证非法异常
            System.out.println("IllegalArgumentException : token 校验失败");
        }
        return claims;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [token：已生成的token]</P>
     * <p>@return: java.lang.Long</P>
     * <p>@date: 2018/11/12 14:56</P>
     * <p>@description: 根据Token获取user_id</p>
     */
    public static Long getAppUID(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim userIdClaim = claims.get("user_id");
        if (null == userIdClaim || StringUtils.isEmpty(userIdClaim.asString())) {
            // token 校验失败, 抛出Token验证非法异常
        }
        return Long.valueOf(userIdClaim.asString());
    }

    public static void main(String[] args){
        try {
            String token = createToken("1234567879000");
            System.out.println("加密的：token ======== " + token);
            Long appUID = getAppUID(token);
            System.out.println("根据加密的token获取token中的user_id ======== " + appUID);
            Map<String, Claim> claimMap = verifyToken(token);
            System.out.println("解密的：token ======== " + claimMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
