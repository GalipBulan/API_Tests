package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {

    /* Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":1
    }


     */

    @Test
    public void JSonObje01 (){
        JSONObject ilkJsonObje = new JSONObject();

        ilkJsonObje.put("title","Ahmet");
        ilkJsonObje.put("body","Merhaba");
        ilkJsonObje.put("userId",1);

        System.out.println(ilkJsonObje);
        System.out.println(ilkJsonObje.toString()); // toString yazmasak da ayni seyi dondurur.

    }
    @Test
    public void JSonObje02 (){

        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */
        // Icice innerJsonObje oluturma

        JSONObject innerJsonObje = new JSONObject();

        innerJsonObje.put("checkin","2018-01-01");  // Ilk olarak innerJsonObje ilustururuz.
        innerJsonObje.put("checkout","2019-01-01");

        JSONObject body = new JSONObject();

        body.put("firstname","Jim");
        body.put("additionalneeds","Breakfast");
        body.put("bookingdates",innerJsonObje); // DAha sonra bu innerJsonObje yi istedigimiz Key degerine Value olarak atariz.
        body.put("totalprice",111);
        body.put("depositpaid",true);
        body.put("lastname","Brown");

        System.out.println(body);
        System.out.println(body.toString());



    }


}
