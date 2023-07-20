import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class RestAssuredTest {
    @Test
    public void getBookingsID(){
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void createBooking(){

        CreateBooking booking = new CreateBooking().builder()
                .firstname("Tom")
                .lastname("Cooking")
                .totalprice(703)
                .depositpaid(true)
                .dates(new BookingDates("2023-01-04","2024-12-01"))
                .additionalneeds("Lunch")
                .build();

        Response response = RestAssured.given()
                .header("Accept","application/json")
                .body(booking)
                .post("/create");
        response.prettyPrint();

        response.as(ResponceBooking.class);

    }

    @Test
    public void updateBooking(){

        CreateBooking booking = new CreateBooking().builder()
                .totalprice(37)
                .build();

        Response response = RestAssured.given()
                .header("Accept","application/json")
                .body(booking)
                .patch("/create");
        response.prettyPrint();

        response.as(ResponceBooking.class);

    }

    @Test
    public void updateName(){

        CreateBooking booking = new CreateBooking().builder()
                .firstname("Tom")
                .lastname("Cooking")
                .totalprice(703)
                .depositpaid(true)
                .dates(new BookingDates("2023-01-04","2024-12-01"))
                .additionalneeds("Lunch")
                .build();

        Response response = RestAssured.given()
                .header("Accept","application/json")
                .body(booking)
                .put("/create");
        response.prettyPrint();

        response.as(ResponceBooking.class);

    }

    @Test
    public void deleteBooking(){

        CreateBooking booking = new CreateBooking().builder()
                .build();

        Response response = RestAssured.given()
                .header("Accept","application/json")
                .body(booking)
                .patch("/create");
        response.prettyPrint();

        response.as(ResponceBooking.class);

    }


}
