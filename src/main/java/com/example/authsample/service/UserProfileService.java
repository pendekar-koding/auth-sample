package com.example.authsample.service;

import com.example.authsample.common.exception.PendekarException;
import com.example.authsample.common.service.CommonService;
import com.example.authsample.wrapper.RequestLoginWrapper;
import com.example.authsample.wrapper.UserProfileWrapper;

public interface UserProfileService extends CommonService<UserProfileWrapper, Long> {

    boolean login(RequestLoginWrapper wrapper) throws PendekarException;
    UserProfileWrapper findByUsername(String username) throws PendekarException;
}
