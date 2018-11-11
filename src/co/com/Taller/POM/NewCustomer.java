package co.com.Taller.POM;

import co.com.Taller.Modelo.Cliente;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Clase POM de la pagina donde ingresamos los datos para crear un nuevo
 * cliente.
 *
 * @author Santiago Medina Pelaez
 */
public class NewCustomer {

    WebDriver driver;
    //Objeto con el mensaje de que el campo nombre cliente debe ser llenado.
    By customerNameMensaje = By.id("message");
    //Objeto con el textBox para ingresar el nombre del nuevo cliente.
    By campoCustomerName = By.name("name");
    //Objeto con el radioButton Female para ingresar el género del nuevo cliente
    //si este es femenino.
    By campoGeneroF = By.xpath("//input[@value='f']");
    //Objeto con el radioButton Male para ingresar el género del nuevo cliente
    //si este es masculino.
    By campoGeneroM = By.xpath("//input[@value='m']");
    //Objeto con el textBox para ingresar la fecha de nacimiento del nuevo cliente.
    By campoFechaNacimiento = By.id("dob");
    //Objeto con el textBox para ingresar la dirección del nuevo cliente.
    By campoDireccion = By.name("addr");
    //Objeto con el textBox para ingresar la ciudad del nuevo cliente.
    By campoCiudad = By.name("city");
    //Objeto con el textBox para ingresar el departamento del nuevo cliente.
    By campoDepartamento = By.name("state");
    //Objeto con el textBox para ingresar el PIN del nuevo cliente.
    By campoPIN = By.name("pinno");
    //Objeto con el textBox para ingresar el celular del nuevo cliente.
    By campoCelular = By.name("telephoneno");
    //Objeto con el textBox para ingresar el email del nuevo cliente.
    By campoEmail = By.name("emailid");
    //Objeto con el textBox para ingresar la contraseña del nuevo cliente.
    By campoContrasenaCliente = By.name("password");
    //Objeto con el boton para enviar los datos y crear un nuevo cliente.
    By botonEnviar = By.name("sub");
    //Objeto con el boton para limpiar los campos del formulario.
    By botonLimpiar = By.name("res");

