package in.knaps;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import in.knaps.client.v1.ClientApiV1;
import in.knaps.mf.v1.MfApiV1;

public class ApplicationServletModule extends ServletModule {
    @Override
    protected void configureServlets() {

        bind(MfApiV1.class).to(MfApiV1Impl.class);
        bind(ClientApiV1.class).to(ClientApiV1Impl.class);
        bind(KnapsApplication.class).to(KnapsApplicationImpl.class);


        bind(GuiceContainer.class);

        bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);

        serve("/*").with(GuiceContainer.class);
    }
}