import dao.HeroDAO;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends javax.servlet.http.HttpServlet {
    private  String message;
    HeroDAO dao=new HeroDAO();
    public  void  init() throws ServletException{

        message="Hello,First Servlet!";
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        int ss= dao.GetTotal();
        PrintWriter out =response.getWriter();
        out.write("<h1>"+message+"</h1>");
    }
}
