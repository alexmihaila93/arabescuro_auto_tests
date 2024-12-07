package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement signInButton;

    @FindBy(id = "user")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/div/form/p[3]/button")
    private WebElement pageIdentifier;

    @FindBy(className = "error-message")
    private WebElement errorMessageElement;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public class LoginPage extends BasePage {

        private By cookieConsentLocator = By.xpath("//*[@id=\"CybotCookiebotDialogBody\"]"), 'Allow All') or contains(text(), 'Accept Cookies')]");
        private By usernameLocator = By.id("alex@alex.ro");
        private By passwordLocator = By.id("Scoala1234$");
        private By loginButtonLocator = By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]");

        public void login(String username, String password) {
            // First, handle cookie consent
            handleCookieConsent(cookieConsentLocator);

            // Then proceed with login
            WebElement usernameElement = waitUntilElementVisible(usernameLocator);
            usernameElement.sendKeys(username);

            WebElement passwordElement = waitUntilElementVisible(passwordLocator);
            passwordElement.sendKeys(password);

            WebElement loginButton = waitUntilElementClickable(loginButtonLocator);
            loginButton.click();
        }
    }



    public void login(String username, String password) {
        System.out.println("Waiting for login page to load");
        waitUntilElementVisible(pageIdentifier);
        this.enterUsername(username);
        this.enterPassword(password);
        this.submit();
    }

    public void enterUsername(String username) {
        waitUntilElementVisible(emailInput);
        System.out.println("Enter email:" + username);
        emailInput.clear();
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(passwordInput);
        System.out.println("Enter password:" + password);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        System.out.println("Click sign in button");
        signInButton.click();
    }

    public boolean verifyLoginSuccessful(String username) {
        String xpath = "//h1[contains(text(),'Welcome to web-stubs, " + username + "!')]";

        WebElement welcomeMessage = waitUntilElementVisible(By.xpath(xpath));
        System.out.println("Welcome message displayed: " + welcomeMessage.getText());
        return welcomeMessage.isDisplayed();
    }

    public boolean verifyLoginFailed(String errorMessage) {
        waitUntilElementVisible(errorMessageElement);
        System.out.println("Error message displayed: " + errorMessageElement.getText());
        return errorMessageElement.getText().equalsIgnoreCase(errorMessage);
    }

}
