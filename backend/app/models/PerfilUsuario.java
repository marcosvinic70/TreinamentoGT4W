package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class PerfilUsuario extends Model {
    public String nome;

    PerfilUsuario(String nome) {
        this.nome = nome;
    }

    public void editarPerfil(String nome) {
        this.nome = nome;
    }
}