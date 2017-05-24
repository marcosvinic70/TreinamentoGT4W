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
		perfil.delete();

		 renderJSON(new Message("Perfil Removido com Sucesso."));
	}
}
