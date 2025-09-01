package com.example.demo.controller;

import com.example.demo.service.XslTransformService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class XslController {

    private final XslTransformService transformService;

    @GetMapping("/xsl-demo")
    public String showTransformed(Model model) {
        String xmlPath = "src/main/resources/xslt/books.xml";
        String xslPath = "src/main/resources/xslt/books.xsl";

        String resultHtml = transformService.transformXmlWithXsl(xmlPath, xslPath);
        model.addAttribute("resultHtml", resultHtml);
        return "/WEB-INF/jsp/result.jsp";    }
}