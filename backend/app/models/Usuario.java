package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Usuario extends Model {
    public String nome;
    public Long cpf;
    public Date dataNascimento;
    public String sexo;
    public Date dataCadastro;

    @ManyToOne
    public Cargo cargo;

    @ManyToMany
    public List<PerfilUsuario> listaPerfil;

    public Usuario(String nome, Long cpf, String cargo, List<String>perfis, String sexo, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataCadastro = new Date();
        this.listaPerfil = new ArrayList<PerfilUsuario>();


        Cargo c = Cargo.find("nome",cargo).first();
        if(c == null) {
            this.cargo = new Cargo(cargo);
            this.cargo.save();
        }
        else {
            this.cargo = c;
        }

        if(sexo != null) {
            this.sexo = sexo;
        }

        if(dataNascimento != null) {
            this.dataNascimento = dataNascimento;
        }

        if(perfis != null) {
            for(String perfil : perfis)
            {
                PerfilUsuario p = PerfilUsuario.find("nome",perfil).first();
                if(p == null) {
                    PerfilUsuario pAux = new PerfilUsuario(perfil);
                    pAux.save();
                    listaPerfil.add(pAux);
                }
                else {
                    listaPerfil.add(p);
                }
            }
        }

    }

    public void editar(String nome, Long cpf, String cargo, List<String>perfis, String sexo, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = new Date();

        Cargo c = Cargo.find("nome",cargo).first();
        if(c == null) {
            this.cargo = new Cargo(cargo);
            this.cargo.save();
        }
        else {
            this.cargo = c;
        }
        
        listaPerfil.clear();
        if(perfis != null) {
            for(String perfil : perfis)
            {
                PerfilUsuario p = PerfilUsuario.find("nome",perfil).first();
                if(p == null) {
                    PerfilUsuario pAux = new PerfilUsuario(perfil);
                    pAux.save();
                    listaPerfil.add(pAux);
                }
                else {
                    listaPerfil.add(p);
                }
            }
        }
    }
}