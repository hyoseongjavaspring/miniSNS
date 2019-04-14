package kr.hs.dgsw.demo.Service;

import kr.hs.dgsw.demo.Domain.Comment;
import kr.hs.dgsw.demo.Protocol.AttachmentProtocol;
import kr.hs.dgsw.demo.Protocol.CommentUserNameProtocol;

import java.util.List;

public interface CommentService {
    List<CommentUserNameProtocol> getComments();
    CommentUserNameProtocol view(Comment comment);

    Comment uploadComment(Comment comment);

    AttachmentProtocol getPathById(Long idx);

    CommentUserNameProtocol modifyComment(Long idx, Comment comment);
}
