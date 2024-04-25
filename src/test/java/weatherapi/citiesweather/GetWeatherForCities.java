package weatherapi.citiesweather;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.mgb.restapi.POJO.CurrentWeather;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetWeatherForCities {
    public static final String TOKEN = "735dd42baa5247ae850121438242104";
    public static final String BASE_URI = "http://api.weatherapi.com/v1";
    public static final String REALTIME_WEATHER = "/current.json";

    private static RequestSpecification requestSpec;
    private static Response response;

    @Given("Пользователь зарегистрирован на www.weatherapi.com и имеет API токен")
    public void user_registered_and_has_auth_token() {
        RestAssured.baseURI = BASE_URI;
        Header authHeader = new Header( "key", TOKEN );

        requestSpec = RestAssured.given();
        requestSpec.header( authHeader );
    }

    @When("Отправляется Get запрос на получение погоды для города {string}")
    public void sending_get_request_for_getting_weather_for_city( String city ) {
        response = requestSpec
                .param( "q", city )
                .when()
                .get( REALTIME_WEATHER )
                .then()
                .assertThat()
                .statusCode( 200 )
                .extract()
                .response();
    }

    @Then("Полученное значение погоды сравнивается с ожидаемым {string}")
    public void actual_temp_compare_with_expected( String expectedTemp ) {
        CurrentWeather currentWeather = response.jsonPath().getObject( "current", CurrentWeather.class );
        String actualTemp = String.valueOf( currentWeather.getTemp_c() );
        //          можно просто так колбасой обойтись
//        String actualTemp = String.valueOf( response.jsonPath().getMap( "current" ).get( "temp_c" ) );
        assertEquals( expectedTemp, actualTemp );
    }

}
