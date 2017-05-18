package controllers;

import com.google.gson.JsonObject;
import deserializers.DateDeserializer;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
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

		if(Usuario.find("nome",cadastro.get("nome").getAsString()).first() == null) {
			List<String> perfis = tratarArrayFrontend(cadastro.get("array").toString());
			Date data = DateDeserializer.parseDate(cadastro.get("dataNascimento").getAsJsonPrimitive().getAsString());
			Usuario user;

			if(data == null) {
				user = new Usuario(cadastro.get("nome").getAsString(),cadastro.get("cpf").getAsLong(),cadastro.get("cargo").getAsString(),perfis,cadastro.get("sexo").getAsString(),null);
			}
			else {
				user = new Usuario(cadastro.get("nome").getAsString(),cadastro.get("cpf").getAsLong(),cadastro.get("cargo").getAsString(),perfis,cadastro.get("sexo").getAsString(),data);
			}

			user.save();
		}
		else {
			System.out.println("\nERRO! Usuario já registrado!");
		}
	}

	private static List<String> tratarArrayFrontend(String array) {
		array = array.replaceAll("\\[","");
		array = array.replaceAll("]"," ");
		array = array.replaceAll("\""," ");
		String[] novoArray = array.split(",");
		List<String> auxiliar = new ArrayList<String>();

		/*for(String s: novoArray) {
			auxiliar.add(s);
		}*/

		Collections.addAll(auxiliar, novoArray);

		return auxiliar;
	}


}