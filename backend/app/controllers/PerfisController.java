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

public class PerfisController extends BaseController{
	
	public static void listarPerfis() {
		List<PerfilUsuario> listaPerfis = PerfilUsuario.findAll();
		renderJSON(listaPerfis);
	}
	
	public static void removerPerfil(Long id){

		PerfilUsuario perfil = PerfilUsuario.findById(id);
		try{
			perfil.delete();

			renderText("Perfil removido com sucesso!!!");
		}
		catch(Exception e){
			
			renderText("Impossível remover este perfil, pois o mesmo está vinculado a um usuário!");
		}
	}

	public static void buscaEditarPerfil(Long id) {
		PerfilUsuario perfil = PerfilUsuario.findById(id);
		renderJSON(perfil);
	}

	public static void editarPerfil(Long id, String nomeEdicao) {
		PerfilUsuario perfil = PerfilUsuario.findById(id);
		perfil.nome = nomeEdicao;
		
		try{
			perfil.save();
			renderText("Cargo editado com sucesso!!!");
		}
		catch(Exception e)
		{
			renderText("Erro ao editar o cargo!!!");
		}
	}
}
