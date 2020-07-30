import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Car;
import com.CarDB;
 
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            String model = request.getParameter("model");
            String color = request.getParameter("color");
            String complect = request.getParameter("complect");
            Car car = new Car(model, color, complect);
            CarDB.insert(car);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response); 
        }
    }
}