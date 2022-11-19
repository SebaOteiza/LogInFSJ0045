package cl.infoclub.fsj.modelo;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {
	
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String clave;
	private int rut;
	private String dv;
	private String usuario;
	
	
	
	

}
