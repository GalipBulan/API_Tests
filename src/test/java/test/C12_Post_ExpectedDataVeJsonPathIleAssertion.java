package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */

    @Test
    public void post01(){

        // 1 - URL hazirla ve body hazirla
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject innerBody = new JSONObject();

        innerBody.put("checkin", "2021-06-01");
        innerBody.put("checkout", "2021-06-10");

        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname" , "Ali");
        reqBody.put("lastname" , "Bak");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" ,innerBody);
        reqBody.put("additionalneeds" , "wi-fi");

        // 2 - Expected Data hazirla

        JSONObject expBody = new JSONObject();

        expBody.put("bookingid", 24);
        expBody.put("booking",reqBody);

        // 3 - Response'i kaydet
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).post(url);

        response.prettyPrint();

        // 4 - Assertion

        // NOT : Oncelikle gereken sey Response'i JSONPath objesine donusturmek

        JsonPath resJsonPath = response.jsonPath();
    }


}
