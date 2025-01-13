package sorfian.springboot_restful_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sorfian.springboot_restful_api.entity.User;
import sorfian.springboot_restful_api.model.UserResponse;
import sorfian.springboot_restful_api.service.UserService;
import sorfian.springboot_restful_api.model.RegisterUserRequest;
import sorfian.springboot_restful_api.model.WebResponse;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RegisterUserRequest request) {
        userService.register(request);
        return WebResponse.<String>builder().data("OK").build();
    }

    public WebResponse<UserResponse> get(User user) {
        UserResponse userResponse = userService.get(user);
        return  WebResponse.<UserResponse>builder().data(userResponse).build();
    }

}
