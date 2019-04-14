package kr.hs.dgsw.demo.Controller;

import kr.hs.dgsw.demo.Domain.User;
import kr.hs.dgsw.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return this.userService.login(user);
    }

//    @PostMapping("/register")
//    public User register(@RequestPart MultipartFile srcFile, @RequestPart User user){
//        return this.userService.register(user);
//    }
}
