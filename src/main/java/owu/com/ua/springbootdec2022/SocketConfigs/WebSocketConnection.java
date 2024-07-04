package owu.com.ua.springbootdec2022.SocketConfigs;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WebSocketConnection extends TextWebSocketHandler {


    private Map<String,WebSocketSession> sessionMap = new HashMap();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("session established" + session.getId());
        sessionMap.put(session.getId(),session);


    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("session closed" + session.getId());

        sessionMap.remove(session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        System.out.println(message);
        sessionMap.forEach((sid,webSocketSession) ->{

            try {
                webSocketSession.sendMessage(new TextMessage(message.getPayload()+ new Date(System.currentTimeMillis())));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


}
