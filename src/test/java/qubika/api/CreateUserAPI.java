package qubika.api;

import io.restassured.response.Response;
import qubika.api.dto.CreateUserRequest;
import qubika.utils.UserData;

import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUserAPI {

    private static final String BASE_API_URL = "https://api.club-administration.qa.qubika.com";

    public static Response createUser() {
        UserData.email = "qubika_Piero_Meza_Test" + UUID.randomUUID() + "@mail.com";
        UserData.password = "TestPassword123!";

        CreateUserRequest request = new CreateUserRequest(
                UserData.email,
                UserData.password,
                List.of("ROLE_ADMIN")
        );

        Response response = given()
                .baseUri(BASE_API_URL)
                .header("Content-Type", "application/json")
                .body(request)
                .post("/api/auth/register");

        UserData.email = request.getEmail();
        UserData.password = request.getPassword();

        return response;
    }
}

