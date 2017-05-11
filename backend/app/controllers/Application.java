package controllers;

public class Application extends BaseController{

	public static void teste() {
		
		renderText("Retorno do Backend");
		
	}

	public static void index() {
		render();
	}

}