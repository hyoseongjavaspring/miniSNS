package kr.hs.dgsw.demo.Service;

import kr.hs.dgsw.demo.Domain.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User login(User user);
    User register(User user);

}
