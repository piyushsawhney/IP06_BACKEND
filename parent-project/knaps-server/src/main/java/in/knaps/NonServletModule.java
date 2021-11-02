package in.knaps;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.GuiceFilter;
import in.knaps.domain.model.client.ClientDbFactory;
import in.knaps.domain.model.db.PostgresConnection;
import in.knaps.domain.model.mf.MfDbFactory;
import in.knaps.domain.model.mf.processing.MfValueCalculator;
import in.knaps.domain.model.mf.processing.MfValueCalculatorImpl;
import in.knaps.infra.client.ClientDbFactoryImpl;
import in.knaps.infra.mf.MfDbFactoryImpl;

public class NonServletModule extends AbstractModule {
    protected void configure() {
        binder().requireExplicitBindings();
        bind(ClientDbFactory.class).to(ClientDbFactoryImpl.class);
        bind(MfValueCalculator.class).to(MfValueCalculatorImpl.class);
        bind(MfDbFactory.class).to(MfDbFactoryImpl.class);
        bind(GuiceFilter.class);
    }

    @Provides
    public PostgresConnection providePostgresConnection() {
        String urlEnv = System.getenv("DB_URL");
        String userEnv = System.getenv("DB_USER");
        String passwordEnv = System.getenv("DB_PASSWORD");
        return new PostgresConnection(urlEnv, userEnv, passwordEnv);
    }
}