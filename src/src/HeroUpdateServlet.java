import bean.Hero;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroUpdateServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        float hp  = Float.parseFloat(request.getParameter("hp"));
        int id  = Integer.parseInt(request.getParameter("id"));
        Hero hero = new Hero();
        hero.setName(name);
        hero.setHp(hp);
        hero.setId(id);
        new HeroDAO().UpdateHero(hero);

        response.sendRedirect("listHero");

    }
}