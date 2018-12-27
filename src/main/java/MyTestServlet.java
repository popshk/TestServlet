import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyTestServlet extends HttpServlet {
    static final String TEMPLATE = "<html>" +
            "<head><title>popshk</title></head>" +
            "<body><h1>%s</h1></body></html>";

    final String[]quest = {"Java",".NET","C++"};

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String name = req.getParameter("name");
        final String lastName = req.getParameter("lastName");
        final String age = req.getParameter("age");
        final String q1 = req.getParameter("question1");
        final String q2 = req.getParameter("question2");
        final String q3 = req.getParameter("question3");
        final String [] allQ={q1,q2,q3};
        if(name.equals("") || lastName.equals("") || (age.equals("0"))||age.equals("")){
            String s ="Invalid Param";
            resp.getWriter().print(String.format(TEMPLATE, s));
        }else {

            String res = "</h1>" + name + " " + lastName + " " + age + " age";
            resp.getWriter().println(String.format(TEMPLATE, res));
            for (int i = 0; i < allQ.length; i++) {
                if (allQ[i].equals("yes"))
                    resp.getWriter().println(String.format(TEMPLATE, quest[i]));
            }
        }
    }
}
