package cn.hitstone.oauth.security.xss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 描述 : 跨站请求防范
 * @author zee
 */
@WebFilter(filterName = "xssFilter", urlPatterns = "/*", asyncSupported = true )
public class XssFilter implements Filter {

    /**
     * 描述 : 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(XssFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("(XssFilter) initialize");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)request;

        String method = httpServletRequest.getMethod();

        if(!"GET".equals(method)){
            XssHttpServletRequestWrapper xssRequest =
                    new XssHttpServletRequestWrapper((HttpServletRequest) request);
            chain.doFilter(xssRequest, response);
        }else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        logger.debug("(XssFilter) destroy");
    }

}
