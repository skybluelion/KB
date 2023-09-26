package web.client;

import java.util.Scanner;

import web.controller.Controller;
import web.controller.ControllerFactory;

public class ClientTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(">>>>Command 입력");
		
		String command = sc.next();
		
		ControllerFactory factory = ControllerFactory.getInstance();
		
		Controller controller = factory.createController(command);
		
		controller.handle();// 실제로 생성된 자식 Controller가 동작
		
	}

}
