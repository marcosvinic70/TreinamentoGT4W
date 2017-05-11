package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSerializer;

import flexjson.JSONSerializer;
import play.Logger;
import play.db.jpa.JPA;
import play.i18n.Messages;
import play.mvc.Catch;
import play.mvc.Controller;
import results.Redirect;
import results.RenderJson;
import results.Unauthorized;

public class BaseController extends Controller {

	protected static Gson gson;

	static {

		GsonBuilder builder = new GsonBuilder()
				.serializeSpecialFloatingPointValues();

		gson = builder.create();

	}
	
	
	/**
	 * Tratamento de exceção geral. 
	 * 
	 * As exceções não tratadas que chegam à controller serão tratadas por este método. 
	 * 
	 * É retornado o status 500 e o texto de mensagem.
	 *  
	 * @param exception Excessão capturada.
	 */
	@Catch(value = Exception.class, priority = 3)
	protected static void returnIfExceptionRaised(Exception exception) {

		Logger.error(exception, exception.getMessage());

		JPA.setRollbackOnly();

		error(Messages.get("erro.padrao"));

	}
	
	/**
     * Render a 200 OK application/json response.
     * 
     * @param o The Java object to serialize
     * 
     */
	protected static void renderJSON(Object model) {
		throw new RenderJson(model);
	}
	
	/**
     * Render a 200 OK application/json response.
     * 
     * @param o The Java object to serialize
     * @param adapters A set of GSON serializers/deserializers/instance creator to use
     * 
     */
    protected static void renderJSON(Object o, JsonSerializer<?>... adapters) {
        throw new RenderJson(o, adapters);
    }

    /**
     * Render a 200 OK application/json response.
     * 
     * @param o The Java object to serialize
     * @param jsonSerializer A Flexjson serializers to use
     * 
     */
	protected static void renderJSON(Object model, JSONSerializer jsonSerializer) {
		throw new RenderJson(model, jsonSerializer);
	}
	
	/**
	 * Send a 401 Unauthorized response
	 */
	protected static void unauthorized() {
		throw new Unauthorized();
	}

	/**
	 * Send a 307 Redirect response
	 */
	protected static void frontEndRedirect(String url) {
		throw new Redirect(url);
	}
	

	protected static List<Integer> getParamAsIntegerList(String key) {

		String value = request.params.get(key);

		if (value == null || value.isEmpty())
			return null;

		String[] textLongs = value.split(",");

		if (textLongs.length == 0)
			return null;

		List<Integer> ints = new ArrayList<Integer>();

		for (String s : textLongs) {
			ints.add(Integer.parseInt(s));
		}

		return ints;

	}

	protected static void renderFile(String nomeFile, String pathFile) throws IOException {
		
		File file = new File(pathFile);
		
		file.createNewFile();
		
		if(file.exists() || file.getAbsoluteFile().exists()) {
			
			response.setHeader("Content-Disposition", "attachment; filename=" + nomeFile);
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Content-Type", "application/download");
//			response.chunked = true;
			renderBinary(file);
			
		}
	}
}
