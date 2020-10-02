package com;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_curso")

//lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

// clases

public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "categoria")
	private String categoria;
	@Column(name = "estado")
	private String estado;

}
