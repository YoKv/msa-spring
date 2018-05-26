package yokv.config;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import yokv.handle.BizHandle;

@Configuration
public class Routes {

  @Autowired
  private BizHandle bizHandle;

  @Bean
  public RouterFunction<ServerResponse> monoRouterFunction() {
    return route(GET("/start").and(accept(APPLICATION_JSON)), bizHandle::method1);
  }
}

