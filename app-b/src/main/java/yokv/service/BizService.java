package yokv.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * CREATE BY Yo ON 2018/5/27 00:10
 */
@FeignClient(name = "app-c")
public interface BizService {

    @GetMapping("/method1")
    String method1();

    @GetMapping("/method2")
    String method2();

    @GetMapping("/method3")
    String method3();
}
