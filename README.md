# Selenium Automation Exercise Project


This project represents a Selenium UI automation testing framework created for the
**Automation Exercise** demo website.

The goal of this project is to demonstrate practical knowledge of Selenium automation,
TestNG test organization and the Page Object Model design pattern.

---

## Application Under Test

**Automation Exercise** is a demo e-commerce website used for practicing test automation.
The website includes features such as:
- User registration and login
- Product listing and product details
- Shopping cart functionality
- Checkout and payment flow
- Product reviews

---

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI (for Excel test data)
- Git / GitHub

---

## Project Structure

The project follows the **Page Object Model (POM)** approach to separate test logic from
page interaction logic.

````
src
└── test
└── java
├── Base
│   ├── BaseTest.java
│   └── ExcelReader.java
├── Pages
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── SignupPage.java
│   ├── ProductsPage.java
│   ├── ProductDetailsPage.java
│   ├── CartPage.java
│   ├── CheckoutPage.java
│   └── PaymentPage.java
└── Tests
├── LoginTest.java
├── SignUpTest.java
├── CartTest.java
├── ConfirmAndPayTest.java
└── ReviewProductTest.java

````

---

## Test Scenarios Covered

- User login with valid and invalid credentials
- User registration
- Adding products to the cart
- Checkout and payment process
- Submitting a product review

---

## Data-Driven Testing

Test data is stored in an external Excel file:
- `WebTablesData.xlsx`

The file is read using **Apache POI**, which allows test data to be separated from
test logic and easily modified without changing the test code.

---

## How to Run the Project

### Prerequisites
- Java installed
- Maven installed
- Chrome browser
- IntelliJ IDEA (recommended)

### Running tests from IntelliJ
1. Open the project in IntelliJ IDEA
2. Load Maven dependencies
3. Navigate to the `Tests` package
4. Run individual test classes or the entire test suite using TestNG

---

## Author

Vladan Branković  
Junior QA / Automation Tester
