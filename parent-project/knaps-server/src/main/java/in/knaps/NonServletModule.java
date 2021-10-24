package in.knaps;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.GuiceFilter;
import in.knaps.domain.model.client.ClientDbFactory;
import in.knaps.domain.model.db.PostgresConnection;
import in.knaps.infra.client.ClientDbFactoryImpl;

public class NonServletModule extends AbstractModule {
    protected void configure() {
        binder().requireExplicitBindings();
        bind(ClientDbFactory.class).to(ClientDbFactoryImpl.class);
        bind(GuiceFilter.class);
    }

    @Provides
    public PostgresConnection providePostgresConnection() {
        String url = "";
        String user = "";
        String password = "";

        return new PostgresConnection(url, user, password);
    }
}