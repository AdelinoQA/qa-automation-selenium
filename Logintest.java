package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
        // Ruta local al archivo chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\ruta\\a\\chromedriver.exe");

        // Inicializa el navegador
        WebDriver driver = new ChromeDriver();

        // Abre la URL de prueba
        driver.get("https://the-internet.herokuapp.com/login");

        // Maximiza la ventana del navegador
        driver.manage().window().maximize();

        // Encuentra e interactúa con los elementos del formulario
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        // Ingresa credenciales válidas
        usernameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("SuperSecretPassword!");
        loginButton.click();

        // Espera un momento para ver el resultado (solo para demo, no recomendado en producción)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verifica si el login fue exitoso
        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
        if (successMessage.isDisplayed() && successMessage.getText().contains("You logged into a secure area!")) {
            System.out.println("✅ Prueba de login EXITOSA.");
        } else {
            System.out.println("❌ Prueba de login FALLIDA.");
        }

        // Cierra el navegador
        driver.quit();
    }
}
