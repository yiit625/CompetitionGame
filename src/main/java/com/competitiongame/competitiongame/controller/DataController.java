package com.competitiongame.competitiongame.controller;

import com.competitiongame.competitiongame.config.ResponseEnum;
import com.competitiongame.competitiongame.config.ResponsePayload;
import com.competitiongame.competitiongame.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/data")
public class DataController {

    @Autowired
    MainService service;

    @PostMapping(value = "/online-editor")
    public ResponsePayload onlineEditor(@RequestBody String script) {

        try {
            service.onlineEditor(script);
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Create is unsuccessfully");
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.INTERNAL_ERROR);
        }
    }
}
