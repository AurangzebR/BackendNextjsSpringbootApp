package com.azriasat.nextjsspringapp.service;

import com.azriasat.nextjsspringapp.models.UsersModel;

import java.util.List;

public interface UsersService {
    UsersModel saveUser(UsersModel usersModel);

    UsersModel getUserWithId(Long id);

    UsersModel updateUser(Long id, UsersModel usersModel);

    boolean deleteUser(Long id);

    List<UsersModel> usersList();
}
