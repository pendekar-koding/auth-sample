package com.example.authsample.service.impl;

import com.example.authsample.common.exception.PendekarException;
import com.example.authsample.service.UserProfileService;
import com.example.authsample.user.repository.UserProfileRepository;
import com.example.authsample.user.repository.UserRoleRepository;
import com.example.authsample.wrapper.UserProfileWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private final static Logger logger = LogManager.getLogger(UserProfileServiceImpl.class.getName());

    private final UserProfileRepository userProfileRepository;
    private final UserRoleRepository userRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository,
                                  UserRoleRepository userRoleRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Long getNum() {
        return null;
    }

    @Override
    public UserProfileWrapper save(UserProfileWrapper entity) throws PendekarException {
        return null;
    }

    @Override
    public UserProfileWrapper getById(Long pk) throws PendekarException {
        return null;
    }

    @Override
    public Boolean delete(Long pk) throws PendekarException {
        return null;
    }

    @Override
    public List<UserProfileWrapper> getAll() throws PendekarException {
        return null;
    }

    @Override
    public void deleteAll() throws PendekarException {

    }

    @Override
    public Page<UserProfileWrapper> getPageableList(String sSearch, int startPage, int pageSize, Sort sort) throws PendekarException {
        return null;
    }
}
