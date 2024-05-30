package me.miv.toyserver.security.service;

import me.miv.toyserver.security.domain.JwtToken;
import me.miv.toyserver.security.dto.request.TokenRequest;
import me.miv.toyserver.security.repository.JwtTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class JwtTokenService {
    private final JwtTokenRepository jwtTokenRepository;

    public JwtTokenService(JwtTokenRepository jwtTokenRepository) {
        this.jwtTokenRepository = jwtTokenRepository;
    }

    @Transactional
    public Long save(TokenRequest tokenRequest) {
        JwtToken jwtToken = new JwtToken(tokenRequest.getLoginId(), tokenRequest.getAccessToken(),
                tokenRequest.getRefreshToken(), tokenRequest.getExpired());

        return jwtTokenRepository.save(jwtToken);
    }

    @Transactional
    public Long updateAccessToken(String accessToken, String refreshToken) {
        return jwtTokenRepository.updateTokenByRefreshToken(accessToken, refreshToken);
    }

    @Transactional
    public Long expireTokenByLoginId(String loginId) {
        return jwtTokenRepository.expireTokenByLoginId(loginId);
    }

    public boolean checkRefreshTokenExpired(String loginId, String refreshToken) {
        JwtToken findToken = jwtTokenRepository.getTokenByLoginId(loginId);
        return findToken == null || findToken.getRefreshToken() != refreshToken;
    }

    public boolean checkAccessTokenExpired(String loginId, String accessToken) {
        JwtToken findToken = jwtTokenRepository.getTokenByLoginId(loginId);
        return findToken == null || findToken.getAccessToken() != accessToken;
    }

    @Transactional
    public Long expireRefreshToken(String refreshToken) {
        return jwtTokenRepository.expireRefreshToken(refreshToken);
    }



}
