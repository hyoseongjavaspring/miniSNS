package kr.hs.dgsw.demo.Service;

import kr.hs.dgsw.demo.Domain.Comment;
import kr.hs.dgsw.demo.Protocol.AttachmentProtocol;
import kr.hs.dgsw.demo.Protocol.CommentUserNameProtocol;
import kr.hs.dgsw.demo.Repository.CommentRepository;
import kr.hs.dgsw.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CommentUserNameProtocol> getComments() {
        List<Comment> comments = this.commentRepository.findAll();
        List<CommentUserNameProtocol> cupList = new ArrayList<>();
        comments.forEach(comment -> {
            cupList.add(view(comment));
        });
        return cupList;
    }

    @Override
    public CommentUserNameProtocol view(Comment comment) {
        return this.userRepository.findById(comment.getUserIdx())
                .map(found -> new CommentUserNameProtocol(this.commentRepository.save(comment), found.getUserName()))
                .orElse(null);
    }

    @Override
    public CommentUserNameProtocol uploadComment(Comment comment) {
        return view(comment);
    }

    @Override
    public AttachmentProtocol getPathById(Long idx) {
        return this.commentRepository.findById(idx)
                .map(found -> new AttachmentProtocol(found.getStoredPath(), found.getOriginalName()))
                .orElse(null);
    }

    @Override
    public CommentUserNameProtocol modifyComment(Long idx, Comment comment) {
        return this.commentRepository.findById(idx)
                .map(found ->{
                    found.setStoredPath(comment.getStoredPath() != null ? comment.getStoredPath() : found.getStoredPath());
                    found.setOriginalName(comment.getOriginalName() != null ? comment.getOriginalName() : found.getOriginalName());
                    found.setContent(comment.getContent());
                    return view(this.commentRepository.save(found));
                })
                .orElse(null);
    }
}
