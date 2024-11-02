package com.ejercicioClase7.ejercicioClase7.Interceptor;

import java.time.LocalTime;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    private final LocalTime startTime = LocalTime.of(8, 0);
    private final LocalTime finalTime = LocalTime.of(17, 0);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalTime currTime = LocalTime.now();

        if (currTime.isBefore(startTime) || currTime.isAfter(finalTime)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            String jsonResponse = "{\"message\":\"No se aceptan conexiones fuera del horario (8 AM - 5 PM)\"}";
            response.getWriter().write(jsonResponse);
            response.getWriter().flush();

            return false;
        } else {
            return true;
        }
    }
}
