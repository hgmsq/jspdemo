import bean.Hero;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroAddServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int hp  = Integer.parseInt(request.getParameter("hp"));
        Hero hero = new Hero();
        hero.setName(name);
        hero.setHp(hp);
        new HeroDAO().AddHero(hero);
        response.sendRedirect("listHero");

    }
}
