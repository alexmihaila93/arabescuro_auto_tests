package data;

import org.testng.annotations.DataProvider;

public class LoginDP {

    @DataProvider
    public Object[][] loginDataProvider() {
        return new Object[][]{
//          username, password, browser
                {"alex@alex.ro", "Scoala1234$", "edge"},
                {"alex@alex.ro", "Scoala1234$", "chrome"},
                {"alex@alex.ro", "Scoala1234$", "edge"},
        };
    }
}
