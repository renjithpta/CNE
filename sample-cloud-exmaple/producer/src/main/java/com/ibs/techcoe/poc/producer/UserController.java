package com.ibs.techcoe.poc.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibs.techcoe.poc.producer.domain.User;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("api/v1/")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @ApiOperation(value = "createuser", nickname = "Create User")
    @PostMapping("/createuser")
    @ApiResponses(value = { 
            @ApiResponse(code = 201, message = "Success", response = User.class),
           @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public ResponseEntity<?> saveUser(@RequestBody User user) {
       	user.setId(System.currentTimeMillis());
       	return new ResponseEntity<User>(userRepository.save(user),HttpStatus.CREATED);
      
    }
    
   // @Scheduled(fixedRate = 5000)
	public void  orderSource() {
		User newUser = new User();
        newUser.setId(System.currentTimeMillis());
        newUser.setUsername("smaple test");
        userRepository.save(newUser);
	}

}
