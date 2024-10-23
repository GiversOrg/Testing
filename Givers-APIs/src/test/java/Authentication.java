import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

class AuthenticationTest {
    ExtentReports extent;   // For managing the report
    ExtentTest test;        // For logging details of each test

    @BeforeSuite
    public void setupReport() {
        // Initialize ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReports.html");

        // Initialize ExtentReports and attach the Spark reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeMethod
    public void startTest(@org.jetbrains.annotations.NotNull Method method) {
        // Initialize ExtentTest for each test method
        test = extent.createTest(method.getName());
    }

    @Test
    public void RegisterUser() {
        test.info("Starting API Test");
        RestAssured.baseURI = "https://stg.givers-app.com";
        String requestBody = """
                    {
                        "email": "ahassaniengivers4ff1@gmail.com",
                        "firstName": "A",
                        "lastName": "B",    
                        "password": "Givers@123",
                        "confirmPassword": "Givers@123"
                    }
                """;

        Response response = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post("/api/auth/register").
                then().
                assertThat().
                statusCode(201).  // Validate that the status code is 201 (Created)
                        body("email", equalTo("ahassaniengivers4ff1@gmail.com")).
                body("firstName", equalTo("A")).
                body("isEmailVerified", equalTo(false)).
                extract().response();

        test.pass("Test Passed");
    }

    @AfterMethod
    public void endTest() {
        // End the current test
        test = null;  // Reset test after each method
    }

    @AfterSuite
    public void tearDown() {
        // Flush the report to ensure all logs are written
        if (extent != null) {
            extent.flush();
        }
    }
}

