package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*; // Matchers.* yapinca Matchers. clasindan gelen butun yontemleri bir kez inport edip kullanabiliriz.


public class C6_Post_ResponseBodyTesti {

   /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde

        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */

    @Test
    public void post01() {
        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla.

        String url ="https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title", "API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        // System.out.println(reqBody);
        // Yazdirma komutlari hizi yavaslatir bir kere calistirip silmek mantiklidir.
        // Silince konsolda hicbir sey gorulmez

        // 2 - Eger soruda bize verilmisse Expected Data hazirla.


        // 3 - Bize donen Response'i Actual Data olarak kaydet.

        Response response = given().
                            contentType(ContentType.JSON).
                            when().body(reqBody.toString()).post(url);

        // response.prettyPrint();

        //- Assertion.

        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title",equalTo("API"))
                .body("userId",lessThan(100))
                .body("body",containsString("API"));
    }

    @Test
    public void post02() {
        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla.

        String url ="https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        // System.out.println(reqBody); // Yazdirma komutlari hizi yavaslatir bir kere calistirip silmek mantiklidir.
        // Silince konsolda hicbir sey gorulmez

        // 2 - Eger soruda bize verilmisse Expected Data hazirla.


        // 3 - Bize donen Response'i Actual Data olarak kaydet.

        Response response = given().
                contentType(ContentType.JSON).
                when().body(reqBody.toString()).post(url);

        //response.prettyPrint();

        //- Assertion.

        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title", equalTo("API"),
                "userId", lessThan(100),
                "body", Matchers.containsString("API")); // Her seferinde body yazmak zorunde degiliz. Trk bir body ile yapabiliriz.
    }
}
