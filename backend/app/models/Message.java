package models;
import play.i18n.Messages;
import util.MessageUtil;

public class Message<T> {
   
   private String text;
   
   private T data;
       
   public Message(String key, Object... args) {
       
       this.text = Messages.get(key, args);
       
       if(this.text.equals(key) && args != null)
           this.text = String.format(key, args);
       
   }
   
   public String getText() {
       return this.text;
   }    public T getData() {
        return data;
    }
    
    public Message withData(T data) {
        
       this.data = data;
       
       return this;
       
   }
        
}