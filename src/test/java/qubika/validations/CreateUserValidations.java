package qubika.validations;
import io.restassured.response.Response;
import qubika.utils.UserData;

import java.util.List;
public class CreateUserValidations {

    public static void validateUserCreatedSuccessfully(Response response) {
        int statusCode = response.statusCode();
        String actualEmail = response.jsonPath().getString("email");
        List<String> roles = response.jsonPath().getList("roles");

        assert statusCode == 201 : "Expected status 201, but got: " + statusCode;
        assert actualEmail.equals(UserData.email) : "Expected email: " + UserData.email + ", but got: " + actualEmail;
        assert roles.contains("ROLE_ADMIN") : "Expected ROLE_ADMIN in roles, but got: " + roles;

        System.out.println("✅ Usuario creado correctamente:");
        System.out.println("Email: " + actualEmail);
        System.out.println("Roles: " + roles);
        System.out.println("Status: " + statusCode);
    }
}
