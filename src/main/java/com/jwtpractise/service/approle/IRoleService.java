package com.jwtpractise.service.approle;

import com.jwtpractise.model.Role;
import com.jwtpractise.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByUsername(String name);
}
