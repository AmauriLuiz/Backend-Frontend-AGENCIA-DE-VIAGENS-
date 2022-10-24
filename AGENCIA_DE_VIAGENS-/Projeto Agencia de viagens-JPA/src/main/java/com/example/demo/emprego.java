package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class emprego {

	@Id
@GeneratedValue (strategy = GenerationType.AUTO)
private long id;
@Size(min=4)
@NotNull
private String titulo;
@Size(min=3)
@NotNull
private String empresa;
@Size(min=10)
@NotNull
private String descricao;
public long getId() {
return id;
}
public void setId(long id) {
this.id = id;
}
public String getTitulo() {
return titulo;
}
public void setTitulo(String titulo) {
this.titulo = titulo;
}
public String getEmpresa() {
return empresa;
}
public void setEmpresa(String empresa) {
this.empresa = empresa;
}
public String getDescricao() {
return descricao;
}
public void setDescricao(String descricao) {
this.descricao = descricao;
}
}