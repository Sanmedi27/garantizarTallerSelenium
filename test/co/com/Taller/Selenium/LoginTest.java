package co.com.Taller.Selenium;

import co.com.Taller.POM.Home;
import co.com.Taller.POM.Login;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Clase con las pruebas automatizadas para el login de usuario.
 *
 * @author Santiago Medina Pelaez
 */
public class LoginTest {

    private static WebDriver driver = null;
    //POM de la pagina login.
    Login loginPOM;
    //POM de la pagina home.
    Home homePOM;

    //String con el nombre de usuario.
    String usuario;
    //String con la contraseña del usuario.
    String contrasena;

    public LoginTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        driver.get("http://demo.guru99.com/V4/index.php");

        usuario = "mngr162001"; //Nombre de usuario
        contrasena = "udUbyjy"; //Contraseña del suuario
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Caso de Prueba: Caso de prueba en donde se va a la pagina del login, se
     * ingresan el nombre de usuario y contraseña en los textBox
     * coorrespondientes y se da clic en el boton submit. Se va luego a la
     * pagina home donde aparece mensaje con el usuario que acabo de ingresar
     * sesion, se toma dicho mensaje y se verifica en un assertEquals que el
     * mensaje corresponde al usuario que se ingreso.
     *
     * - Objeto actual: "Manger Id : mngr162001".
     */
    @Test
    public void iniciarSesionTest() {
        //Inicializamos el POM de las páginas login y home.
        loginPOM = new Login(driver);
        homePOM = new Home(driver);

        //Método para iniciar sesión.
        loginPOM.aplicacionLogin(usuario, contrasena);

        /*Punto de verificación donde se compara el mensaje que aparece
                en la página home con el id de usuario que ingresamos.*/
        assertEquals("Validar Id del Usuario",
                "Manger Id : " + usuario,
                homePOM.getIdUsuario());
    }
}
