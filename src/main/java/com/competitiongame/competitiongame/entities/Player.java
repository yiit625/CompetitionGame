package com.competitiongame.competitiongame.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="player_table")
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "task_list")
    private String taskList;

    public void setTaskList(List<Integer> vals) {
        this.taskList = vals.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    public List<Integer> getTaskList() {
        String[] convertedRankArray = taskList.split(",");
        List<Integer> list = new ArrayList<>();
        for (String number : convertedRankArray) {
            list.add(Integer.parseInt(number.trim()));
        }
        return list;
    }
}
