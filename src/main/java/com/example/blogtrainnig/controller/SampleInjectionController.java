package com.example.blogtrainnig.controller;

import com.example.blogtrainnig.external.ExternalApiParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class SampleInjectionController {
    private ExternalApiParser parser;

    public SampleInjectionController(ExternalApiParser parser) {
        this.parser = parser;
    }

    @GetMapping("/test/api")
    public String testSave() {
        parser.parserAndSave();
        return "redirect:/articles";
    }
}
