package com.example.__RestClientdatatestwebSocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class Application {
	private static final Logger logger = Logger.getLogger(Application.class.getName());
	private static String uri = "ws://localhost:8080/websocket/chat";
	private static Session session;
	private void start() {
		WebSocketContainer container = null;
		try {
			container = ContainerProvider.getWebSocketContainer();
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
		try {
			URI r = URI.create(uri);
			session = container.connectToServer(client.class, r);
		} catch (DeploymentException | IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Application client = new Application();
		client.start();
		long time1 = System.currentTimeMillis();
		try {
			for(int i = 0 ;i<10000;i++)
				client.session.getBasicRemote().sendText("javaclient"+i);
			client.session.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			long time2 = System.currentTimeMillis();
			double kkv=(time2-time1)/1000.0;
			logger.log(Level.WARNING, "耗時：", String.valueOf(kkv));
//			System.out.println((time2-time1)/1000.0 + "秒");
		}
	}
}
