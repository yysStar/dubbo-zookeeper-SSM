package servlet;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.http.HttpServlet;

public class Log4jServlet extends HttpServlet {

    public void init() {
        String prefix = getServletContext().getRealPath("/");
        String file = getInitParameter("log4jConfigLocation");
        if (file != null) {
            PropertyConfigurator.configure(prefix + file);
        }
    }
}
