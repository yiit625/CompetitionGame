package com.competitiongame.competitiongame.service;

import com.competitiongame.competitiongame.dao.PlayerModel;
import com.competitiongame.competitiongame.entities.Player;
import com.competitiongame.competitiongame.entities.Task;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface MainService {
    Map<String,Object> onlineEditor(String script, String inputParam) throws IOException;

    Iterable<Task> getTaskList();

    List<PlayerModel> getPlayerList();

    Player createPerson(String name, Integer selectedTaskId);

    Player createPersonWithoutTaskId(String name);

}
