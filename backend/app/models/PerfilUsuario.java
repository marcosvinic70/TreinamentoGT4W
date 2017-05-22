package models;

import java.util.*;
import javax.persistence.*;
import util.MensagemValidacao;
import play.db.jpa.*;

@Entity
public class PerfilUsuario extends Model {
    public String nome;

    public PerfilUsuario(String nome) {
        this.nome = nome;
    }

    public void editarPerfil(String nome) {
        this.nome = nome;
    }
}