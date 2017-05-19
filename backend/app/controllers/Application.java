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

	public static void listarHistoricoUsuarios() {
		List<RegistroUsuario> listaUser = RegistroUsuario.findAll();
		renderJSON(listaUser);
	}

	public static void cadastrarUsuario(JsonObject cadastro) {
		Object sexoTeste =  cadastro.get("sexo");
		String sexo = null;
		if( sexoTeste != null) {
			sexo = cadastro.get("sexo").getAsString();
		}

		Object dataTeste = cadastro.get("dataNascimento");
		Date data = null;
		if(dataTeste != null) {
			data = DateDeserializer.parseDate(cadastro.get("dataNascimento").getAsJsonPrimitive().getAsString());
		}

		Object cargoTeste = cadastro.get("cargoNovo");
		String cargo;
		if(cargoTeste == null) {
			cargo = cadastro.get("cargo").getAsString();
		}
		else {
			cargo = cadastro.get("cargoNovo").getAsString();
		}

		if(Usuario.find("cpf",cadastro.get("cpf").getAsLong()).first() == null) {
			List<String> perfis = null;
			perfis = tratarArrayFrontend(cadastro.get("array").toString());
			Usuario user;

			user = new Usuario(cadastro.get("nome").getAsString(),cadastro.get("cpf").getAsLong(),cargo,perfis,sexo,data);

			user.save();
		}
		else {
			System.out.println("\nERRO! Usuario já registrado!");
		}
	}

	public static void removerUsuario(Long id){

		Usuario user = Usuario.findById(id);
		RegistroUsuario registro = new RegistroUsuario(user);
		registro.save();
		user.delete();
		
	}
	public static void removerCargo(Long id){

		
		try{
			Cargo cargo = Cargo.findById(id);
			
			System.out.println(id);
	
			cargo.delete();
			
		}
		catch(Exception e)
		{
			String mensagemErro = "Impossível remover este cargo, pois o mesmo está vinculado a um usuário";
			renderJSON(mensagemErro);
			
		}
		
	}
	
	private static List<String> tratarArrayFrontend(String array) {
		if(array.compareTo("[]") == 0) {
			return null;
		}

		array = array.replaceAll("\\[","");
		array = array.replaceAll("]","");
		array = array.replaceAll("\"","");
		array = array.replaceAll(" ","");
		String[] novoArray = array.split(",");
		List<String> auxiliar = new ArrayList<String>();

		/*for(String s: novoArray) {
			auxiliar.add(s);
		}*/

		Collections.addAll(auxiliar, novoArray);

		return auxiliar;
	}


}