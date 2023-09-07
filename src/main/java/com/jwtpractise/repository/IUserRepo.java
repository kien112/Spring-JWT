package com.jwtpractise.repository;

import com.jwtpractise.model.DTO.ICountRole;
import com.jwtpractise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    @Query(nativeQuery = true, value =
            "select role.name, count(*) as 'number' " +
                    "from user_role_set " +
                    "join role on role.id = user_role_set.role_id group by role.user_id;")
    Iterable<ICountRole> getRoleNumber();
}
