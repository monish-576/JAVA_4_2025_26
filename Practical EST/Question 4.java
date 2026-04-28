import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("Servlet initialized");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Processing request");
        super.service(request, response); 
    }

    public void destroy() {
        System.out.println("Servlet destroyed");
    }
}
