package controllers;

import com.google.gson.JsonObject;
import deserializers.DateDeserializer;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.postgresql.jdbc2.optional.SimpleDataSource;

import play.*;
import play.Play;
import play.mvc.*;
import util.MensagemValidacao;
import java.util.*;

import models.*;

public class UsuariosController extends BaseController{

	public static void listarUsuarios() {
	    List<Usuario> listaUser = Usuario.findAll();
		renderJSON(listaUser);
	}


	public static void cadastrarUsuario(JsonObject cadastro, Long id) {
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
		
		if(Usuario.find("cpf",cadastro.get("cpf").getAsLong()).first() == null && id == 0) {
			List<String> perfis = null;
			perfis = tratarArrayFrontend(cadastro.get("array").toString());
			Usuario user;

			user = new Usuario(cadastro.get("nome").getAsString(),cadastro.get("cpf").getAsLong(),cargo,perfis,sexo,data);

			user.save();
		}
		else {//caso exista, para editar
			
			List<String> perfis = null;
			perfis = tratarArrayFrontend(cadastro.get("array").toString());
			Usuario user = Usuario.findById(id);
			
			user.setCpf(cadastro.get("cpf").getAsLong());
			user.setSexo(sexo);
			user.setCargo(cargo);
			user.setDataNascimento(data);
			user.setNome(cadastro.get("nome").getAsString());
			user.setListaPerfil(perfis);
			
			user.save();
		}
	}
	public static void buscarUsuarioParaEditar(Usuario user){//usuario do id que o usuarioController enviou, agora sendo enviado para editarUsuarioController
		System.out.println(user.nome);
		renderJSON(user);
	}
	
	public static void usuarioParaEditar(Long id){ //id enviado por usuarioController
		
		Usuario user = Usuario.findById(id);

		buscarUsuarioParaEditar(user);
	}
	
	
	public static void removerUsuario(Long id){

		Usuario user = Usuario.findById(id);
		user.delete();	
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