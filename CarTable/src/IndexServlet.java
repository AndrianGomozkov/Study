import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.Car;
import com.CarDB;
 
 
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        ArrayList<Car> cars = CarDB.select();
        request.setAttribute("car", cars);
          
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}