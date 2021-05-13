package ups.edu.ec.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "telefono")
public class Telefono {
	
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    
    @Column(name = "cedula")
    protected String cedula;
    
    @Column(name = "numero")
    protected String numero;

    @Column(name = "tipo")
    protected String tipo;

    @Column(name = "aoperadora")
    protected String aoperadora;
 
public Telefono() {
}
	public Telefono(String cedula, String numero, String tipo, String aoperadora) {
		super();
		this.cedula=cedula;
		this.numero=numero;
		this.tipo=tipo;
	}
	public Telefono(int id, String cedula, String numero, String tipo, String aoperadora) {
		super();
		this.id=id;
		this.cedula=cedula;
		this.numero=numero;
		this.tipo=tipo;
	}


	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getCedula() {
		return cedula;
	}




	public void setCedula(String cedula) {
		this.cedula = cedula;
	}




	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public String getAoperadora() {
		return aoperadora;
	}




	public void setAoperadora(String aoperadora) {
		this.aoperadora = aoperadora;
	}




}
