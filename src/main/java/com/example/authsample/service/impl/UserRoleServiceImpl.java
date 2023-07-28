package com.example.authsample.service.impl;

import com.example.authsample.common.exception.PendekarException;
import com.example.authsample.common.utils.Utils;
import com.example.authsample.service.UserRoleService;
import com.example.authsample.user.UserRole;
import com.example.authsample.user.repository.UserRoleRepository;
import com.example.authsample.wrapper.UserRoleWrapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Long getNum() {
        return userRoleRepository.count();
    }

    @Override
    public UserRoleWrapper save(UserRoleWrapper entity) throws PendekarException {
        return toWrapper(userRoleRepository.save(toEntity(entity)));
    }

    @Override
    public UserRoleWrapper getById(Long pk) throws PendekarException {
        Optional<UserRole> optional = userRoleRepository.findById(pk);
        return optional.map(this::toWrapper).orElse(null);
    }

    @Override
    public Boolean delete(Long pk) throws PendekarException {
        Optional<UserRole> optional = userRoleRepository.findById(pk);
        if (optional.isPresent()) {
            UserRole model = optional.get();
            model.setDeleted(true);
            model.setVersion(1);
            model.setModifiedDate(new Date());
            userRoleRepository.save(model);
        }
        return true;
    }

    @Override
    public List<UserRoleWrapper> getAll() throws PendekarException {
        return toWrapperList((List<UserRole>) userRoleRepository.findAll());
    }

    @Override
    public void deleteAll() throws PendekarException {
        //Not Implement
    }

    @Override
    public Page<UserRoleWrapper> getPageableList(String sSearch, int startPage, int pageSize, Sort sort) throws PendekarException {
        return null;
    }

    private UserRoleWrapper toWrapper(UserRole model) {
        UserRoleWrapper wrapper = new UserRoleWrapper();
        wrapper.setId(model.getId());
        wrapper.setDeleted(model.getDeleted());
        wrapper.setVersion(model.getVersion());
        wrapper.setDescription(model.getDescription());

        wrapper.setCode(model.getCode());
        wrapper.setValue(model.getValue());
        return wrapper;
    }

    private UserRole toEntity(UserRoleWrapper wrapper) {
        UserRole model = new UserRole();
        if (wrapper.getValue() != null) {
            Optional<UserRole> optional = userRoleRepository.findByDeletedIsFalseAndValue(wrapper.getValue());
            if (optional.isPresent()) {
                model = optional.get();
            }
        }

        model.setDeleted(wrapper.getDeleted());
        model.setVersion(1);

        model.setValue(wrapper.getValue());
        model.setCode(Utils.replaceSpecialCharacter(wrapper.getValue()) + "-" +Utils.generateRandomValue(5));

        return model;
    }

    private List<UserRoleWrapper> toWrapperList(List<UserRole> modelList) {
        List<UserRoleWrapper> wrappers = new ArrayList<>();
        if (modelList != null && !modelList.isEmpty()) {
            for (UserRole model : modelList) {
                wrappers.add(toWrapper(model));
            }
        }
        return wrappers;
    }
}
