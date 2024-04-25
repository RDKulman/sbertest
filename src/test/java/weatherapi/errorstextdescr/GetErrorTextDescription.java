package weatherapi.errorstextdescr;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.mgb.restapi.POJO.Error;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetErrorTextDescription {
    public static final String BASE_URI = "http://api.weatherapi.com/v1";
    private static RequestSpecification requestSpec;
    private static Response response;


    @Given( "Пользователь предоставляет API токен {string} к ресурсу www.weatherapi.com" )
    public void user_has_not_valid_auth_token( String token ) {
        RestAssured.baseURI = BASE_URI;
        Header authHeader = new Header( "key", token );

        requestSpec = RestAssured.given();
        requestSpec.header( authHeader );
    }


    @When( "Выполняется Get запрос на URL {string} для получения погоды города {string}" )
    public void sending_get_request_for_getting_weather( String url, String city ) {
        response = requestSpec
                .param( "q", city )
                .when()
                .get( url )
                .then()
                .extract()
                .response();
    }


    @Then( "Полученный текст ошибки сравнивается с ожидаемым текстом {string}" )
    public void actual_error_text_compare_with_expected( String errorDescription ) {
        Error error = response.jsonPath().getObject( "error", Error.class );
        assertEquals( errorDescription, error.getMessage() );
    }
}
