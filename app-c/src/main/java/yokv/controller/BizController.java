package yokv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yokv.service.BizService;

/**
 * CREATE BY Yo ON 2018/5/26 22:57
 */
@RestController
public class BizController {
    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private BizService bizService;

    @RequestMapping("/method1")
    public String method1() {
        return appName + " method1 " + bizService.method2();
    }

    @RequestMapping("/method2")
    public String method2() {
        return appName + " method2 " + bizService.method3();
    }

    @RequestMapping("/method3")
    public String method3() {
        return appName + " method3 ";
    }
}
