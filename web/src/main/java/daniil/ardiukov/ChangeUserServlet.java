package daniil.ardiukov;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ChangeUser")
public class ChangeUserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userId = req.getParameter("id");
        var newUserName = req.getParameter("name");

        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.println("<html><body>");

        if (userService.updateUser(Integer.parseInt(userId), newUserName)) {
            writer.println("<h1> Имя пользователя изменено: </h1>");
            writer.println("<p style='color:Tomato'> " + newUserName + "</p>");
        } else {
            writer.println("<h1> Ошибка изменения имени: </h1>");
        }


        writer.println("</body></html>");
        writer.close();

    }
}
