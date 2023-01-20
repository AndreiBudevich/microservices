package com.mytt.authorizationservice.web.user;

import com.mytt.authorizationservice.model.User;
import com.mytt.authorizationservice.repository.UserRepository;
import com.mytt.authorizationservice.util.UserUtil;
import com.mytt.common.error.IllegalRequestDataException;
import com.mytt.common.model.Role;
import com.mytt.common.web.JwtUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Set;

@Slf4j
public abstract class AbstractUserController {

    @Autowired
    protected UserRepository repository;

    @Autowired
    private UniqueMailValidator emailValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(emailValidator);
    }

    public ResponseEntity<User> get(int id) {
        log.info("get {}", id);
        return ResponseEntity.of(repository.findById(id));
    }

    public void delete(int id) {
        log.info("delete {}", id);
        repository.deleteExisted(id);
    }

    protected User prepareAndSave(User user) {
        user.setRoles(Set.of(Role.USER));
        return repository.save(UserUtil.prepareToSave(user));
    }

    protected User findByJwtUser(JwtUser jwtUser) {
        return repository.findById(jwtUser.id()).orElseThrow(
                () -> new IllegalRequestDataException("User id='" + jwtUser.getId() + "' was not found"));
    }
}