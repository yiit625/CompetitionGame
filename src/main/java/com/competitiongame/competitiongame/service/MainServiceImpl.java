package com.competitiongame.competitiongame.service;

import com.competitiongame.competitiongame.entities.Player;
import com.competitiongame.competitiongame.entities.Task;
import com.competitiongame.competitiongame.repositories.PlayerRepository;
import com.competitiongame.competitiongame.repositories.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@Service
public class MainServiceImpl implements MainService {

    @Value("${spring.datasource.clientId}")
    private String clientId;

    @Value("${spring.datasource.clientSecret}")
    private String clientSecret;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TaskRepository taskRepository;

    public Map<String,Object> onlineEditor(String script) throws IOException {
            System.out.println(clientId);
            System.out.println(clientSecret);
            System.out.println(script);

            URL url = new URL("https://api.jdoodle.com/v1/execute");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input =
                    "{\"clientId\":" + clientId +
                    ",\"clientSecret\":" + clientSecret +
                    ",\"script\":\"" + script +
                    "\",\"language\":\"" + "java" +
                    "\",\"versionIndex\":\"" + "0" + "\"} ";


            System.out.println(input);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Please check your inputs : HTTP error code : " + connection.getResponseCode());
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            System.out.println("Output from JDoodle .... \n");
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> map = null;
            while ((output = bufferedReader.readLine()) != null) {
                map = mapper.readValue(output, Map.class);
            }
            connection.disconnect();
            return map;
    }

    @Override
    public Iterable<Task> getTaskList() {
        return taskRepository.findAll();
    }

    @Override
    public Iterable<Player> getPlayerList() {
        return playerRepository.findAll();
    }

    @Override
    public Player createPerson(String name, String selectedTaskId) {
        Player player = playerRepository.checkExist(name);
        if (player == null) {
            Player player1 = new Player();
            player1.setPlayerName(name);
            player1.setTaskList(selectedTaskId);
            playerRepository.save(player1);
            return player1;
        } else {
            Player player1 = playerRepository.checkExist(name);
            player1.setTaskList(selectedTaskId);
            playerRepository.save(player1);
            return player1;
        }
    }
}
