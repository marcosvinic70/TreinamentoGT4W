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

public class CargosController extends BaseController{
	
	public static void listarCargos() {
		List<Cargo> listaCargos = Cargo.findAll();
		renderJSON(listaCargos);
	}

	public static void removerCargo(Long id){

		
		try{
			Cargo cargo = Cargo.findById(id);
			cargo.delete();
		}
		catch(Exception e)
		{
			renderJSON("Impossível remover este cargo, pois o mesmo está vinculado a um usuário");
		}
		
	}
}