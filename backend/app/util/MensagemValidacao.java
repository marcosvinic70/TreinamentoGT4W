package util;

import play.*;
import models.*;

public class MensagemValidacao 
{
	public String mensagemErro;
	public String mensagemSucesso;
	
	public MensagemValidacao(){
		mensagemErro = new String();
		mensagemSucesso = new String();
	}
}
