package com.baoli.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RequestCallback;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: spring-cloud-demo
 * @description: 过滤器
 * @author: li baojian
 * @create: 2020-05-14 14:42
 */
@Component
public class MyFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(ZuulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            logger.warn("token is empty!");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("token is empty!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
