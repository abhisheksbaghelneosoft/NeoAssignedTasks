package com.ff4j.loggertoggle.controllers;


import com.ff4j.loggertoggle.configs.AppenderManipulation;
import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class Ff4jController {

    @Autowired
    private FF4j ff4j;

    @Autowired
    private AppenderManipulation appenderManipulation;

    Logger log= LoggerFactory.getLogger("Ff4jController");

    @GetMapping("/web-console")
    public String home(Model model) {
        return "ui-view";
    }

    @PostMapping("/toggle")
    public String toggleFeature(@RequestParam String feature,Model model) {

        if(ff4j.check(feature)) {
            ff4j.disable(feature);
            log.info("Disabled :: "+feature);
            appenderManipulation.removeAppender(feature);
        }else {
            ff4j.enable(feature);
            log.info("Enabled :: "+feature);
            appenderManipulation.addAppender(feature);
        }
        Map<String, Feature> map=ff4j.getFeatureStore().readAll();
        List<Feature> ls= new ArrayList<>();
        for(Map.Entry<String,Feature> ent: map.entrySet())
        {
            log.info("<-------------------"+ent.getKey()+" : "+ent.getValue()+"------------------->");
            ls.add(ent.getValue());
        }
        model.addAttribute("messages",ls);
        return "ui-view";
    }

    //    @PostMapping("/get-features")
    @ModelAttribute
    public String getFeature(Model model)
    {
        Map<String, Feature> map=ff4j.getFeatureStore().readAll();
        List<Feature> ls= new ArrayList<>();
        for(Map.Entry<String,Feature> ent: map.entrySet())
        {
            ls.add(ent.getValue());
        }
        model.addAttribute("messages",ls);

        return "ui-view";
    }
}

