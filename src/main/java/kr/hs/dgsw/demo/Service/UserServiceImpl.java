package kr.hs.dgsw.demo.Service;

import kr.hs.dgsw.demo.Domain.User;
import kr.hs.dgsw.demo.Protocol.AttachmentProtocol;
import kr.hs.dgsw.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(User user) {
        return this.userRepository.findByUserIdAndPw(user.getUserId(), user.getPw())
                .orElse(null);
    }

    @PostConstruct
    private void init(){
        if(this.userRepository.count() > 0) return;

        User u = this.userRepository.save(new User("a", "1234", "hyoseong", "bb@dgsw", "C:/Project/JAVA/DGSW_JAVA_SPRING__/web_01_326/upload/2019/01/07425ce8b9-e05c-43d2-9495-0aec7f21d28c_Cute-Whale-PNG-HD.png", "Cute-Whale-PNG-HD.png"));

    }

    @Override
    public User register(User user) {
        Optional<User> found = this.userRepository.findById(user.getIdx());
        if(found.isPresent()){
            return null;
        } else {
            return this.userRepository.save(user);
        }
    }

    @Override
    public AttachmentProtocol getPathById(Long id) {
        return this.userRepository.findById(id)
                .map(found -> new AttachmentProtocol(found.getStoredPath(), found.getOriginalName()))
                .orElse(null);
    }
}
