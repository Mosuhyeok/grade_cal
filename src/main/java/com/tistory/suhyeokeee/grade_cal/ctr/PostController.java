package com.tistory.suhyeokeee.grade_cal.ctr;

import com.tistory.suhyeokeee.grade_cal.domain.post.Posts;
import com.tistory.suhyeokeee.grade_cal.dto.posts.PostsResponseDto;
import com.tistory.suhyeokeee.grade_cal.service.post.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostsService postsService;

    //게시글 메인 나중에 페이징 추가하기
    @GetMapping("/postMain")
    public String postMain(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        Page<Posts> list = postsService.findAll(pageable);
        model.addAttribute("list",list);
//
//
//        System.out.println("총 게시글 갯수 = ");
//        System.out.println(list.getTotalElements());
//
//
//        System.out.print("list.getTotalPage = "+" ");
//        System.out.println(list.getTotalPages());
//
//        System.out.print("list.getNumber"+" ");
//        System.out.println(list.getNumber());
//        System.out.println(list.getPageable().getPageSize());
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
