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
		System.out.println("teste");
		List<Usuario> listaUser = Usuario.findAll();
		System.out.println(listaUser.get(0).nome);
		render();
		
	}
	public static void usuarios() {
		System.out.println("teste");
	    List<Usuario> listaUser = Usuario.findAll();
	    System.out.println(listaUser.get(0).nome);
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