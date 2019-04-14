package kr.hs.dgsw.demo.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long idx;

    private String userId;
    private String pw;

    private String userName;
    private String email;

    private String storedPath;
    private String originalName;

    @CreationTimestamp
    private LocalDateTime joined;
    @UpdateTimestamp
    private LocalDateTime modified;

    public User(String userId, String pw, String userName, String email, String storedPath, String originalName){
        this.userId = userId;
        this.pw = pw;
        this.userName = userName;
        this.email = email;
        this.storedPath = storedPath;
        this.originalName = originalName;
    }
}