package controllers;

import com.google.gson.JsonObject;
import deserializers.DateDeserializer;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.postgresql.jdbc2.optional.SimpleDataSource;

import play.*;
import play.Play;
import play.mvc.*;
import sun.rmi.runtime.Log;
import java.util.*;

import models.*;

public class CargosController extends BaseController{
	
	public static void listarCargos() {
		List<Cargo> listaCargos = Cargo.findAll();
		renderJSON(listaCargos);
	}

	public static void removerCargo(Long id){
		
		Cargo cargo = Cargo.findById(id);
		try{
			cargo.delete();
			renderText("Cargo removido com sucesso!!!");
		}
		catch(Exception e)
		{
			renderText("Impossível remover este cargo, pois o mesmo está vinculado a um usuário");
		}
	}

	public static void buscaEditarCargo(Long id) {
		Cargo cargo = Cargo.findById(id);
		renderJSON(cargo);
	}

	public static void editarCargo(Long id, String nomeEdicao) {
		Cargo cargo = Cargo.findById(id);
		cargo.editarNomeCargo(nomeEdicao);
		cargo.save();
	}
}
