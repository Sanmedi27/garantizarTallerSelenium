package co.com.Taller.Selenium;

import co.com.Taller.Modelo.Cliente;
import co.com.Taller.POM.CustomerReg;
import co.com.Taller.POM.DeleteCustomer;
import co.com.Taller.POM.Home;
import co.com.Taller.POM.Login;
import co.com.Taller.POM.NewCustomer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Clase con las pruebas automatizadas que conciernen la creación de usuario y
 * su eliminación.
 *
 * @author Santiago Medina Pelaez
 */
public class customerTest {

    private static WebDriver driver = null;
    //POM de la pagina login.
    Login loginPOM;
    //POM de la pagina home.
    Home homePOM;
    //POM de la pagina new Customer.
    NewCustomer newCustomerPOM;
    //POM de la pagina con los datos del cliente creado.
    CustomerReg registeredCustomerPOM;
    //POM de la pagina delete customer.
    DeleteCustomer deleteCustomerPOM;

    //String con el nombre de usuario.
    String usuario;
    //String con la contraseña del usuario.    
    String contrasena;
    /*String que guarda el ID del cliente que se creo en createCustomerTest
    para ser usado en deleteCustomerTest*/
    static String idClienteAEliminar;

    //Objeto de la clase cliente para guardar y extraer los datos del cliente.
    Cliente cliente;

    public customerTest() {
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
        driver.quit();
    }

    @Before
    public void setUp() {
        driver.get("http://demo.guru99.com/V4/index.php");

        usuario = "mngr176727"; //Nombre de usuario
        contrasena = "ApUvyhy"; //Contraseña del suuario

        //Inicializamos los POM utilizados en la pruebas.
        loginPOM = new Login(driver);
        homePOM = new Home(driver);
        newCustomerPOM = new NewCustomer(driver);
        registeredCustomerPOM = new CustomerReg(driver);
        deleteCustomerPOM = new DeleteCustomer(driver);

        //Inicializamos cliente con los datos para hacer las pruebas.
        cliente = new Cliente();
        cliente.setNombre("");
        cliente.setGenero("female"); //Dato debe ser female o male
        cliente.setFechaNacimiento("01-06-1992"); //Dato debe tener formato DD-MM-AAAA
        cliente.setDireccion("Calle 43 A 87C");
        cliente.setCiudad("Medellin");
        cliente.setDepartamento("Antioquia");
        cliente.setPin("123456"); //Dato debe ser número con longitud 6.
        cliente.setCelular("31643492854"); //Dato debe ser numerico.
        cliente.setEmail("rocio@email234.com");
        cliente.setContrasena("cliente2018");
    }

    @After
    public void tearDown() {
    }

    /**
     * Caso de Prueba: Comprobar si existe mensaje oculto en el html de la
     * pagina new customer que nos indique si el campo "customer name" debe ser
     * llenado, por tanto significando que el campo es obligatorio.
     *
     * - Objeto esperado: "Customer name must not be blank"
     */
    @Test
    public void customerNameVacioTest() {
        loginPOM.aplicacionLogin(usuario, contrasena);
        homePOM.clickNewCustomer(); //Vamos a pagina new customer.
        newCustomerPOM.clicCampoCustomerName(); //Clic en texBox customer name.
        newCustomerPOM.clicDateOdBirth();   //Clic en textBox date of birth

        assertEquals("Validar mensaje oculto campo customer name",
                "Customer name must not be blank",
                newCustomerPOM.getHiddenMessageCustomerName()
        );
    }

    /**
     * Caso de Prueba: Comprobar si al intentar ingresar un cliente con todos
     * sus datos excepto el nombre (customer name) si salta ventana advirtiendo
     * que todos los campos deben ser llenados, indicando entonces que el campo
     * es obligatorio.
     *
     * - Objeto esperado: "please fill all fields"
     */
    @Test
    public void customerNameVacioValidacionTest() {
        loginPOM.aplicacionLogin(usuario, contrasena);
        homePOM.clickNewCustomer(); //Vamos a pagina new customer.
        newCustomerPOM.crearNuevoCliente(cliente); //Creamos el cliente con nombre vacio.
        String textoAlerta = newCustomerPOM.gettextoAlert(); //Extraemos mensaje de alerta.
        newCustomerPOM.clicAceptarAlert(); //Aceptamos la alerta.

        assertEquals("Validar mensaje de alerta al llenar todo el formulario"
                + "menos el nombre del artista",
                "please fill all fields",
                textoAlerta);
    }

