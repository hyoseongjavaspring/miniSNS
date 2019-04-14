package kr.hs.dgsw.demo.Controller;

import kr.hs.dgsw.demo.Domain.Comment;
import kr.hs.dgsw.demo.Protocol.CommentUserNameProtocol;
import kr.hs.dgsw.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public List<CommentUserNameProtocol> getComments(){
        return this.commentService.getComments();
    }

    @PostMapping("/comment")
    public Comment uploadComment(@RequestBody Comment comment){
        return this.commentService.uploadComment(comment);
    }

    @PutMapping("/modifyComment/{idx}")
    public CommentUserNameProtocol modifyComment(@RequestBody Comment comment, @PathVariable Long idx){
        return this.commentService.modifyComment(idx,comment);
    }
}
