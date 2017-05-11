package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Usuario extend Model {
    public String nome;
    public int cpf;
    public Date dataNascimento;
    public String sexo;
    public Date dataCadastro;

    @OneToMany
    public Cargo cargo;

    @ManyToMany
    public List<PerfilUsuario> listaPerfil;

    public Usuario(String nome, int cpf, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = new Cargo(cargo);
        this.dataCadastro = New Date();

    }

    public editar(String nome, int cpf, String cargo, List<String>perfis, String sexo, Date dataCadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = new Cargo(cargo);
        this.sexo = sexo;
        this.dataCadastro = dataCadastro;

        for(String perfil : perfis) {
            listaPerfil.clear();
            listaPerfil.add(new PerfilUsuario(perfil));
        }
    }
}