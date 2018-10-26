package yokv.config;

import okhttp3.Interceptor;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * CREATE BY Yo ON 2018/5/27 17:23
 */
@Component
class OkHttpInterceptor implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(OkHttpInterceptor.class);

    @Override
    public Response intercept(Chain chain) throws IOException {
        logger.info("OkHttpInterceptor connection {},request {} ", chain.connection(), chain.request());
        return chain.proceed(chain.request());
    }
}
