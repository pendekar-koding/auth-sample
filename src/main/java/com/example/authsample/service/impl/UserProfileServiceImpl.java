package com.example.authsample.service.impl;

import com.example.authsample.common.exception.PendekarException;
import com.example.authsample.service.UserProfileService;
import com.example.authsample.user.UserProfile;
import com.example.authsample.user.UserRole;
import com.example.authsample.user.repository.UserProfileRepository;
import com.example.authsample.user.repository.UserRoleRepository;
import com.example.authsample.wrapper.RequestLoginWrapper;
import com.example.authsample.wrapper.UserProfileWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

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
        return userProfileRepository.count();
    }

    @Override
    public UserProfileWrapper save(UserProfileWrapper entity) throws PendekarException {
        logger.info("save = " + entity.getName());
        return toWrapper(userProfileRepository.save(toEntity(entity)));
    }

    @Override
    public UserProfileWrapper getById(Long pk) throws PendekarException {
        Optional<UserProfile> optional = userProfileRepository.findById(pk);
        return optional.map(this::toWrapper).orElse(null);
    }

    @Override
    public UserProfileWrapper findByUsername(String username) throws PendekarException {
        Optional<UserProfile> optional = userProfileRepository.findByDeletedIsFalseAndUsername(username);
        return optional.map(this::toWrapper).orElse(null);
    }

    @Override
    public Boolean delete(Long pk) throws PendekarException {
        Optional<UserProfile> optional = userProfileRepository.findById(pk);
        if (optional.isPresent()) {
            UserProfile newData = new UserProfile();
            newData.setDeleted(true);
            newData.setVersion(1);
            newData.setModifiedDate(new Date());
            userProfileRepository.save(newData);
        }
        return true;
    }

    @Override
    public List<UserProfileWrapper> getAll() throws PendekarException {
        return toWrapperList((List<UserProfile>) userProfileRepository.findAll());
    }

    @Override
    public void deleteAll() throws PendekarException {
        // Not Implement
    }

    @Override
    public Page<UserProfileWrapper> getPageableList(String sSearch, int startPage, int pageSize, Sort sort) throws PendekarException {
        return null;
    }

    private UserProfileWrapper toWrapper(UserProfile model) {
        UserProfileWrapper wrapper = new UserProfileWrapper();
        wrapper.setId(model.getId());
        wrapper.setVersion(model.getVersion());
        wrapper.setDeleted(model.getDeleted());
        wrapper.setDescription(model.getDescription());

        wrapper.setUsername(model.getUsername());
//        wrapper.setPassword(model.getPassword());
        wrapper.setEmail(model.getEmail());
        wrapper.setName(model.getName());

        if (model.getUserRole() != null) {
            UserRole role = model.getUserRole();
            wrapper.setIdRole(role.getId());
            wrapper.setRoleValue(role.getValue());
        }

        return wrapper;
    }


    private List<UserProfileWrapper> toWrapperList(List<UserProfile> modelList) {
        List<UserProfileWrapper> wrappers = new ArrayList<>();
        if (modelList != null && !modelList.isEmpty()) {
            for (UserProfile model : modelList) {
                wrappers.add(toWrapper(model));
            }
        }
        return wrappers;
    }

    private UserProfile toEntity(UserProfileWrapper wrapper) {
        UserProfile model = new UserProfile();
        if (wrapper.getUsername() != null) {
            Optional<UserProfile> optional = userProfileRepository.findByDeletedIsFalseAndUsername(wrapper.getUsername());
            if (optional.isPresent()) {
                model = optional.get();
            }
        }

        model.setDeleted(wrapper.getDeleted());
        model.setVersion(1);
        model.setDescription(wrapper.getDescription());

        model.setName(wrapper.getName());
        model.setUsername(wrapper.getUsername());
        model.setPassword(bCryptPasswordEncoder.encode(wrapper.getPassword()));
        model.setEmail(wrapper.getEmail());

        if (wrapper.getIdRole() != null) {
            Optional<UserRole> userRoleOptional = userRoleRepository.findById(wrapper.getIdRole());
            if (userRoleOptional.isPresent()) {
                model.setUserRole(userRoleOptional.get());
            }
        }

        return model;
    }

    @Override
    public boolean login(RequestLoginWrapper wrapper) throws PendekarException {
        if (wrapper.getUsername() != null && wrapper.getPassword() != null) {
            Boolean isExist = userProfileRepository.existsByDeletedIsFalseAndUsername(wrapper.getUsername());
            if (isExist) {
                Optional<UserProfile> optional = userProfileRepository.findByDeletedIsFalseAndUsername(wrapper.getUsername());
                if (optional.isPresent()) {
                    Boolean result = comparePassword(optional.get(), wrapper.getPassword());
                    return result;
                }
            } else {
                return false;
            }
        }
        return false;
    }


    private Boolean comparePassword(UserProfile userProfile, String password) {
        if (bCryptPasswordEncoder.matches(password, userProfile.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
