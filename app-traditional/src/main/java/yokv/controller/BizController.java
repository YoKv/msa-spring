package yokv.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yokv.service.BizService;

/**
 * CREATE BY Yo ON 2018/5/26 22:57
 */
@RestController
public class BizController {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;
  @Autowired
  private BizService bizService;

  @RequestMapping("/method1")
  public String method1() {
    stringRedisTemplate.opsForList().rightPop("okhttp2.0" + LocalDateTime.now());
    return stringRedisTemplate.boundValueOps("increment").increment(1L) + "," + bizService
        .method1();
  }

  @RequestMapping("/method2")
  public String method2() {
    stringRedisTemplate.opsForList().rightPop("httpclient2.0" + LocalDateTime.now());
    return stringRedisTemplate.boundValueOps("increment").increment(1L) + "," + bizService
        .method2();
  }

  @RequestMapping("/method3")
  public String method3() {
    stringRedisTemplate.opsForList().rightPop("grpc" + LocalDateTime.now());
    return stringRedisTemplate.boundValueOps("increment").increment(1L) + "," + bizService
        .method3();
  }
}
