package co.com.Taller.POM;

import co.com.Taller.Modelo.Cliente;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clase POM de la pagina que muestra la tabla con los datos del nuevo cliente
 * luego de haber sido creado junto con un mensaje indicando el éxito en crear
 * un cliente.
 *
 * @author Santiago Medina Pelaez
 */
public class CustomerReg {

    private WebDriver driver;
    //Objeto con el mensaje de que el cliente fue creaco con éxito.
    By mensaje = By.xpath("//*[@id='customer']/tbody/tr[1]/td/p");
    //Objeto con el campo en la tabla con el ID del cliente. 
    By customerId = By.xpath("//*[@id='customer']/tbody/tr[4]/td[2]");
    //Objeto con el campo en la tabla con el nombre del cliente.
    By nombre = By.xpath("//*[@id='customer']/tbody/tr[5]/td[2]");
    //Objeto con el campo en la tabla con el género del cliente.
    By genero = By.xpath("//*[@id='customer']/tbody/tr[6]/td[2]");
    //Objeto con el campo en la tabla con la fecha de nacimiento del cliente.
    By fechaNacimiento = By.xpath("//*[@id='customer']/tbody/tr[7]/td[2]");
    //Objeto con el campo en la tabla con la dirección del cliente.
    By direccion = By.xpath("//*[@id='customer']/tbody/tr[8]/td[2]");
    //Objeto con el campo en la tabla con la ciudad del cliente.
    By ciudad = By.xpath("//*[@id='customer']/tbody/tr[9]/td[2]");
    //Objeto con el campo en la tabla con el departamento del cliente.
    By departamento = By.xpath("//*[@id='customer']/tbody/tr[10]/td[2]");
    //Objeto con el campo en la tabla con el PIN del cliente.
    By pin = By.xpath("//*[@id='customer']/tbody/tr[11]/td[2]");
    //Objeto con el campo en la tabla con celular del cliente
    By celular = By.xpath("//*[@id='customer']/tbody/tr[12]/td[2]");
    //Objeto con el campo en la tabla con el email del cliente.
    By email = By.xpath("//*[@id='customer']/tbody/tr[13]/td[2]");

    public CustomerReg(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Método para extraer el mensaje de exito de que se cre un nuevo cliente.
     *
     * @return String
     */
    public String getMensaje() {
        return driver.findElement(mensaje).getText();
    }

    /**
     * Método para extraer el ID numerico del nuevo cliente.
     *
     * @return String
     */
    public String getCustomerId() {
        return driver.findElement(customerId).getText();
    }

    /**
     * Método para extraer el nombre del cliente de la tabla
     *
     * @return String
     */
    public String getNombre() {
        return driver.findElement(nombre).getText();
    }

    /**
     * Método para extraer el género del cliente de la tabla
     *
     * @return String
     */
    public String getGenero() {
        return driver.findElement(genero).getText();
    }

    /**
     * Método para extraer la fecha de nacimiento del cliente de la tabla, dicha
     * fecha viene en formato AAAA-MM-DD, el cual es diferente al formato
     * DD-MM-AAAA con el cual se ingreso en el formulario; él metodo extae la
     * fecha y la convierte al formato con el que fue ingresado al crear el
     * cliente para asi poder facilitar la comparación en el assert
     *
     * @return String
     */
    public String getFechaNacimiento() {
        //La fecha AAAA-MM-DD es partido segun el - en un arreglo de String.
        String[] arregloFecha = driver.findElement(fechaNacimiento).getText().split("-", 3);

        //Se retorna String con el formato DD-MM-AAAA
        return arregloFecha[2] + "-" + arregloFecha[1] + "-" + arregloFecha[0];
    }

    /**
     * Método para extraer la dirección del cliente de la tabla
     *
     * @return String
     */
    public String getDireccion() {
        return driver.findElement(direccion).getText();
    }

    /**
     * Método para extraer la ciudad del cliente de la tabla
     *
     * @return String
     */
    public String getCiudad() {
        return driver.findElement(ciudad).getText();
    }

    /**
     * Método para extraer el departamento del cliente de la tabla
     *
     * @return String
     */
    public String getDepartamento() {
        return driver.findElement(departamento).getText();
    }

    /**
     * Método para extraer el PIN del cliente de la tabla
     *
     * @return String
     */
    public String getPin() {
        return driver.findElement(pin).getText();
    }

    /**
     * Método para extraer el celular del cliente de la tabla
     *
     * @return String
     */
    public String getCelular() {
        return driver.findElement(celular).getText();
    }

    /**
     * Método para extraer el email del cliente de la tabla
     *
     * @return String
     */
    public String getEmail() {
        return driver.findElement(email).getText();
    }

    /**
     * Método que usa los métodos de la clase para extraer la información de la
     * tabla con los datos del nuevo cliente creado; los datos se guardan en un
     * objeto de la clase cliente.
     *
     * @return Cliente
     */
    public Cliente clienteRegistrado() {
        /*Se extrae la información del cliente y se ingresa en un objeto
            de clase Cliente*/
        Cliente clienteRegistrado = new Cliente();
        clienteRegistrado.setId(getCustomerId());
        clienteRegistrado.setNombre(getNombre());
        clienteRegistrado.setGenero(getGenero());
        clienteRegistrado.setFechaNacimiento(getFechaNacimiento());
        clienteRegistrado.setDireccion(getDireccion());
        clienteRegistrado.setCiudad(getCiudad());
        clienteRegistrado.setDepartamento(getDepartamento());
        clienteRegistrado.setPin(getPin());
        clienteRegistrado.setCelular(getCelular());
        clienteRegistrado.setEmail(getEmail());

        //Retorna objeto Cliente con los datos.
        return clienteRegistrado;
    }

}
