package co.com.Taller.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clase POM de la pagina home.
 *
 * @author Santiago Medina Pelaez
 */
public class Home {

    WebDriver driver;

    //Variable que guardara el link al objeto "New Customer" que esta en el menu.
    By newCustomer = By.linkText("New Customer");
    //Variable que guardara el link al objeto "Delete Customer" que esta en el menu.
    By deleteCustomer = By.linkText("Delete Customer");
    //Variable que guardara el texto que contiene el id del usuario que inicio sesion.
    By idUsuario = By.xpath("//td[contains(text(),'Manger Id :')]");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Retorna el valor que aparece en la pagina home que muestra el ID del
     * usuario que acaba de iniciar sesion. Dicho valor esta dentro de una celda
     * en una tabla que esta dentro de otra tabla.
     *
     * @return String con el texto del id del usuario ingresado.
     */
    public String getIdUsuario() {
        return driver.findElement(idUsuario).getText();
    }

    /**
     * Clic en el boton New Customer, del menu, para ir a la pagina donde
     * podremos crear nuevos clientes.
     */
    public void clickNewCustomer() {
        driver.findElement(newCustomer).click();
    }

    /**
     * Clic en el boton Delete Customer, del menu, para ir a la página donde
     * podremos eliminar un cliente.
     */
    public void clickDeleteCustomer() {
        driver.findElement(deleteCustomer).click();
    }
}
