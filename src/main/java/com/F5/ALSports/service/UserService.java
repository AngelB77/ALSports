package com.F5.ALSports.service;


import com.F5.ALSports.model.Product;
import com.F5.ALSports.model.User;
import com.F5.ALSports.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository; }
    //
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User addUser(User newUser){

        return userRepository.save(newUser);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


    public Optional<User> findUser(int id) {
        return userRepository.findById(id);
    }

    public User updatedUser(int id, User updatedUser) {
        //Buscar user por id
        Optional<User> foundUser = userRepository.findById(id);

        if(foundUser.isPresent()) {
            User existingUser = foundUser.get();

            //Actualizar los campos
            existingUser.setName(updatedUser.getName());

            //Guarda el producto
            return userRepository.save(existingUser);

        }
        //Enviar mensaje al usuario
        throw new RuntimeException("User not found with id: " + id);
    }
}



