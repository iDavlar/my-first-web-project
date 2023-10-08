package daniil.ardiukov;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.GregorianCalendar;

@WebServlet("/account")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("UserId");
        if (userId == null) {
//            resp.sendRedirect("index.jsp");
            req.getRequestDispatcher("index.jsp").include(req, resp);
            return;
        }
        var usedData = userService.getUser(userId).get();

        req.setAttribute("after", AfterDataMap.of(usedData));
        req.setAttribute("errors", usedData.getErrors());
        req.getRequestDispatcher("account_form.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId = (Integer) req.getSession().getAttribute("UserId");
        if (userId == null) {
            resp.sendRedirect("index.jsp");
            return;
        }

        UserDto userData = UserDto.builder()
                .id(userId)
                .name(req.getParameter("name"))
                .age(req.getParameter("age"))
                .email(req.getParameter("email"))
                .login(req.getParameter("login"))
                .password(req.getParameter("pwd"))
                .build();

        String msg = "";
        if (userService.changeUser(userData)) {
            msg ="Успешно!";
        } else {
            msg ="Ошибка!!";
        }
        userData.getErrors().put("Status", msg);

        req.setAttribute("after", AfterDataMap.of(userData));
        req.setAttribute("errors", userData.getErrors());
        req.getRequestDispatcher("account_form.jsp").forward(req, resp);
    }
}
