package com.capstone.jongmin.controller;


import com.capstone.jongmin.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;


}
