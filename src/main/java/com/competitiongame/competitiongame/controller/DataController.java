package com.competitiongame.competitiongame.controller;

import com.competitiongame.competitiongame.config.ResponseEnum;
import com.competitiongame.competitiongame.config.ResponsePayload;
import com.competitiongame.competitiongame.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/data")
public class DataController {

    @Autowired
    MainService service;

    @PostMapping(value = "/online-editor")
    public ResponsePayload onlineEditor(@RequestBody String script) {

        try {
            Map<String,Object> output = service.onlineEditor(script);
            if (output.get("statusCode").toString().equals("200")) {
                return new ResponsePayload(ResponseEnum.OK, output, "Code is working successfully");
            }
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Code is not working!");
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.INTERNAL_ERROR);
        }
    }
}
