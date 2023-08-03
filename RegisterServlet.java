import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Generate a random patient reference number
        String referenceNumber = generateReferenceNumber();

        // Get the patient's email (You can modify this to get the email from the form)
        String patientEmail = request.getParameter("email");

        // Send an email to the patient with the reference number
        sendEmail(patientEmail, referenceNumber);

        // Display a success message
        response.setContentType("text/html");
        response.getWriter().println("Patient registered successfully. Check your email for the reference number.");
    }

    private String generateReferenceNumber() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randomLetters = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            char randomLetter = letters.charAt(random.nextInt(letters.length()));
            randomLetters.append(randomLetter);
        }

        long timestamp = System.currentTimeMillis() / 1000;
        return randomLetters.toString() + "-" + timestamp;
    }

    private void sendEmail(String email, String referenceNumber) {
        // Replace this with your email sending logic.
        // For simplicity, we'll just log the email and reference number to the console.
        System.out.println("Sending an email to " + email + " with the reference number: " + referenceNumber);
    }
}
