package controllers;

public class Application extends BaseController{

	public static void teste() {
		
		renderText("Retorno do Backend");
		
	}

	public static void index() {
		render();
		
	}
	public static void usuarios() {

		render();
	}

	public static void cargos() {
	    render();
    }

    public static void perfis() {
	    render();
    }
}