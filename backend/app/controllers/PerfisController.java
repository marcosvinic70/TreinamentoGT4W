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
import controllers.Utilidades;
import models.*;

public class PerfisController extends BaseController{
	
	public static void listarPerfis() {
		List<PerfilUsuario> listaPerfis = PerfilUsuario.findAll();
		renderJSON(listaPerfis);
	}
	
	public static void removerPerfil(Long id){

		MensagemValidacao msg = new MensagemValidacao();
		
		try{
			PerfilUsuario perfil = PerfilUsuario.findById(id);
			perfil.delete();
			msg.mensagemSucesso = "Perfil Removido com Sucesso";
		}
		catch(Exception e)
		{
			msg.mensagemErro = "Impossível remover este perfil, pois o mesmo está vinculado a um usuário";
		}
		finally
		{
			Utilidades.validacao(msg);
		}
		
	}
}
