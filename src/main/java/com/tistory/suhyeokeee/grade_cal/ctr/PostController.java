package com.tistory.suhyeokeee.grade_cal.ctr;

import com.tistory.suhyeokeee.grade_cal.domain.post.Posts;
import com.tistory.suhyeokeee.grade_cal.dto.posts.PostsResponseDto;
import com.tistory.suhyeokeee.grade_cal.service.post.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostsService postsService;

    //게시글 메인
    @GetMapping("/postMain")
    public String postMain(Model model){
        List<Posts> list = postsService.findAll();
        model.addAttribute("list",list);
        return "post/postMain";
    }

    // 게시글쓰기
    @GetMapping("/postSave")
    public String postSave(){
        return "post/postSave";
    }

    // 게시글 자세히 보기
    @GetMapping("/post/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);

        model.addAttribute("dto",dto);
        return "post/detail";
    }
}
