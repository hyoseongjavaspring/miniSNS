package kr.hs.dgsw.demo.Service;

import kr.hs.dgsw.demo.Domain.Comment;
import kr.hs.dgsw.demo.Protocol.AttachmentProtocol;

import java.util.List;

public interface CommentService {
    List<Comment> getComments();
    Comment view(Long id);

    Comment uploadComment(Comment comment);

    AttachmentProtocol getPathById(Long id);
}
