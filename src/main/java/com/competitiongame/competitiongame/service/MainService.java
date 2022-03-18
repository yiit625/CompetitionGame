package com.competitiongame.competitiongame.service;

import java.io.IOException;
import java.util.Map;

public interface MainService {
    Map<String,Object> onlineEditor(String script) throws IOException;
}
