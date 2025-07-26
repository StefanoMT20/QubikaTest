package qubika.api;

import io.restassured.response.Response;
import qubika.api.dto.CreateUserRequest;
import qubika.utils.UserData;

import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUserAPI {

    private static final String BASE_API_URL = "https://api.club-administration.qa.qubika.com";

    public static void createUser() {
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

        int statusCode = response.statusCode();
        String actualEmail = response.jsonPath().getString("email");
        List<String> roles = response.jsonPath().getList("roles");

        assert statusCode == 201 : "Expected status 201, but got: " + statusCode;
        assert actualEmail.equals(UserData.email) : "Expected email: " + UserData.email + ", but got: " + actualEmail;
        assert roles.contains("ROLE_ADMIN") : "Expected ROLE_ADMIN in roles, but got: " + roles;

        System.out.println("Usuario creado correctamente:");
        System.out.println("Email: " + actualEmail);
        System.out.println("Roles: " + roles);
        System.out.println("Status: " + statusCode);
    }
}
