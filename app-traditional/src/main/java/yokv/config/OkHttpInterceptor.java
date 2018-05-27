package yokv.config;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * CREATE BY Yo ON 2018/5/27 17:23
 */
@Component
class OkHttpInterceptor implements Interceptor {

  private final static Logger LOGGER = LoggerFactory.getLogger(OkHttpInterceptor.class);

  @Override
  public Response intercept(Chain chain) throws IOException {
    LOGGER.info("OkHttpInterceptor connection {},request {} ", chain.connection().toString(),
        chain.request().toString());
    return chain.proceed(chain.request());
  }
}
