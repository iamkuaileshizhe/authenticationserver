package com.trying.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationSuccessHandler  extends SavedRequestAwareAuthenticationSuccessHandler {

//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//
//        String header = request.getHeader("Authorization");
//        if (header == null || !header.toLowerCase().startsWith("basic ")) {
//            throw new UnapprovedClientAuthenticationException("请求头中没有clientId");
//        }
//
//        String[] tokens = extractAndDecodeHeader(header, request);
//        assert tokens.length == 2;
//
//        String clientId = tokens[0];
//        String clientSecret = tokens[1];
//        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
//        if (clientDetails == null) {
//            throw new UnapprovedClientAuthenticationException("clientId配置信息不存在,clientId=" + clientId);
//        } else if (!new BCryptPasswordEncoder().matches(clientSecret, clientDetails.getClientSecret())) {
//            throw new UnapprovedClientAuthenticationException("clientSecret不匹配,clientId=" + clientId);
//        }
//
//        // grantType 为自定义的"custom"
//        TokenRequest tokenRequest = new TokenRequest(new HashMap<>(), clientId, clientDetails.getScope(), "custom");
//        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
//        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
//        OAuth2AccessToken accessToken = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
//
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write(objectMapper.writeValueAsString(accessToken));
//    }
}
