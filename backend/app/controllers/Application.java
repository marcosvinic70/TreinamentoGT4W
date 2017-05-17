package controllers;

import com.google.gson.JsonObject;
import deserializers.DateDeserializer;
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

	public static void listarCargos() {
		List<Cargo> listaCargos = Cargo.findAll();
		renderJSON(listaCargos);
	}

	public static void listarPerfis() {
		List<PerfilUsuario> listaPerfis = PerfilUsuario.findAll();
		renderJSON(listaPerfis);
	}

	public static void cadastrarUsuario(JsonObject cadastro) {
		//DateDeserializer deserial = new DateDeserializer();
		//Date data = deserial.deserialize(cadastro.get("dataNascimento"));
		//System.out.println(cadastro.get("nome").getAsString() + " " + cadastro.get("cpf").getAsLong() + " " + cadastro.get("cargo").getAsString() + " " + cadastro.get("sexo").getAsString());
		Usuario user = new Usuario(cadastro.get("nome").getAsString(),cadastro.get("cpf").getAsLong(),cadastro.get("cargo").getAsString(),null,cadastro.get("sexo").getAsString(),null);
		user.save();
	}

}