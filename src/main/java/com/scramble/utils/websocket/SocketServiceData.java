package com.scramble.utils.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocketServiceData {
    public String URI;
    public String actualMessage;
    public String expectedMessage;
    Map<String, String> requestHeaders = new HashMap<>();
    List<String> messageList = new ArrayList<>();
    public int statusCode;
    public int timeOut = 10;
    int timeTaken;
}
