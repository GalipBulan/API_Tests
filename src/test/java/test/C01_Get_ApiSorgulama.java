package test;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {

    /*
        https://restful-booker.herokuapp.com/booking/256884 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
    */
    @Test public void get01(){

        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla.

        String url = "https://restful-booker.herokuapp.com/booking/4876";

        // 2 - Eger soruda bize verilmisse Expected Data hazirla.

        // 3 - Bize donen Response'i Actual Data olarak kaydet.

        //bir GET request gonderdigimizde donen Response’un,
        Response response = given().when().get(url); // Yaptigimiz sorgu gerceklesir ve response olarak kayit edilir
        response.prettyPrint();// Responseu yazdirir:Sadece testleri gormek isterken bu kod yazilir. Ran ederken kaldirmak gerekir cunku bilgisayari kasar
        //status code’unun 200,
        System.out.println("Status Code: " + response.getStatusCode()); // Response status kodunu yazdirir
        //content type’inin application/json; charset=utf-8,
        System.out.println("Content Type: " + response.getContentType());
        //Server isimli Header’in degerinin Cowboy
        System.out.println("Server Header: " + response.getHeader("Server"));// Bircok header degeri var burada Server istendigi icin tirnak icine onu yazdik
        // status Line’in HTTP/1.1 200 OK
        System.out.println("Status Line: " + response.getStatusLine());
        // response suresinin 5 sn’den kisa oldugunu
        System.out.println("Response suresi: " + response.getTime());

        // 4 - Expected Data ile Actual datanin karsilastirmasi - Assertion.
    }
}
