import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Report extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Excel ex= new Excel();
        ArrayList<Map<String,Integer>>rep=ex.valuesInteraction();
        Map<String,Integer>val=rep.get(0);
        Map<String,Integer>inter=rep.get(1);
        req.setAttribute("val",val);
        req.setAttribute("inter",inter);
        req.getRequestDispatcher("result.jsp").forward(req,resp);

    }
}
