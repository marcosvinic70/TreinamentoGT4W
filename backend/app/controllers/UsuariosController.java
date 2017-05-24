package controllers;

import com.google.gson.JsonObject;
import deserializers.DateDeserializer;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.postgresql.jdbc2.optional.SimpleDataSource;

import play.*;
import play.Play;
import play.mvc.*;
import java.util.*;

import models.*;

public class UsuariosController extends BaseController{

	public static void listarUsuarios() {
	    List<Usuario> listaUser = Usuario.findAll();
		renderJSON(listaUser);
	}
	public static void listarHistoricoUsuarios() {
		List<RegistroUsuario> listaUser = RegistroUsuario.findAll();
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
		List<String> perfis = null;
		
		if(cadastro.get("array").toString() != null)
			perfis = tratarArrayFrontend(cadastro.get("array").toString());
		
		
			//Caso n exista, adicionar...
		if(Usuario.find("cpf",cadastro.get("cpf").getAsLong()).first() == null && id == 0) {

			Usuario user;

			user = new Usuario(cadastro.get("nome").getAsString(),cadastro.get("cpf").getAsLong(),cargo,perfis,sexo,data);
			try{
				user.save();
				renderText("Usuário adicionado com sucesso!!!");
			}
			catch(Exception e){
				
				renderText("Erro ao adicionar o usuário!!!");
			}
		}
		else {
			
			//caso exista, editar...

			Usuario user = Usuario.findById(id);
			user.cpf = cadastro.get("cpf").getAsLong();
			user.sexo = sexo;
			Cargo c = Cargo.find("nome",cargo).first();
			
	        if(c == null) {
	            user.cargo = new Cargo(cargo);
	            user.cargo.save();
	        }
	        else {
	            user.cargo = c;
	        }
	        
			user.dataNascimento = data;
			user.nome = cadastro.get("nome").getAsString();

			user.listaPerfil.clear();
			
			if(perfis != null)
			{
				for(String perfil : perfis)
	            {
	                PerfilUsuario p = PerfilUsuario.find("nome",perfil).first();
	                if(p == null) {
	                    PerfilUsuario pAux = new PerfilUsuario(perfil);
	                    pAux.save();
	                    user.listaPerfil.add(pAux);
	                }
	                else {
	                	user.listaPerfil.add(p);
	                }
	            }
				
			}
			try{
				user.save();
				renderText("Usuário editado com sucesso!!!");
			}
			catch(Exception e){
				
				renderText("Erro ao editar o usuário!!!");
			}
		}
	}

	
	public static void buscarUsuarioParaEditar(Long id){
		Usuario user = Usuario.findById(id);
		renderJSON(user);
	}
	
	public static void removerUsuario(Long id){

		Usuario user = Usuario.findById(id);
		RegistroUsuario registro = new RegistroUsuario(user);
		try{
			registro.save();
			user.delete();
			renderText("Usuário removido com sucesso!!!");
		}
		catch(Exception e){
			
			renderText("Erro ao remover o usuário!");
		}
		
	}
	
	private static List<String> tratarArrayFrontend(String array) {
		if(array.compareTo("[]") == 0) {
			return null;
		}
		array = array.replaceAll("\\[","");
		array = array.replaceAll("]","");
		array = array.replaceAll("\"","");
		String[] novoArray = array.split(",");
		List<String> auxiliar = new ArrayList<String>();
		Collections.addAll(auxiliar, novoArray);

		return auxiliar;
	}
}