package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.user;
import net.javaguides.springboot.service.userService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
//@RequestMapping("api/users")
public class userController {

    private userService userService;

    @GetMapping("api/users")
    public ResponseEntity<List<user>> returnAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("api/users/{ID}")
    public ResponseEntity<user> findbyid(@PathVariable("ID") Long id){
        return new ResponseEntity<>(userService.findByID(id), HttpStatus.OK);
    }

    @PostMapping("api/users")
    public ResponseEntity<user> createUser(@RequestBody user user){
        user savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("api/users/{ID}")
    public ResponseEntity<user> updateUser(@RequestBody user user, @PathVariable("ID") Long id){
        user updatedUser = userService.updateUser(id,user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("api/users/{ID}")
    public ResponseEntity<String> deleteUser(@PathVariable("ID") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
