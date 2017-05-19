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

public class Utilidades extends BaseController{

	public static void validacao(MensagemValidacao msg)
	{
		renderJSON(msg);
	}
	
}