package com.competitiongame.competitiongame.service;

import com.competitiongame.competitiongame.entities.Player;
import com.competitiongame.competitiongame.entities.Task;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface MainService {
    Map<String,Object> onlineEditor(String script) throws IOException;

    Iterable<Task> getTaskList();

    Iterable<Player> getPlayerList();

    Player createPerson(String name, String selectedTaskId);
}
