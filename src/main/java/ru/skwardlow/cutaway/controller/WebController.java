package ru.skwardlow.cutaway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Slf4j
@Controller
public class WebController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        log.info("Someone entered index page");
        return "index";
    }

}
