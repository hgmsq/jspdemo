import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(name) && "123456".equals(password)) {
            request.getSession().setAttribute("userName", name);
            response.sendRedirect("listHero");
        } else {
            response.sendRedirect("login.html");
        }

    }
}
