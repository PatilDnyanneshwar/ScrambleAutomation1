package com.scramble.utils.websocket;

import java.net.URISyntaxException;

public class WebClient {
    private Client webSocket;

    private WebClient() {
    }

    public static WebClient getInstance() {
        return new WebClient();
    }

    public SocketServiceData connect(SocketServiceData socketContext) {
        try {
            webSocket = new Client(socketContext);
            webSocket.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return socketContext;
    }

    public SocketServiceData connectAndListen(SocketServiceData socketContext) {
        try {
            webSocket = new Client(socketContext);
            webSocket.onMessage(socketContext.actualMessage);
            System.out.println(socketContext.actualMessage);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return socketContext;
    }

    public SocketServiceData connectAndListen1(SocketServiceData socketContext) {
        try {
            webSocket = new Client(socketContext);
            webSocket.onMessage(socketContext.actualMessage);
            System.out.println(socketContext.actualMessage);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return socketContext;
    }

//    public SocketServiceData closeConnection(SocketServiceData socketContext) {
//        try {
//            webSocket = new Client(socketContext);
//            webSocket.close();
//            System.out.println("Close Connection");
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        return socketContext;
//    }

}


//    public SocketServiceData connect(SocketServiceData socketContext) {
//        boolean isSent = false;
//        try {
//            webSocket = new Client(socketContext);
//            if (!socketContext.requestHeaders.isEmpty()) {
//                final Map<String, String> requestHeaderParams = socketContext.requestHeaders;
//                requestHeaderParams.forEach((key, value) -> {
//                    webSocket.addHeader(key, value);
//                });
//            }
//            webSocket.connect();
//            while (!webSocket.isClosed()) {
//                if (webSocket.connectionAliveTime() >= socketContext.timeOut) {
//                    webSocket.close(1006, "Time Out");
//                }
//                if (!isSent) {
//                    webSocket.onMessage(socketContext.actualMessage);
//                    System.out.println(socketContext.actualMessage);
//                    isSent = true;
//                }
//            }
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return socketContext;
//    }
