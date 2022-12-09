package ar.edu.unju.edm.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pregunta implements Serializable{
	
	@Id
	@Column(name = "cod_pregunta")
	private Long codPregunta;
	private String enunciado;
	private int nivel;
	private int opcion01;
	private int opcion02;
	private int opcion03;
	private int opcion04;
	@Column(name = "opcion")
	private int opcionCorrecta;
	private Long puntaje;
	
}
