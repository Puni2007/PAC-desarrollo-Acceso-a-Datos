package pac;

public class Profesor {
	
	private Long id;
	private String nombre;
	private String sexo;
	
	public Profesor(String nombre, String sexo) {
		this.nombre=nombre;
		this.sexo=sexo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Insert into profesor, nombre: " + getNombre() + ", sexo: " + getSexo();
	}
	
	

}
