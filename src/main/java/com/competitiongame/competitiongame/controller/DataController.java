package com.competitiongame.competitiongame.controller;

import com.competitiongame.competitiongame.config.ResponseEnum;
import com.competitiongame.competitiongame.config.ResponsePayload;
import com.competitiongame.competitiongame.entities.Player;
import com.competitiongame.competitiongame.entities.Task;
import com.competitiongame.competitiongame.repositories.PlayerRepository;
import com.competitiongame.competitiongame.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
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

    @PostMapping(value = "/create-person")
    public ResponsePayload onlineEditor(@RequestParam String name, @RequestParam String selectedTaskId) {

        try {
            Player player =  service.createPerson(name, selectedTaskId);
            if (player != null) {
                return new ResponsePayload(ResponseEnum.OK, player, player.getPlayerName() + " is created");
            }
            return new ResponsePayload(ResponseEnum.NOTFOUND, "There is mistake!");
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.INTERNAL_ERROR);
        }
    }

    @GetMapping(value = "/batch-people")
    public ResponsePayload batchPeople() {

        try {
            Iterable<Player> models = service.getPlayerList();
            if (models != null)
                return new ResponsePayload(ResponseEnum.OK, models, "Batch data is success");
            else
                return new ResponsePayload(ResponseEnum.NOTFOUND, "Batch is unsuccessfully");
        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Duplicate Key");
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.INTERNAL_ERROR);
        }
    }

    @GetMapping(value = "/batch-tasks")
    public ResponsePayload batchTasks() {

        try {
            Iterable<Task> models = service.getTaskList();
            if (models != null)
                return new ResponsePayload(ResponseEnum.OK, models, "Batch data is success");
            else
                return new ResponsePayload(ResponseEnum.NOTFOUND, "Batch is unsuccessfully");
        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Duplicate Key");
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.INTERNAL_ERROR);
        }
    }
}
