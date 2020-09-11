package com.tistory.suhyeokeee.grade_cal.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {

    List<Posts> findAllByOrderByIdDesc();
    // findAllOrderByIdDesc는 안되고 findAll Orderby 사이에 By가 있어야 됨
}
