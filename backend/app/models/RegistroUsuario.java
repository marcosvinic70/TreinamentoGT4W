package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class RegistroUsuario extends Model {
    public String nome;
    public Long cpf;
    public Date dataNascimento;
    public String sexo;
    public Date dataDelete;
    public String cargo;
    public String listaPerfil;

    public RegistroUsuario (Usuario user) {
        this.nome = user.nome;
        this.cpf = user.cpf;
        this.sexo = user.sexo;
        this.dataNascimento = user.dataNascimento;
        this.cargo = user.cargo.nome;
        this.listaPerfil = "";

        for(PerfilUsuario perfil : user.listaPerfil) {
            if(listaPerfil.compareTo("") == 0) {
                listaPerfil += perfil.nome;
            }
            else {
                listaPerfil += "," + perfil.nome;
            }
        }
        this.dataDelete = new Date();
    }
}
