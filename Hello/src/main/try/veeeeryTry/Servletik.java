package veeeeryTry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Servletik extends HttpServlet {

    private Phonebook phonebook;

    public Servletik() {
        super();
        try {
            this.phonebook = Phonebook.getInstance();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("mypage.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("phonebook", this.phonebook);

        if (!(request.getParameter("parameter").equals(""))) {
            int index;
            String parameter = request.getParameter("parameter");
            char[] str = parameter.toCharArray();
            if (!(str[0] == '+')) {
                index = phonebook.findBySomething("name", parameter);
            }
            else {
                index = phonebook.findBySomething("phone", parameter);
            }
            if(index != -1) {
                Phone findingElement = phonebook.Phones.get(index);
                request.setAttribute("findingElementName", findingElement.name);
                request.setAttribute("findingElementPhone", findingElement.phone);
            }
            else {
                request.setAttribute("findingElementName", "Такой записи");
                request.setAttribute("findingElementPhone", "нет");
            }
        }

        doGet(request, response);
    }
}
