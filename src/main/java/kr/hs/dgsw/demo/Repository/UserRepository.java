package kr.hs.dgsw.demo.Repository;

import kr.hs.dgsw.demo.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserIdAndPw(String userId, String pw);
}
