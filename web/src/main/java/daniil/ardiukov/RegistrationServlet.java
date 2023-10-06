package daniil.ardiukov;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto usedData = UserDto.builder()
                .name(req.getParameter("name"))
                .age(req.getParameter("age"))
                .email(req.getParameter("email"))
                .login(req.getParameter("login"))
                .password(req.getParameter("pwd"))
                .build();

        if (userService.registerNew(usedData)) {
            resp.sendRedirect("menu.jsp");
        } else {
            req.setAttribute("after", AfterDataMap.of(usedData));
            req.setAttribute("errors", usedData.getErrors());
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }
    }
}
