package com.azriasat.nextjsspringapp.service;

import com.azriasat.nextjsspringapp.entity.Users;
import com.azriasat.nextjsspringapp.models.UsersModel;
import com.azriasat.nextjsspringapp.repository.UsersRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public UsersModel saveUser(UsersModel usersModel) {
        Users users = new Users();
        BeanUtils.copyProperties(usersModel,users);
        usersRepository.save(users);
        return usersModel;
    }

    @Override
    public UsersModel getUserWithId(Long id) {
        Users users= usersRepository.findById(id).get();
        UsersModel usersModel = new UsersModel();
        BeanUtils.copyProperties(users,usersModel);
        return usersModel;
    }

    @Override
    public UsersModel updateUser(Long id, UsersModel usersModel) {
        Users users = usersRepository.findById(id).get();
        
        users.setEmailId(usersModel.getEmailId());
        users.setFirstName(usersModel.getFirstName());
        users.setLastName(usersModel.getLastName());
        usersRepository.save(users);
        return usersModel;

    }

    @Override
    public boolean deleteUser(Long id) {
        Users users = usersRepository.findById(id).get();
        usersRepository.delete(users);
        return true;
    }

    @Override
    public List<UsersModel> usersList() {
        List<Users> users = usersRepository.findAll();
       List<UsersModel> userModels = users.stream().map(user-> new UsersModel(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmailId())).collect(Collectors.toList());

        return userModels;
    }
}
