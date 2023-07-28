//package com.example.authsample.config;
//
//import com.example.authsample.common.exception.PendekarException;
//import com.example.authsample.service.UserProfileService;
//import com.example.authsample.service.UserRoleService;
//import com.example.authsample.wrapper.UserProfileWrapper;
//import com.example.authsample.wrapper.UserRoleWrapper;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AdminUser implements ApplicationRunner {
//
//    private final UserProfileService profileService;
//    private final UserRoleService userRoleService;
//
//    public AdminUser(UserProfileService profileService, UserRoleService userRoleService) {
//        this.profileService = profileService;
//        this.userRoleService = userRoleService;
//    }
//
//
//    private UserRoleWrapper saveRole() throws PendekarException {
//        UserRoleWrapper newData = new UserRoleWrapper();
//        newData.setValue("ADM");
//        newData.setDeleted(false);
//        return userRoleService.save(newData);
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        UserProfileWrapper wrapper = new UserProfileWrapper();
//        UserRoleWrapper role = saveRole();
//        wrapper.setName("Administrator");
//        wrapper.setUsername("admin");
//        wrapper.setPassword("admin");
//        wrapper.setDeleted(false);
//        wrapper.setEmail("admin@mail.com");
//        if (role != null) {
//            wrapper.setIdRole(role.getId());
//            wrapper.setRoleValue(role.getValue());
//            profileService.save(wrapper);
//        }
//    }
//}
