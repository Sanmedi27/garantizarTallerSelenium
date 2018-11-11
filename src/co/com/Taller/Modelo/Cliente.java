package co.com.Taller.Modelo;

import java.util.Objects;

/**
 * Clase con los atributos y métodos de la clase CLiente. Esta clase se hizo
 * para facilitar la recolección y escritura de los diferentes datos que compone
 * un Cliente para así hacer las pruebas mucha más sencillas.
 *
 * @author Santiago Medina Pelaez
 */
public class Cliente {

    private String id;
    private String nombre;
    private String genero;
    private String fechaNacimiento;
    private String direccion;
    private String ciudad;
    private String departamento;
    private String pin;
    private String celular;
    private String email;
    private String contrasena;

    public Cliente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método para establecer la fecha de nacimiento, esta fecha debe ser en
     * formato dd-mm-aaaa.
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPin() {
        return pin;
    }

    /**
     * Método para establecer el PIN del cliente, dicho PIN debe ser un número
     * con longitud 6.
     *
     * @param pin
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCelular() {
        return celular;
    }

    /**
     * Método para establecer el número del celular del cliente, dicho valor
     * debe ser numerico.
     *
     * @param celular
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.genero);
        hash = 59 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 59 * hash + Objects.hashCode(this.direccion);
        hash = 59 * hash + Objects.hashCode(this.ciudad);
        hash = 59 * hash + Objects.hashCode(this.departamento);
        hash = 59 * hash + Objects.hashCode(this.pin);
        hash = 59 * hash + Objects.hashCode(this.celular);
        hash = 59 * hash + Objects.hashCode(this.email);
        return hash;
    }

    /**
     * Método equals que toma todo los campos de un cliente, excepto la
     * contraseña, para asi verificar que dos clientes son iguales. No se toma
     * la contraseña debido a que ésta no aparece en la tabla que muestra los
     * datos del nuevo cliente, por lo que al comparar el cliente ingresado (con
     * contraseña) contra el cliente creado con los datos recogidos de dicha
     * tabla (sin contraseña) no serian iguales.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        if (!Objects.equals(this.pin, other.pin)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

}
