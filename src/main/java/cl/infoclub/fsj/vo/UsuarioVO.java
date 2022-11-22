package cl.infoclub.fsj.vo;

import java.util.List;

import cl.infoclub.fsj.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class UsuarioVO extends GenericVO {
	List<Usuario> usuarios;
	 public UsuarioVO(String mensaje, String codigo, List<Usuario>usuarios) {
	 super(mensaje, codigo);
	 this.usuarios = usuarios;
	 }
}
