package com.scramble.utils.websocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;

import static com.scramble.constants.ApiUrls.SCRAMBLE_WEBSOCKET_REQUEST;

public class OpenWebSocket {
    public static void openConnection() {
        String serverUri = SCRAMBLE_WEBSOCKET_REQUEST;
        WebSocketClient webSocketClient = new WebSocketClient(URI.create(serverUri)) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("Connection established");
                // Display user-friendly messages for the successful establishment of the connection
                // Note: In Java, you can't directly access the DOM like in JavaScript, so you cannot update a web page element directly.
            }

            @Override
            public void onMessage(String message) {
                System.out.println("Received message: " + message);
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

        webSocketClient.connect(); // Open the WebSocket connection
    }
}

