package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_Get_ResponseBodyTesti {

    /* https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request
    yolladigimizdinda donen Response’in 	status code'unun 200,
    ve content type'inin Aplication.JSON,	ve response body'sinde bulunan userId'nin 5,ve response
    body'sinde bulunan title'in "optio dolor molestias sit" oldugunu test edin.
     */

    @Test
    public void get01 (){

        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla.
        // Burasi get methodo oldugu icin body ihtiyaci yok,
        String url ="https://jsonplaceholder.typicode.com/posts/44";

        // 2 - Eger soruda bize verilmisse Expected Data hazirla.

        // 3 - Bize donen Response'i Actual Data olarak kaydet.

        Response response = given().when().get(url); // Herhangi bir precondidation yok o sebeple direkt when methodu ve get cagirip
        // hazirladigimiz url yi gomer. Bunu yapinca talebimiz gider

        // Gormek icin
        response.prettyPrint();

        //- Assertion.

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("userId" , Matchers.equalTo(5)).
                body("title" , Matchers.equalTo("optio dolor molestias sit"));


    }
}
