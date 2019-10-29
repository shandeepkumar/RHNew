package gov.bnm.view.rh.servlet;

import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import oracle.jbo.common.PropertyMetadata;

public class InitializationListener implements ServletContextListener {

    private ServletContext context = null;

    public void contextInitialized(ServletContextEvent event) {
        context = event.getServletContext();
        AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    // Set the SQL Builder to the correct value for your database, SQL Server in this example.
                    System.setProperty(PropertyMetadata.PN_SQLBUILDERIMPL.getName(),
                                       "SQLServer");
                    return null;
                }
            });
    }

    public void contextDestroyed(ServletContextEvent event) {
        context = event.getServletContext();
    }
}
