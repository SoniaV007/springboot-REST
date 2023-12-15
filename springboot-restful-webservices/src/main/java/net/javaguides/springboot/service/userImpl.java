package net.javaguides.springboot.service;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.user;
import net.javaguides.springboot.repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class userImpl implements userService{

    public userRepository UserRepo;
    @Override
    public user createUser(user u){
        return UserRepo.save(u);
    }
    @Override
    public List<user> findAll(){
       return UserRepo.findAll();
    }
    @Override
    public user updateUser(Long id,user user){
        user existingUser = UserRepo.findById(id).get();
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        return UserRepo.save(existingUser);
    }
    @Override
    public void deleteUser(Long id){
        UserRepo.deleteById(id);
    }
    @Override
    public user findByID(Long id){
        Optional<user> newUser = UserRepo.findById(id);
        return newUser.get();
    }
}
