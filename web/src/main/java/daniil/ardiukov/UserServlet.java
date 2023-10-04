package daniil.ardiukov;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userId = req.getParameter("id");
        var user = userService.getUser(Integer.valueOf(userId));

        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.println("<html><body>");

        writer.println("<h1> Пользователь: </h1>");
        writer.println("<p style='color:Tomato'> " + user.get().getName() + "</p>");

        writer.println("</body></html>");
        writer.close();

    }
}
