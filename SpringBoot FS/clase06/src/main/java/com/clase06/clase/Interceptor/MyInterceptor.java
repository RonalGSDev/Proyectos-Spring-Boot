package com.clase06.clase.Interceptor;

//import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor{
    // Restringir horarios
    //private final LocalTime startTime = LocalTime.of(10, 0);
    //private final LocalTime finalTime = LocalTime.of(17, 0);
    
    
    //restringir ips
    private final List<String> allowedIps = Arrays.asList(
        "0:0:0:0:0:0:0:1",
        "127.0.0.1"
    );

    

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        //para restringir por horario
        /* 
        LocalTime currTime = LocalTime.now();

        if (currTime.isBefore(startTime) || currTime.isAfter(finalTime)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            String jsonResponse = "{\"message\":\"No se aceptan conexiones fuera del horario (10 AM - 5 PM)\"}";
            response.getWriter().write(jsonResponse);
            response.getWriter().flush();

            return false;
        } else {
            return true;
        }
        */

        //Restringir por IP
        String clientIp = request.getRemoteAddr();
        if (!allowedIps.contains(clientIp)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            
            String jsonResponse = "{\"message\":\"Acceso denegado a esta IP: " + clientIp + "\"}";
            
            response.getWriter().write(jsonResponse);
            response.getWriter().flush();
            
            return false;

        }else{
            System.out.println("Acceso permitido para la IP: "+clientIp);
            return true;
        }


    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String requestUri = request.getRequestURI();
        String clientIp = request.getRemoteAddr();
        String httpMethod = request.getMethod();
        
        System.out.println("Solicitud manejada: " + httpMethod + " " + requestUri + " desde IP: " + clientIp);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception{
        System.out.println("Request and response esta completo");
    }    

}
