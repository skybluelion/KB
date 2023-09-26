package web.controller;
/*
 	RegisterController
 	FindController
 	UpdateController
 	같은 것들을 직접 생성하는 공장...싱글톤...
 */
public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {
		
	}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	//~Controller 를 생성하는 기능을 작성
	//클라이언트가 어떤 요청을 하는가에 따라서 생성되는 Controller는 달라진다.
	//command값에 따라서 생성되는 Controller가 달라진다.
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("register")) {
			controller = new RegisterController();
			System.out.println("Creating ... RegisterController");
		}else if(command.equals("update")) {
			controller = new UpdateController();
			System.out.println("Creating ... UpdateController");
		}if(command.equals("find")) {
			controller = new FindController();
			System.out.println("Creating ... FindController");
		}
		
		return controller;
	}
}
