# garantizarTallerSelenium


Ejercicio 1 del taller de Selenium para la clase garantizar.



En carpeta Pantallazos de encuentran pantallazos de los resultados de las pruebas.



---------------------------------------------------------------------------------------------------
-Source Package=
  
	-co.com.Taller.Modelo.Cliente.java = Objeto de la clase Cliente para facilitar el ingreso y 						extracción de datos.
  
  

	-co.com.Taller.POM=
		-Login.java = POM que representa la pagina de login con sus metodos correspondientes.
    		-Home.java = POM que representa la pagina de home con sus metodos correspondientes.
    				-NewCustomer.java = POM que representa la pagina de newCustomer con sus metodos 					correspondientes.
    
		-CustomerReg.java = POM que representa la pagina de CustomerReg con sus metodos 					correspondientes.
    
		-DeleteCUstomer.java = POM que representa la pagina de DeleteCustomer con sus metodos 					correspondientes.
   


-Test Package=
  
	-con.com.Taller.Selenium=
    
		-LoginTest.java= Clase con las pruebas de inicio de sesion.
    
		-Customer.java= Clase con las pruebas de creacion de cliente, eliminación y verificacion 				de datos y formulario.
    
		-SeleniumSuite.java= Suite para correr las dos clases anteriores automaticamente.
  
---------------------------------------------------------------------------------------------------

						Casos de Prueba
LoginTest.java=

     Caso de Prueba 1: 
     Caso de prueba en donde se va a la pagina del login, se
     ingresan el nombre de usuario y contraseña en los textBox
     coorrespondientes y se da clic en el boton submit. Se va luego a la
     pagina home donde aparece mensaje con el usuario que acabo de ingresar
     sesion, se toma dicho mensaje y se verifica en un assertEquals que el
     mensaje corresponde al usuario que se ingreso.

     - Objeto actual: "Manger Id : mngr162001".


Customer.java=

     Caso de Prueba 1: 
     Comprobar si existe mensaje oculto en el html de la
     pagina new customer que nos indique si el campo "customer name" debe ser
     llenado, por tanto significando que el campo es obligatorio.     
     - Objeto esperado: "Customer name must not be blank"


     Caso de Prueba 2: 
     Comprobar si al intentar ingresar un cliente con todos
     sus datos excepto el nombre (customer name) si salta ventana advirtiendo
     que todos los campos deben ser llenados, indicando entonces que el campo
     es obligatorio.
     
     - Objeto esperado: "please fill all fields"


     Caso de Prueba 3: 
     Se crea un nuevo usuario y se confirma que ha sido
     exitosamente creado, esto se hara de 2 formas: Mediante el mensaje de
     éxito en la tabla con los datos del nuevo cliente y mediante la
     extracción de todos los datos de la tabla y comparandose con los datos
     que se ingresaron cuando se creo.

     - Objeto esperado1: "Customer Registered Successfully!!!"
     - Objeto esperado2: Cliente con los datos que se ingresaron.


     Caso de Prueba 4: 
     Con el ID del cliente creado, vamos a la pagina "delete
     customer" en donde lo ingresamos y le damos Submit. Se estrae el mensaje
     que confirma que el cliente fue borrado exitosamente. Luego nos llevara a
     la pagina home, donde volveremos a la pagina "delete customer" e
     ingresaremos nuevamente el ID del cliente para intentar volverlo a
     borrar, extraeremos mensaje donde nos indique que el cliente no existe,
     por tanto el cliente fue eliminado de la BD.

     - Objeto esperado1: "Customer deleted Successfully".
     - Objeto esperado2: "Customer does not exist!!".
     