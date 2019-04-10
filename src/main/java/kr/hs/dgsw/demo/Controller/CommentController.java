package kr.hs.dgsw.demo.Controller;

import kr.hs.dgsw.demo.Domain.Comment;
import kr.hs.dgsw.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public List<Comment> getComments(){
        return this.commentService.getComments();
    }

    @PostMapping("/comment")
    public Comment uploadComment(@RequestBody Comment comment){
        return this.commentService.uploadComment(comment);
    }
}
