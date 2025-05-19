package com.example.spring.controller;

import com.example.spring.dto.SampleDTO;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public String[] hello(){
        return new String[]{"Hello","World"};
    }

    @GetMapping("/sample/ex1")
    public void ex1(){
        log.info("ex1.........");
    }

    @GetMapping({"/sample/ex2"})
    public void exModel(Model model){
        List<SampleDTO> list = IntStream.rangeClosed(1,20).asLongStream(). mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder()
                    .sno(i)
                    .first("First..."+i)
                    .last("Last..."+i)
                    .regTime(LocalDateTime.now())
                    .build();
            return dto;
        }).collect(Collectors.toList());

        model.addAttribute("list", list);

    }

}
