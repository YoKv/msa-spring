package yokv.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CREATE BY Yo ON 2018/5/27 00:10
 */
@FeignClient(name = "app-traditional")
public interface BizService {

  @RequestMapping("/method1")
  String method1();

  @RequestMapping("/method2")
  String method2();

  @RequestMapping("/method3")
  String method3();

}
