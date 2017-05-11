package results;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSerializer;

import flexjson.JSONSerializer;
import play.mvc.Http;
import play.mvc.results.Result;
import serializers.DateSerializer;

public class RenderJson extends Result {

	private static GsonBuilder builder;
	private static Gson gson;
	
	private JSONSerializer jsonSerializer;

	private final Object object;

	static {

		builder = new GsonBuilder()
				.serializeSpecialFloatingPointValues()
				.registerTypeAdapter(Date.class, new DateSerializer());

	}

	public RenderJson(Object object) {

		this.object = object;
		
		gson = builder.create();

	}

	public RenderJson(Object object, JsonSerializer<?>... adapters) {

		this.object = object;
		
		for (Object adapter : adapters) {

			Type t = getMethod(adapter.getClass(), "serialize").getParameterTypes()[0];

			builder.registerTypeAdapter(t, adapter);

		}

		gson = builder.create();

	}
	
	public RenderJson(Object object, JSONSerializer jsonSerializer) {
		
		this.object = object;
		this.jsonSerializer = jsonSerializer;
		
	}	

	@Override
	public void apply(Http.Request request, Http.Response response) {

		response.contentType = "application/json";

		if(jsonSerializer != null) {
			
			try {
				response.out.write(jsonSerializer.serialize(object).getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {

			try {
				response.out.write(gson.toJson(object).getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private static Method getMethod(Class clazz, String methodName) {

		Method bestMatch = null;
		
		for (Method m : clazz.getDeclaredMethods()) {
			
			if (m.getName().equals(methodName) && !m.isBridge()) {
				
				if (bestMatch == null || !Object.class.equals(m.getParameterTypes()[0])) {
					bestMatch = m;
				}
				
			}
			
		}
		
		return bestMatch;
		
	}

}