    /**
     * Caso de Prueba: Se crea un nuevo usuario y se confirma que ha sido
     * exitosamente creado, esto se hara de 2 formas: Mediante el mensaje de
     * éxito en la tabla con los datos del nuevo cliente y mediante la
     * extracción de todos los datos de la tabla y comparandose con los datos
     * que se ingresaron cuando se creo.
     *
     * - Objeto esperado1: "Customer Registered Successfully!!!"
     *
     * - Objeto esperado2: Cliente con los datos que se ingresaron.
     */
    @Test
    public void createCustomerTest() {
        cliente.setNombre("Rocio Durcal"); //Le agregamos al objeto cliente el nombre.

        loginPOM.aplicacionLogin(usuario, contrasena);
        homePOM.clickNewCustomer(); //Vamos a pagina new customer.
        newCustomerPOM.crearNuevoCliente(cliente); //Creamos el cliente con todos los datos.

        cliente.setId(registeredCustomerPOM.getCustomerId()); //Objeto cliente le agregamos el ID.

        System.out.println("ID del cliente= " + cliente.getId()); //Imprimir ID en consola.

        idClienteAEliminar = registeredCustomerPOM.getCustomerId(); //ID se guarda en variable.

        Cliente clienteActual = registeredCustomerPOM.clienteRegistrado(); //Recolectamos los datos.

        //Comparamos mensaje de alerta.
        assertEquals("Validar que los datos del cliente de la tabla correspondan"
                + "al los datos del cliente que se ingreso",
                "Customer Registered Successfully!!!",
                registeredCustomerPOM.getMensaje());

        //Comparamos los datos de los clientes.
        assertEquals("Validar que los datos del cliente de la tabla correspondan"
                + "al los datos del cliente que se ingreso",
                cliente,
                clienteActual);
    }

    /**
     * Caso de Prueba: Con el ID del cliente creado, vamos a la pagina "delete
     * customer" en donde lo ingresamos y le damos Submit. Se estrae el mensaje
     * que confirma que el cliente fue borrado exitosamente. Luego nos llevara a
     * la pagina home, donde volveremos a la pagina "delete customer" e
     * ingresaremos nuevamente el ID del cliente para intentar volverlo a
     * borrar, extraeremos mensaje donde nos indique que el cliente no existe,
     * por tanto el cliente fue eliminado de la BD.
     *
     * - Objeto esperado1: "Customer deleted Successfully".
     *
     * - Objeto esperado2: "Customer does not exist!!".
     */
    @Test
    public void deleteCustomerTest() {
        loginPOM.aplicacionLogin(usuario, contrasena);
        homePOM.clickDeleteCustomer(); //Vamos a la pagina para eliminar el cliente.

        //Eliminamos el cliente con el ID de la prueba anterior.
        deleteCustomerPOM.eliminarCliente(idClienteAEliminar);

        //Extraemos el mensaje de alerta y lo aceptamos.
        String actual1 = deleteCustomerPOM.AceptarYExtraerMensajeAlerta();

        //Volvemos a la pagina para eliminar clientes.
        homePOM.clickDeleteCustomer();

        //Ingresamos nuevamente el ID y le damos eliminar.
        deleteCustomerPOM.eliminarCliente(idClienteAEliminar);

        //Extraemos mensaje de alerta y la aceptamos.
        String actual2 = deleteCustomerPOM.AceptarYExtraerMensajeAlerta();

        //Comparamos mensaje de que el cliente se elimino exitosamente.
        assertEquals("Validar que el cliente haya sido eliminado con éxito",
                "Customer deleted Successfully",
                actual1);

        //Comparamos mensaje que nos dice que el cliente ya no existe.
        assertEquals("Validar que el cliente ya no existe",
                "Customer does not exist!!",
                actual2);
    }
}
