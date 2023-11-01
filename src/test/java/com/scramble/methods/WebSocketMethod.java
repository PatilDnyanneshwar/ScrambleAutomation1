package com.scramble.methods;

import com.scramble.utils.websocket.SocketServiceData;
import com.scramble.utils.websocket.WebClient;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.testng.Assert;

import java.net.URI;

import static com.scramble.constants.ApiUrls.SCRAMBLE_WEBSOCKET_REQUEST;
import static com.scramble.methods.GetQIDMethod.qid;

public class WebSocketMethod {
    SocketServiceData context;
    private WebSocketClient webSocketClient;

    public void createContext() {
        context = new SocketServiceData();
        context.URI = SCRAMBLE_WEBSOCKET_REQUEST + qid;
        context.timeOut = 5;
        context.expectedMessage = "Wait For Confirm";
        context.actualMessage = "Wait For Confirm";
    }

    public void createContext1() {
        context = new SocketServiceData();
        context.URI = SCRAMBLE_WEBSOCKET_REQUEST + qid;
        context.timeOut = 5;
        context.expectedMessage = "Saml Response";
        context.actualMessage = "Saml Response";
    }

    public void verifyWebSocketAPI() {
        SocketServiceData responseContext = WebClient.getInstance().connect(context);
        Assert.assertEquals(responseContext.statusCode, 0, "Connection Open");
    }

    public void verifyWebSocketAPI1() {
        SocketServiceData responseContext = WebClient.getInstance().connectAndListen(context);
        Assert.assertEquals(responseContext.statusCode, 0, "Status code is different");
    }

    public void verifyWebSocketAPI2() {
        SocketServiceData responseContext = WebClient.getInstance().connectAndListen1(context);
        Assert.assertEquals(responseContext.statusCode, 0, "Status code is different");
    }

//    public void verifyConnectionClose() {
//        SocketServiceData responseContext = WebClient.getInstance().closeConnection(context);
//        Assert.assertEquals(responseContext.statusCode, 1006, "Status code is different");
//    }

    public static String abc;

    public void connection() {
        try {
            String serverUri = SCRAMBLE_WEBSOCKET_REQUEST + qid;
            webSocketClient = new WebSocketClient(new URI(serverUri)) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    System.out.println("WebSocket connection opened");
                }

                @Override
                public void onMessage(String message) {
                    System.out.println("Received message: " + message);
                    abc = message;
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    System.out.println("WebSocket connection closed");
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        webSocketClient.connect();
    }

    public void close() throws InterruptedException {
        webSocketClient.connectBlocking();
    }

    public void message() {
        webSocketClient.onMessage(abc);
    }

//    public void closeConnection() {
//        try {
//            String serverUri = SCRAMBLE_WEBSOCKET_REQUEST + qid;
//            webSocketClient = new WebSocketClient(new URI(serverUri)) {
//                @Override
//                public void onOpen(ServerHandshake serverHandshake) {
//                    System.out.println("WebSocket connection opened");
//                }
//
//                @Override
//                public void onMessage(String message) {
//                    System.out.println("Received message: " + message);
//                }
//
//                @Override
//                public void onClose(int code, String reason, boolean remote) {
//                    System.out.println("WebSocket connection closed");
//                }
//
//                @Override
//                public void onError(Exception e) {
//                    e.printStackTrace();
//                }
//            };
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


//    public void createContext() {
//        context = new SocketServiceData();
//        context.URI = SCRAMBLE_WEBSOCKET_REQUEST + qid;
//        context.timeOut = 5;
//        context.expectedMessage = "Wait For Confirm";
//        context.actualMessage = "Wait For Confirm";
//    }

//    public void verifyWebSocketAPI() {
//
//        WebClient.getInstance().connectAndListen(context);
//        SocketServiceData responseContext = WebClient.getInstance().connectAndListen(context);
//        Assert.assertEquals(responseContext.statusCode, 1006, "Connection Open");
//        Assert.assertEquals(responseContext.statusCode, 1000, "Status code is different");
//    }
}
