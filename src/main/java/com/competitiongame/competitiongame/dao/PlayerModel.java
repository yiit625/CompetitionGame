package com.competitiongame.competitiongame.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayerModel {
    private Integer id;
    private String playerName;
    private List<Integer> taskList;
    private List<String> taskName;
    private Integer taskListLength;
}
