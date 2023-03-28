package Controllers;

import co.DevelHopeHelloWorld.ormmongodb.Entities.UserEntity;
import co.DevelHopeHelloWorld.ormmongodb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

         @PostMapping("")
        public UserEntity createUser(@RequestBody UserEntity user) {
             return userRepository.save(user);
         }

         @GetMapping
         public List<UserEntity>getUsers(){
             return userRepository.findAll();
         }
        @GetMapping("/{id}")
        public UserEntity getUser(@PathVariable String id) throws Exception{  //prendi un user
             Optional<UserEntity> user=userRepository.findById(id);
             if (user.isPresent()){
                 return user.get();
             }else {
                 throw new Exception("User is not found");
             }
        }
        @PutMapping("/{id}")
        public UserEntity editUser(@PathVariable String id, @RequestBody UserEntity user)throws Exception{
             if (!userRepository.existsById(id))throw new Exception("User is not found");
             user.setId(id);
             return userRepository.save(user);
        }
        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable String id){
            userRepository.deleteById(id);
        }




}
