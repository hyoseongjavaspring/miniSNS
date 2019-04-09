package kr.hs.dgsw.demo.Service;

import kr.hs.dgsw.demo.Domain.User;
import kr.hs.dgsw.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(User user) {
        return this.userRepository.findByIdAndPw(user.getId(), user.getPw())
                .orElse(null);
    }

    @Override
    public User register(User user) {
        Optional<User> found = this.userRepository.findById(user.getId());
        if(found.isPresent()){
            return null;
        } else {
            return this.userRepository.save(user);
        }
    }
}
