package com.siedlecki.mateusz.uproszczonaewidencjakosztowbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainRestController {

    @GetMapping
    String hello(){
        return "hello";
    }
}
