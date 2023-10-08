package com.suhag_rest_api.suhag_rest_api.Repository;

import org.springframework.data.repository.CrudRepository;

import com.suhag_rest_api.suhag_rest_api.Entities.LoginUser;

public interface LoginRepository extends CrudRepository<LoginUser,Integer> {
    public LoginUser findByEmail(String Email);
}
