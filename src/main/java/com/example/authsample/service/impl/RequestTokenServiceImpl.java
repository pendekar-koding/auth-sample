package com.example.authsample.service.impl;

import com.example.authsample.config.JwtUtil;
import com.example.authsample.service.RequestTokenService;
import com.example.authsample.user.RequestToken;
import com.example.authsample.user.UserProfile;
import com.example.authsample.user.repository.RequestTokenRepository;
import com.example.authsample.user.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestTokenServiceImpl implements RequestTokenService {
    private final RequestTokenRepository repository;
    private final UserProfileRepository userProfileRepository;
    private final JwtUtil jwtUtil;

    public RequestTokenServiceImpl(RequestTokenRepository repository, UserProfileRepository userProfileRepository, JwtUtil jwtUtil) {
        this.repository = repository;
        this.userProfileRepository = userProfileRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void save(String token) {
        RequestToken model = new RequestToken();
        UserProfile data = new UserProfile();
        if (token != null) {
            String username = jwtUtil.extractUsername(token);
            if (username != null) {
                Optional<UserProfile> optional = userProfileRepository.findByDeletedIsFalseAndUsername(username);
                if (optional.isPresent()) {
                    data = optional.get();
                    deleteToken(data);
                }
            }
            model.setToken(token);
            model.setExpDate(jwtUtil.extractExpiration(token));
            model.setUserProfile(data);

            model.setDeleted(false);
            model.setVersion(1);
            model.setModifiedBy(username);
            repository.save(model);
        }
    }

    private void deleteToken(UserProfile userProfile) {
        if (userProfile != null) {
            List<RequestToken> requestTokens = repository.findAllByDeletedIsFalseAndUserProfile(userProfile);
            if (requestTokens != null && !requestTokens.isEmpty()) {
                for (RequestToken token : requestTokens) {
                    token.setDeleted(true);
                    token.setVersion(1);
                    repository.save(token);
                }
            }
        }
    }
}
