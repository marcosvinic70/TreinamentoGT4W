package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Usuario extends Model {
    public String nome;
    public int cpf;
    public Date dataNascimento;
    public String sexo;
    public Date dataCadastro;

    @OneToMany
    public Cargo cargo;

    @ManyToMany
    public List<PerfilUsuario> listaPerfil;

    public Usuario(String nome, int cpf, String cargo, List<String>perfis, String sexo, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = new Cargo(cargo);
        this.dataCadastro = new Date();

        if(sexo.equalsIgnoreCase("") != true) {
            this.sexo = sexo;
        }

        if(dataNascimento != null) {
            this.dataNascimento = dataNascimento;
        }

        if(perfis != null) {
            for(String perfil : perfis)
            {
                listaPerfil.add(new PerfilUsuario(perfil));
            }
        }

    }

    public void editar(String nome, int cpf, String cargo, List<String>perfis, String sexo, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = new Cargo(cargo);
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = new Date();
        
        listaPerfil.clear();
        for(String perfil : perfis) 
        {
            listaPerfil.add(new PerfilUsuario(perfil));
        }
    }
}