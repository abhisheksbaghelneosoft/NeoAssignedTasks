package com.ff4j.ff4j_with_webflux.controllers;

import com.ff4j.ff4j_with_webflux.beans.FeaturesStore;
import com.ff4j.ff4j_with_webflux.beans.MessageBean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RequestMapping("/api")
@RestController
public class FF4jController {

    Logger log= Logger.getLogger("FF4jController");


    @GetMapping("/get-menu")
    public String greeting() {
        return "<ul>" +
                "<li><a href=\"/swagger-ui.html\">Swagger</a>" +
                "<li><a href=\"/api/v1/ff4j\">Web Api</a>" +
                "<li><a href=\"/\">Feature Toggle</a>";

    }

    @GetMapping("/demo")
    public String getHomePage(Model model){
        String msg= "Its working";
        model.addAttribute("greet",msg);
        return "redirect:/";
    }

    @ModelAttribute("messages")
    public MessageBean getAllFeatures()
    {
//        WebClient client = WebClient.create();
        log.info("<-------------------inside model attribute method----------------------->");
        return new MessageBean("time",false,"1.0.2",new FeaturesStore());
//        return client.get()
//                .uri("http://localhost:8081/api/ff4j")
//                .retrieve();

//        RestTemplate restTemplate= new RestTemplate();
//        return restTemplate.getForEntity("http://localhost:8081/api/ff4j", MessageBean.class).getBody();
    }



}
