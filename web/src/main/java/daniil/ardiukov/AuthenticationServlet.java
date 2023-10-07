package daniil.ardiukov;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth")
public class AuthenticationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDto usedData = UserDto.builder()
                .login(req.getParameter("login"))
                .password(req.getParameter("pwd"))
                .build();

        if (userService.checkAuthentication(usedData)) {
            resp.sendRedirect("menu.jsp");
        } else {
            req.setAttribute("after", AfterDataMap.of(usedData));
            req.setAttribute("errors", usedData.getErrors());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }
}
