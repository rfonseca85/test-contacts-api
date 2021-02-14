package io.challenge.jahia.contacts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class ApikeyCheckInterceptor implements HandlerInterceptor {

    @Value("${api.key}")
    private String apiKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Pre handle method has been called");
        String apikey = request.getHeader("x-api-key");
        if(apikey==null || apikey.equals("")){
            throwMessageToResponse(response,"x-api-key not found");
        }else{
            if(!apikey.equals(apiKey)){
                throwMessageToResponse(response,"Invalid API Key");
            }
        }
        return true;
    }

    private void throwMessageToResponse(HttpServletResponse response, String message) throws IOException {
        HttpServletResponse httpResponse = response;
        httpResponse.setStatus(401);
        httpResponse.getWriter().write(message);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("Post handle method has been called");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception exception) throws Exception {
        System.out.println("After Completion method has been called");
        System.out.println("x-api-key used again" + request.getHeader("x-api-key"));
    }
}
