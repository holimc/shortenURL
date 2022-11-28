package com.holimc.urlshortener.controller;

import com.holimc.urlshortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final UrlService urlService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/{shorten}")
    public void redirect(@PathVariable(value = "shorten") String shorten, HttpServletResponse httpServletResponse)
        throws IOException{
        String destinationUrl = urlService.restoreUrl(shorten);
        // error
        log.info("[destination URL]" + destinationUrl);
        httpServletResponse.sendRedirect(destinationUrl);
    }
}
