package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C4_Put_ResponseBilgileriAssertion {

    /* https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir PUT request gonderdigimizde
    {
     "title":"Ahmet",
     "body":"Merhaba",
     "userId"10,
     "id":70
     }

    donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin cloudflare,
    ve status Line’in HTTP/1.1 200 OK


     */

    @Test
    public void put01(){

        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla.

    String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody = new JSONObject();  //  ilk olarak bady i oluturduk.

        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId", 10);
        reqBody.put("id",70);

        System.out.println(reqBody);

        // 2 - Eger soruda bize verilmisse Expected Data hazirla.

        // 3 - Bize donen Response'i Actual Data olarak kaydet.

        Response response = given().
                            contentType(ContentType.JSON).  // Gönderecegimiz bady i precontion olarak formati contentType belitmek gerekir.
                            when().
                            body(reqBody.toString()).put(url); // Hazirladigimiz bady  body method u ile toStringe cevirip
        // gonderiyoruz ve Regust put ile calistigi icin put ile url yi gonderiyoruz

        // Biz burada java kodlari kullaniyoruz Java direkt olarak Json objeyi tanimaz bu sebeple java tanisin diye o yuzden biz bu
        // objeleri Json dipendisies in yardimizla yapabiliyoruz. Bu hazirligi javaca hazirlayip gondersin diye toString yontemini kullaniyoruz.


        response.prettyPrint();  // Burada yazdiriyoruz.


        response.then().
                assertThat(). // Donen degerleri assertThat() methodu ile degerleri elle girerek dogru olup olmadigini test ediyoruz.
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server" , "cloudflare").
                statusLine("HTTP/1.1 200 OK");

    }

}