    public NewCustomer(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clic en el textBok para ingresar el nombre del cliente.
     */
    public void clicCampoCustomerName() {
        driver.findElement(campoCustomerName).click();
    }

    /**
     * Clic en el texBox para ingresar la fecha de nacimiento del cliente.
     */
    public void clicDateOdBirth() {
        driver.findElement(campoFechaNacimiento).click();
    }

    /**
     * Método que retorna un String con el mensaje que explica que el campo del
     * nombre del cliente debe ser llenado, no puede quedar vacio; el mensaje
     * sólo aparece luego de que se le ha dado clic al textBox del nombre del
     * cliente y luego clic a otra parte del formulario, dejando por tanto dicho
     * textBox vacio.
     *
     * @return String.
     */
    public String getHiddenMessageCustomerName() {
        return driver.findElement(customerNameMensaje).getText();
    }

    /**
     * Método que recibe el nombre del cliente para ser ingresado en el textBox
     * dle nombre del cliente.
     *
     * @param nombreCliente
     */
    public void setNombreCliente(String nombreCliente) {
        driver.findElement(campoCustomerName).sendKeys(nombreCliente);
    }

    /**
     * Método que recibe el género del cliente y según si éste es female o male
     * da clic en el radioButton correspondiente. Si el género no corresponde a
     * ninguna de estas 2 opciones, entonces imprime en consola que el genero
     * del cliente es inorrecto.
     *
     * @param generoCliente
     */
    public void setGeneroCliente(String generoCliente) {
        if (generoCliente.equalsIgnoreCase("male")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;",
                    driver.findElement(campoGeneroM));
        } else if (generoCliente.equalsIgnoreCase("female")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;",
                    driver.findElement(campoGeneroF));
        } else {
            //Imprime que el genero es incorrecto ya que no es ni female o male.
            System.out.println("Genero cliente incorecto");
        }
    }

    /**
     * Método para ingresar la fecha de nacimiento del cliente en el campo
     * correspondiente; dicho campo debe tener formato dd-mm-aaaa, sino los
     * valores no seran bien colocados en el dormulario.
     *
     * @param fechaNacimientoCliente
     */
    public void setFechaNacimientoCliente(String fechaNacimientoCliente) {
        driver.findElement(campoFechaNacimiento).sendKeys(fechaNacimientoCliente);
    }

    /**
     * Método para ingresar la dirección del cliente en el campo
     * correspondiente.
     *
     * @param direccionCliente
     */
    public void setDireccionCliente(String direccionCliente) {
        driver.findElement(campoDireccion).sendKeys(direccionCliente);
    }

    /**
     * Método para ingresar la ciudad donde recide el cliente en el campo
     * correspondiente.
     *
     * @param ciudadCliente
     */
    public void setCiudadCliente(String ciudadCliente) {
        driver.findElement(campoCiudad).sendKeys(ciudadCliente);
    }

    /**
     * Método para ingresar el departamento/estado/provincia en donde habita el
     * cliente.
     *
     * @param departamentoCliente
     */
    public void setDepartamentoCliente(String departamentoCliente) {
        driver.findElement(campoDepartamento).sendKeys(departamentoCliente);
    }

    /**
     * Método para ingresar el PIN del cliente en el campo correspondiente del
     * formlario. Dicho PIN debe ser de longitud 6 y sólo pueden ser números.
     *
     * @param pinCliente
     */
    public void setPINCliente(String pinCliente) {
        driver.findElement(campoPIN).sendKeys(pinCliente);
    }

    /**
     * Método para ingresar el número celular del cliente en el campo
     * correspondiente, dicho valor debe ser numerico.
     *
     * @param celularCliente
     */
    public void setCelularCliente(String celularCliente) {
        driver.findElement(campoCelular).sendKeys(celularCliente);
    }

    /**
     * Método para ingresar el email del cliente en el campo correspondiente.
     *
     * @param emailCliente
     */
    public void setEmailCliente(String emailCliente) {
        driver.findElement(campoEmail).sendKeys(emailCliente);
    }

    /**
     * Método para ingresar la contraseña del cliente en el campo
     * correspondiente.
     *
     * @param contrasenaCliente
     */
    public void setContrasenaCliente(String contrasenaCliente) {
        driver.findElement(campoContrasenaCliente).sendKeys(contrasenaCliente);
    }

    /**
     * Clic al boton submit para enviar la informacion y crear el nuevo cliente.
     */
    public void clicSubmit() {
        driver.findElement(botonEnviar).click();
    }

    /**
     * Clic al boton reset para limpiar la informacion del formulario.
     */
    public void clicReset() {
        driver.findElement(botonLimpiar).click();
    }

    /**
     * Clic para aceptar los mensajes de alerta que aparezcan.
     */
    public void clicAceptarAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * Método para extraer el texto d elos mensajes de alerta que aparescan.
     *
     * @return String
     */
    public String gettextoAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * Método que utiliza los métodos de la clase NewCustomer para
     * automaticamente crear un nuevo cliente en la pagina correspondiente.
     * Dicho método recibe un objeto de clase Cliente con toda la información
     * necesaria para la creación de un nuevo cliente.
     *
     * @param cliente
     */
    public void crearNuevoCliente(Cliente cliente) {
        /*Se mandan los datos al formulario con la información del
        nuevo cliente*/
        this.setNombreCliente(cliente.getNombre());
        this.setGeneroCliente(cliente.getGenero());
        this.setFechaNacimientoCliente(cliente.getFechaNacimiento());
        this.setDireccionCliente(cliente.getDireccion());
        this.setCiudadCliente(cliente.getCiudad());
        this.setDepartamentoCliente(cliente.getDepartamento());
        this.setPINCliente(cliente.getPin());
        this.setCelularCliente(cliente.getCelular());
        this.setEmailCliente(cliente.getEmail());
        this.setContrasenaCliente(cliente.getContrasena());

        /*Se da clic al boton submit para enviar la información y crear
        el nuevo cliente*/
        this.clicSubmit();
    }
}
