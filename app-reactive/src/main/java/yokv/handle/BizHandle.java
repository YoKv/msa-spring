package yokv.handle;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import yokv.service.BizService;

/**
 * CREATE BY Yo ON 2018/5/26 23:36
 */
@Component
public class BizHandle {

  private final static Logger LOGGER = LoggerFactory.getLogger(BizHandle.class);


  private ReactiveRedisTemplate<Object, Object> reactiveRedisTemplate;
  private StringRedisTemplate stringRedisTemplate;
  private BizService bizService;

  public BizHandle(
      ReactiveRedisTemplate<Object, Object> reactiveRedisTemplate,
      StringRedisTemplate stringRedisTemplate, BizService bizService) {
    this.reactiveRedisTemplate = reactiveRedisTemplate;
    this.stringRedisTemplate = stringRedisTemplate;
    this.bizService = bizService;
  }

  public Mono<ServerResponse> start(ServerRequest request) {
    return common(request, "okhttp1.1", bizService.method1());
  }

  public Mono<ServerResponse> method1(ServerRequest request) {
    return common(request, "httpclient1.1", bizService.method2());
  }

  public Mono<ServerResponse> method2(ServerRequest request) {
    return common(request, "grpc", bizService.method3());
  }

  public Mono<ServerResponse> method3(ServerRequest request) {
    return common(request, "end", "end");
  }

  private Mono<ServerResponse> common(ServerRequest request, String value, String remote) {
    LOGGER.info("path {} attributes {} cookies {} formData {} headers {} queryParams {} method {}",
        request.path(), request.attributes(),
        request.cookies(), request.formData(),
        request.headers(), request.queryParams(), request.method());
    reactiveRedisTemplate.opsForList().rightPush("list", value + LocalDateTime.now());
    String result =
        stringRedisTemplate.boundValueOps("increment").increment(1L) + "," + remote;
    return ServerResponse.ok().body(Mono.just(result), String.class);
  }

}
