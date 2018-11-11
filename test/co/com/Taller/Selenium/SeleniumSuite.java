package co.com.Taller.Selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite para correr todas los casos de prueba automaticamente.
 *
 * @author Santiago Medina Pelaez
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({co.com.Taller.Selenium.LoginTest.class,
    co.com.Taller.Selenium.customerTest.class})
public class SeleniumSuite {

}
