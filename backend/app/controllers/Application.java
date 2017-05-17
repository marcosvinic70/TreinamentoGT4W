package controllers;

import play.*;
import play.Play;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends BaseController{

	public static void listarUsuarios() {
	    List<Usuario> listaUser = Usuario.findAll();
		renderJSON(listaUser);
	}


}