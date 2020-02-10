package com.example.__RestServerdatatestwebSocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author shkstart
 * @create 2018-08-10 16:34
 */
@Component
@ServerEndpoint(value = "/websocket/chat")
public class WebSocket {
    //在线人数
    private static int online = 0;
    //所有的对象，用于群发
    public static List<WebSocket> webSockets = new CopyOnWriteArrayList<>();
    //会话
    private Session session;
    private String userName;

    public WebSocket() {
    }
    /**
     * 建立连接
     *
     * @param session
     */
    @OnOpen
//    public void onOpen(@PathParam("username") String username, Session session)
    public void onOpen(Session session)
    {
        online++;
        webSockets.add(this);
        this.session = session;
    }

//    @OnError
//    public void onError(Session session, Throwable error) {
//        logger.info("服务端发生了错误"+error.getMessage());
//        //error.printStackTrace();
//    }
    /**
     * 连接关闭
     */
    @OnClose
    public void onClose()
    {
        online--;
        webSockets.remove(this);
    }

    /**
     * 收到客户端的消息
     *
     * @param message 消息s
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message) throws IOException {
        WebSocket chatAn = new WebSocket();
//        System.out.println(message);
//        if (message.startsWith("webinit")) {
//            //web-client建立连接的时候自动发的第一天消息 用来命名连接userName  message格式为 webinit-web
//            this.userName = message.split("-")[1];
//            broadcast(this, "hello");
//        } else if (message.startsWith("javaclient")) {
//            //接收来自java-client的消息 每个连接无需命名username connectionID
//            for (int i = 0; i < webSockets.size(); i++) {
//                System.out.println("当前的name:" + webSockets.get(i).userName);
//                if (webSockets.get(i).userName.equals("web")) {//
//                    chatAn = webSockets.get(i);
//                    break;
//                }
//            }
            chatAn = webSockets.get(0);
            broadcast(chatAn, message.substring("javaclient".length(), message.length()));
//        }
    }

    /**
     * 把java-client的消息转广播至web-client
     *
     * @param chatAn  web连接
     * @param message
     */
    public void broadcast(WebSocket chatAn, String message) throws IOException {
//        System.out.println("要发出去的消息：" + message);
        chatAn.session.getBasicRemote().sendText("from java client : " + message);
    }
}