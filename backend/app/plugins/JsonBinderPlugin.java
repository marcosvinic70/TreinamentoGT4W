package plugins;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import deserializers.DateDeserializer;
import play.Logger;
import play.PlayPlugin;
import play.mvc.Http.Request;

public class JsonBinderPlugin extends PlayPlugin {

	private Gson gson;

	public void onLoad() {
		Logger.info("JsonBinderPlugin loaded.");

		gson = new GsonBuilder()
					.registerTypeAdapter(Date.class, new DateDeserializer())
					.create();
	}

	public Object bind(String name, Class clazz, Type type, Annotation[] annotations, Map<String, String[]>params) {

		Request currentRequest = Request.current();
	    String contentType = currentRequest.contentType;

	    if ("application/json".equals(contentType) && !currentRequest.routeArgs.containsKey(name)) {
	      return getJson(clazz, name);
	    }

	    return null;
	}

	private Object getJson(Class clazz, String name) {

		try {

			String body = Request.current().params.get("body");
	        	JsonElement jsonElem = new JsonParser().parse(body);

	        if (jsonElem.isJsonObject()) {

	            JsonObject json = (JsonObject) jsonElem;
                	return gson.fromJson(json, clazz);

	        } else if (jsonElem.isJsonArray()) {

              	return gson.fromJson(jsonElem.getAsJsonArray(), clazz);
	        }
	   } catch (Exception e) {
	   	Logger.error("JSON Binder - Problem rendering JSON: %s", e.getMessage());
		e.printStackTrace();
	   }

	   return null;
	}
}
