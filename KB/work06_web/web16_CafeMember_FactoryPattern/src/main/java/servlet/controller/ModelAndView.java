package servlet.controller;

//결과 페이지 이름과 페이지 이동방법에 대한 정보를 저장하는 클래스
public class ModelAndView {

	private String path;
	private boolean isRedirect; // false 기본값 forward
	
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	
	public ModelAndView(String path) {
		super();
		this.path = path;
	}
	
	public ModelAndView() {	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
