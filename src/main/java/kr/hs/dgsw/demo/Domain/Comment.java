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
public class Comment {

    public Comment(Comment c){
        this.idx = c.getIdx();
        this.userIdx = c.getUserIdx();
        this.content = c.getContent();
        this.created = c.getCreated();
        this.modified = c.getModified();
    }

    @Id
    @GeneratedValue
    private Long idx;

    private Long userIdx;
    private String content;

    private String storedPath;
    private String originalName;


    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime modified;

    public Comment(Long userIdx, String content, String storedPath, String originalName) {
        this.userIdx = userIdx;
        this.content = content;
        this.storedPath = storedPath;
        this.originalName = originalName;
    }
}
