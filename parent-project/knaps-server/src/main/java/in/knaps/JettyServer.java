package in.knaps;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class JettyServer {

    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(new NonServletModule(), new ApplicationServletModule());
        FilterHolder guiceFilter = new FilterHolder(injector.getInstance(GuiceFilter.class));
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath("/");
        handler.addFilter(guiceFilter, "/*", EnumSet.allOf(DispatcherType.class));
        server.setHandler(handler);
        server.start();
    }

}