package co.com.Taller.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clase POM de la pagina donde eliminamos un cliente.
 *
 * @author Santiago Medina Pelaez
 */
public class DeleteCustomer {

    WebDriver driver;
    //Objeto con el textBox para ingresar el ID del cliente a eliminar.
    By campoCustomerId = By.name("cusid");
    //Objeto con el boton para enviar el ID y elimianr el cliente.
    By botonEnviar = By.name("AccSubmit");
    //Objeto con el boton para limpiar los campos del formulario.
    By botonLimpiar = By.name("res");

    public DeleteCustomer(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Método para ingresar el ID del cliente a eliminar en el campo del
     * formulario.
     *
     * @param customerId
     */
    public void setCampoCustomerId(String customerId) {
        driver.findElement(campoCustomerId).sendKeys(customerId);
    }

    /**
     * Clic en el boton submit para eliminar un cliente.
     */
    public void clicSubmit() {
        driver.findElement(botonEnviar).click();
    }

    /**
     * Clic para limpiar campos del formulario.
     */
    public void clicReset() {
        driver.findElement(botonLimpiar).click();
    }

    /**
     * Método para aceptar el mensaje de alerta.
     */
    public void clicAceptarAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * Método para extraer el mensaje de las alertas.
     *
     * @return String
     */
    public String gettextoAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * Método que recibe el ID del cliente y usando los métodos de la clase,
     * elimina un cliente.
     *
     * @param idCliente
     */
    public void eliminarCliente(String idCliente) {
        setCampoCustomerId(idCliente);
        clicSubmit();
        clicAceptarAlert();
    }

    /**
     * Método para extraer mensaje de las alertas y aceptarlas.
     *
     * @return String.
     */
    public String AceptarYExtraerMensajeAlerta() {
        String mensaje = gettextoAlert();
        clicAceptarAlert();

        return mensaje;
    }
}
