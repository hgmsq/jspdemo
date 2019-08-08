import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

public class HeroListServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = (String) request.getSession().getAttribute("userName");
        if (null == userName) {
            response.sendRedirect("login.html");
            return;
        }


        int pageindex = 1;//第几页
        int pagesize = 2;
        try {
            pageindex = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {
        }

        int next = pageindex + 1;
        int pre = pageindex - 1;

        int total = new HeroDAO().GetTotal();

        int last;
        last = (total + pagesize - 1) / pagesize;
        int currPage = 1;
        currPage = pageindex;
        request.setAttribute("currPage", currPage);



        request.setAttribute("start", pageindex);
        request.setAttribute("next", next);
        request.setAttribute("pre", pre);
        request.setAttribute("last", last);

        int page= (pageindex-1)*pagesize;
        List<Hero> heros = new HeroDAO().list(page, pagesize);
        request.setAttribute("heros", heros);
        request.getRequestDispatcher("listHero.jsp").forward(request, response);
    }
}