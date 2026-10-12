package SetA;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorController extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            double n1 = Double.parseDouble(
                    request.getParameter("num1"));
            double n2 = Double.parseDouble(
                    request.getParameter("num2"));
            String operation = request.getParameter("operation");

            CalculatorModel model = new CalculatorModel();
            model.setNumbers(n1, n2);

            switch (operation) {
                case "add":
                    model.add();
                    break;
                case "subtract":
                    model.subtract();
                    break;
                case "multiply":
                    model.multiply();
                    break;
                case "divide":
                    model.divide();
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid operation");
            }

            request.setAttribute("result", model.getResult());

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Enter valid numbers");
        } catch (ArithmeticException | IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
        }

        request.getRequestDispatcher("/calculator.jsp")
                .forward(request, response);
    }
}
