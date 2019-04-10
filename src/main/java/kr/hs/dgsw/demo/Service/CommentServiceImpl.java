package kr.hs.dgsw.demo.Service;

import kr.hs.dgsw.demo.Domain.Comment;
import kr.hs.dgsw.demo.Protocol.AttachmentProtocol;
import kr.hs.dgsw.demo.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getComments() {
        return this.commentRepository.findAll();
    }

    @Override
    public Comment view(Long id) {
        return this.commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment uploadComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public AttachmentProtocol getPathById(Long id) {
        return this.commentRepository.findById(id)
                .map(found -> new AttachmentProtocol(found.getStoredPath(), found.getOriginalName()))
                .orElse(null);
    }
}
