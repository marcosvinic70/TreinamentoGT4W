package controllers;

import play.*;
import play.Play;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends BaseController{

	public static void teste() {
		
		renderText("Retorno do Backend");
		
	}

	public static void index() {
		render();
		
	}
	public static void usuarios() {
	    List<Usuario> listaUser = Usuario.findAll();
		render(listaUser);
	}

	public static void cargos() {
	    render();
    }

    public static void perfis() {
	    render();
    }

    public static void adicionarUsuario() {
	    render();
    }
}