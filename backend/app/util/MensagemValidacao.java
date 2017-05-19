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
	
	public void setMensagemErro(String mensagemErro){
		this.mensagemErro = mensagemErro;
	}
	public void setMensagemSucesso(String mensagemSucesso){
		this.mensagemSucesso = mensagemSucesso;
	}
}
