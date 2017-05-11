package deserializers;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import play.Play;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DateDeserializer implements JsonDeserializer<Date> {

	private static final String DATE_FORMAT = Play.configuration.getProperty("date.format");
	private static final String DATE_FORMAT_TIMETABLE = Play.configuration.getProperty("date.format.timetable");

    private static SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
    private static SimpleDateFormat timetableFormatter = new SimpleDateFormat(DATE_FORMAT_TIMETABLE);

    @Override
    public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
    	
    	String date = json.getAsJsonPrimitive().getAsString();
    	
    	if(date.length() <= 10)
    		return parseDate(date);
    	else
    		return parseDateWithTimetable(date);
    	
    }

    public static Date parseDate(String dateText) {
    	
        try {
        	
          return formatter.parse(dateText);
          
        } catch (ParseException e) {
        	
          e.printStackTrace();
          return null;
          
        }
        
    }
    
    public static Date parseDateWithTimetable(String dateText) {
    	
        try {
        	
          return timetableFormatter.parse(dateText);
          
        } catch (ParseException e) {
        	
          e.printStackTrace();
          return null;
          
        }
        
    }
    
}
