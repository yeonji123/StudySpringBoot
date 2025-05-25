package com.example.spring.controller;

import com.example.spring.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("/users")
public class JPAController {

    // Service
    private final MemberService memberService;

    // 사용자 정보 get
    @GetMapping("/")
    public String[] getUsers(){
        return null;
    }

    // 사용자 insert
    @PostMapping("createUser")
    public boolean createUser(){
        return true;
    }

    // 사용자 수정 update
    @PutMapping("editUser")
    public boolean editUser(){
        return true;
    }

    // 사용자 삭제 delete
    @DeleteMapping("deleteUser")
    public boolean deleteUser(){
        return true;
    }
}
