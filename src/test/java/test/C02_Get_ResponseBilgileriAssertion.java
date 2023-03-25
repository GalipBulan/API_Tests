package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ResponseBilgileriAssertion {

    /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        oldugunu test edin.
     */

    @Test
    public void get01(){

        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla.

        String url = "https://restful-booker.herokuapp.com/booking/620";

        // 2 - Eger soruda istenirse Expected Data hazirla.

        // 3 - Bize donen Response'i Actual Data olarak kaydet.

        Response response= given().when().get(url);

        response.prettyPrint();

        // Istersek response ile gelen degerleri yazdirabiliriz.

        System.out.println(response.getHeader("Server"));
        System.out.println(response.getContentType());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());

        // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion.
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","Cowboy").
                statusLine("HTTP/1.1 200 OK");

    }
}
