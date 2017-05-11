package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Cargo extends Model
{
    public String nome;

    public Cargo(String nome)
    {
        this.nome = nome;
    }

    public void editarNomeCargo(String nome)
    {
        this.nome = nome;
    }

}