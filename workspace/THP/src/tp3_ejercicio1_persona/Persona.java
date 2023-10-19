package tp3_ejercicio1_persona;

public class Persona {
 private String nombre;
 private String apellido;
 private String direccion;
 private String dni;
 
 public Persona(String nomb,String ape, String dire, String nro) {
	 setNombre(nomb);
	 setApellido(ape);
	 setDireccion(dire);
	 setDni(nro);
 }
 
 
 



@Override
public String toString() {
	return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", dni=" + dni + "]";
}






private void setNombre(String nombre){
	 this.nombre= nombre;
	 
 }
 private void setApellido(String apellido){
	 this.apellido= apellido;
	 
 }
 
 public void setDireccion(String direccion){
	 this.direccion= direccion;
	 
 }
 
 private void setDni(String nro){
	 this.dni=nro;
 }
 
 public String getNombre(){
	 return this.nombre;
 }
 
 
 public String getApellido(){
	 return this.apellido;
 }
 public String getDireccion(){
	 return this.direccion;
 }
 
 public String getDni(){
	 return this.dni;
 }
}
