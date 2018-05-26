package yokv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CREATE BY Yo ON 2018/5/26 22:57
 */
@RestController
public class BizController {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @RequestMapping("/start")
  public String method1() {
    stringRedisTemplate.opsForValue().set("key", "value");

    stringRedisTemplate.boundValueOps("increment").increment(1L);

    return stringRedisTemplate.opsForValue().get("key");
  }

}
