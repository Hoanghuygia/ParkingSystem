package utils;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import java.util.Enumeration;

@WebListener
public class SessionTimeoutListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // This method is called when the server starts up
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // This method is called when the server is shutting down
        invalidateAllSessions(servletContextEvent);
    }

    private void invalidateAllSessions(ServletContextEvent servletContextEvent) {
        Enumeration<String> sessionAttributeNames = servletContextEvent.getServletContext().getAttributeNames();
        while (sessionAttributeNames.hasMoreElements()) {
            String attributeName = sessionAttributeNames.nextElement();
            if (attributeName.startsWith("org.apache.catalina.SESSION.")) {
                HttpSession session = (HttpSession) servletContextEvent.getServletContext().getAttribute(attributeName);
                session.invalidate();
            }
        }
    }
}
