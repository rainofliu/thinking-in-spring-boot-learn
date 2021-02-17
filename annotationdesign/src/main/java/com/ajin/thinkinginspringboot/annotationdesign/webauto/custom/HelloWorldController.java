package com.ajin.thinkinginspringboot.annotationdesign.webauto.custom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ajin
 */
@Controller
public class HelloWorldController {

    @RequestMapping
    @ResponseBody
    public String helloWorld() {
        return "Hello,World";
    }
}
