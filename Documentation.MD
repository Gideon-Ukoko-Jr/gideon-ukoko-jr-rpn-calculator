How To Run Use The RPN Calculator:

1. You can access it on this link : https://gideon-ukoko-jr-rpn-calculator-production.up.railway.app/calculate
2. Alternatively, you can import the codebase and run the GideonUkokoJrRpnCalculatorApplication.java class located in the directory 'src/main/java/com/gideon/jrrpncalculator/GideonUkokoJrRpnCalculatorApplication.java' and open localhost:8080 in your web browser.
3. Once the calculator web page is open, input your Desired RPN expression into the text box and click on the Calculate button.

Key Classes/Files in the Source Code:
1. GideonUkokoJrRpnCalculatorApplication.java -> 'src/main/java/com/gideon/jrrpncalculator/GideonUkokoJrRpnCalculatorApplication.java' OR https://github.com/Gideon-Ukoko-Jr/gideon-ukoko-jr-rpn-calculator/blob/master/src/main/java/com/gideon/jrrpncalculator/GideonUkokoJrRpnCalculatorApplication.java
2. CalculatorController.java -> 'src/main/java/com/gideon/jrrpncalculator/controller/CalculatorController.java' OR https://github.com/Gideon-Ukoko-Jr/gideon-ukoko-jr-rpn-calculator/blob/master/src/main/java/com/gideon/jrrpncalculator/controller/CalculatorController.java
3. CalculatorService.java -> 'src/main/java/com/gideon/jrrpncalculator/service/CalculatorService.java' OR https://github.com/Gideon-Ukoko-Jr/gideon-ukoko-jr-rpn-calculator/blob/master/src/main/java/com/gideon/jrrpncalculator/service/CalculatorService.java
4. calculator.html -> 'src/main/resources/templates/calculator.html' OR https://github.com/Gideon-Ukoko-Jr/gideon-ukoko-jr-rpn-calculator/blob/master/src/main/resources/templates/calculator.html



Please find the Unit Tests in the CalculatorServiceTest.java class in the project directory 'src/test/java/com/gideon/jrrpncalculator/CalculatorServiceTest.java' or Github : https://github.com/Gideon-Ukoko-Jr/gideon-ukoko-jr-rpn-calculator/blob/master/src/test/java/com/gideon/jrrpncalculator/CalculatorServiceTest.java
Run the class to execute all the test cases.



Architecture:
For this project, the architecture can be described as a layered architecture pattern with the goal of implementing separation of concerns and modularity

1. Controller Class:
- The 'CalculatorController.java' class acts as the entry point for handling HTTP requests and serves as the connector between the presentation layer and the service layer.
- It receives the user input from the Thymeleaf form, delegates the calculation request to the 'CalculatorService.java' class, and prepares the response model to be rendered in the Thymeleaf template.

2. Service Class:
- The 'CalculatorService.java' class represents the service layer in the architecture.
- It encapsulates the business logic of evaluating the Reverse Polish Notation (RPN) expression and performing the required calculations.
- It also handles validation, parsing, and evaluation of the RPN expression using a stack-based approach.
- It also includes the implementation of Newton's method for square root approximation.
- The service class communicates with the controller class to retrieve user input and returns the result to the controller class.

3. Thymeleaf Templates:
- The Thymeleaf templates represent the presentation layer of the architecture.
- They define the user interface and utilize Thymeleaf expressions to bind dynamic data to the HTML views.
- The templates receive user input and display the calculation result or error messages returned by the controller.

The chosen architecture promotes separation of concerns by separating the presentation logic (Thymeleaf templates and controller class) from the business logic (service class). 
This separation allows for easier maintenance, scalability, and testability of the application.