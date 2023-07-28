package com.example.authsample.controller;

import com.example.authsample.common.exception.PendekarException;
import com.example.authsample.common.response.CommonResponses;
import com.example.authsample.common.response.CustomReturn;
import com.example.authsample.config.JwtUtil;
import com.example.authsample.service.RequestTokenService;
import com.example.authsample.service.UserProfileService;
import com.example.authsample.wrapper.RequestLoginWrapper;
import com.example.authsample.wrapper.UserProfileWrapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    private final JwtUtil jwtUtil;
    private final UserProfileService userProfileService;
    private final RequestTokenService requestTokenService;

    public AuthenticationController(JwtUtil jwtUtil, UserProfileService userProfileService, RequestTokenService requestTokenService) {
        this.jwtUtil = jwtUtil;
        this.userProfileService = userProfileService;
        this.requestTokenService = requestTokenService;
    }

    @PostMapping(value = "/login")
    public CustomReturn<UserProfileWrapper> login(@RequestBody RequestLoginWrapper wrapper, HttpServletResponse response) throws PendekarException {
        CommonResponses<UserProfileWrapper> responses = new CommonResponses<>();
        boolean result = userProfileService.login(wrapper);
        try {
            if (result) {
                UserProfileWrapper profileWrapper = userProfileService.findByUsername(wrapper.getUsername());
                final String jwt = jwtUtil.generateToken(wrapper.getUsername());
                response.addHeader("Authorization", "Bearer " + jwt);
                requestTokenService.save(jwt);
                return responses.commonSuccessLogin(profileWrapper);
            } else {
                return responses.commonFailedLogin();
            }
        } catch (PendekarException e) {
            e.printStackTrace();
            return responses.commonFailedError();
        }

    }
}
