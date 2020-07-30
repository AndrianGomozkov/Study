import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.Car;
import com.CarDB;
 
 
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Car car = CarDB.selectOne(id);
            if(car!=null) {
                request.setAttribute("car", car);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            int idcar = Integer.parseInt(request.getParameter("idcar"));
            String model = request.getParameter("model");
            String color = request.getParameter("color");
            String complect = request.getParameter("complect");
            Car car = new Car(idcar, model, color, complect);
            CarDB.update(car);
            response.sendRedirect(request.getContextPath() + "/index");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
        }
    }
}