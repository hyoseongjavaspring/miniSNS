package kr.hs.dgsw.demo.Protocol;

import kr.hs.dgsw.demo.Domain.Comment;
import lombok.Data;

@Data
public class CommentUserNameProtocol extends Comment {
    private String userName;

    public CommentUserNameProtocol(Comment c, String userName){
        super(c);
        this.userName = userName;
    }
}
