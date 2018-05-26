package yokv.handle;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * CREATE BY Yo ON 2018/5/26 23:36
 */
@Component
public class BizHandle {

  @Autowired
  private ReactiveRedisTemplate<Object, Object> reactiveRedisTemplate;

  public Mono<ServerResponse> method1(ServerRequest request) {
    return ServerResponse.ok().contentType(APPLICATION_JSON)
        .body(reactiveRedisTemplate.opsForValue().get("key"), Object.class);
  }

}
