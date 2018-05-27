package yokv.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import yokv.handle.BizHandle;

@Configuration
public class Routes {

  @Autowired
  private Environment environment;
  @Autowired
  private BizHandle bizHandle;

  @Bean
  public RouterFunction<ServerResponse> monoRouterFunction() {
    return route(GET("/start"), bizHandle::start)
        .andRoute(GET("/method1"), bizHandle::method1)
        .andRoute(GET("/method2"), bizHandle::method2)
        .andRoute(GET("/method3"), bizHandle::method3);
  }

}