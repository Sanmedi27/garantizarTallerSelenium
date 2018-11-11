package co.com.Taller.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clase POM de la pagina login donde vemos los metodos para ingresar usuario y
 * contraseña para así iniciar sesión. .
 *
 * @author Santiago Medina Pelaez
 */
public class Login {

    WebDriver driver;
    //Variable que guarda el textbok donde escribiremos el usuario.
    private final By usuario = By.name("uid");
    //Variable que guarda el textbok donde escribiremos la contraseña.
    private final By contrasena = By.name("password");
    //Variable que guarda el boton para enviar datos e iniciar sesión.
    By ingresar = By.name("btnLogin");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Coloca el nombre en el textBox para el nombre de usuario.
     *
     * @param setUsuario String con el nombre del usuario.
     */
    public void setUsuario(String setUsuario) {
        driver.findElement(usuario).sendKeys(setUsuario);
    }

    /**
     * Coloca la contraseña en el textBox para el password del usuario.
     *
     * @param setContrasena String con la contraseña del usuario.
     */
    public void setContrasena(String setContrasena) {
        driver.findElement(contrasena).sendKeys(setContrasena);
    }

    /**
     * Clic en el boton Login para así iniciar sesión.
     */
    public void clickLogin() {
        driver.findElement(ingresar).click();
    }

    /**
     * Método que recibe el usuario y la contraseña del usuario. Los ingresa en 
     * los elementos respectivos y activa el método que da click al boton Login.
     *
     * @param usuario
     * @param contrasena
     */
    public void aplicacionLogin(String usuario, String contrasena) {
        //Llena nombre usuario.
        this.setUsuario(usuario);
        //Llena contraseña del usuario.
        this.setContrasena(contrasena);
        //Clic en boton Login.
        this.clickLogin();
    }
}
