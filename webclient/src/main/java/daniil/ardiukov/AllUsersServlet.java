package daniil.ardiukov;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/AllUsers")
public class AllUsersServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var users = userService.getUsers().get();

        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.println("<html><body>");

        for (var user : users) {
            writer.println("<h3> Пользователь id" + user.getId() + ": </h3>");
            writer.println("<p style='color:Tomato'> " + user.getName() + "</p>");
        }


        writer.println("</body></html>");
        writer.close();

    }
}
