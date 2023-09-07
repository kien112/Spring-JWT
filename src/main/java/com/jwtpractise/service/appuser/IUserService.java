package com.jwtpractise.service.appuser;

import com.jwtpractise.model.DTO.ICountRole;
import com.jwtpractise.model.User;
import com.jwtpractise.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByName(String name);
    Iterable<ICountRole> getRoleNumber();
}
