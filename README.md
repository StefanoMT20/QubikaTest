# Qubika Sports Club Management System - E2E Automation Test Suite

This repository contains a complete end-to-end automated test suite for the Qubika Sports Club Management System.
The tests validate a real user flow combining API-level and UI-level validations, using **RestAssured**, **Selenium WebDriver**, and **TestNG**.

---

## Project Structure
The codebase follows a **screenplay-style architecture**, separating concerns into actions, validations, API operations, and test definitions:
```plaintext
src/
└── test/
    └── java/
        ├── qubika.actions/       # UI interactions (e.g. login, navigation, creation)
        ├── qubika.api/           # API calls (e.g. create user with RestAssured)
        ├── qubika.validations/   # UI and API validations/assertions
        └── qubika.ui/            # TestNG test classes
```
### Key Benefits of this structure:
- **Scalability**: Easy to extend with new modules.
- **Readability**: Each layer has a clear responsibility.
- **Reusability**: Actions and validations can be reused across multiple tests.

##  Features
- **Full E2E test**: combines API (user creation via `RestAssured`) with UI (login and category creation via Selenium).
-  **TestNG Groups**: allows running specific tests (e.g., `end-to-end`) using Maven CLI.
- **WebDriver management**: driver instance is handled within each test class setup method.
- **Explicit waits**: avoids flaky tests by waiting for elements with `WebDriverWait`.
- **Timestamped data**: ensures category names are unique during every run.
- **Reusable components**: actions and validations are modular and can be reused across multiple tests.
- **No reliance on hardcoded test data**: user credentials and category names are generated dynamically.
- You can also run individual test classes separately (e.g., `LoginTest`, `CategoryTest`) to focus on specific modules without executing the full E2E flow.

## Test Coverage

- **User creation via API**  
  - Validates HTTP 201 status code and response body structure.
  - Stores email and password dynamically for further use.

- **Login page UI rendering**  
  - Validates presence of email & password fields, login button, and page title.

- **User login with API-created credentials**  
  - Validates successful redirection to dashboard or homepage.
  - Confirms that protected pages are now accessible.

- **Navigation to Category page post-login**  
  - Validates that the Category page loads correctly and is accessible.

- **Category creation and visibility validation**  
  - Creates a new category with a unique name.
  - Validates the category appears immediately in the category list.

- **Sub-category creation and hierarchy validation**  
  - Creates a sub-category under an existing category.
  - Validates its display as a nested element in the UI list.

## Enhancements & Next Steps

- Integrate with GitHub Actions for CI execution
- Add cross-browser testing support (via WebDriverManager or Selenium Grid)
- Include Allure reports for better result visualization
- Extend coverage to roles & permissions
- Add cleanup logic to remove created test data (users/categories)

## How to Run the Tests

Make sure you have the following installed:

- JDK 21
- Maven 3.8+
- Google Chrome
- (Optional) IntelliJ IDEA or any Java IDE

### 1. Run all tests

```bash
mvn clean test
```
### 2. Run End to End test
```bash
mvn clean test -Dgroups="end-to-end"
