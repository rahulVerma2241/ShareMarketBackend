package com.arrow.sharemarketbackend.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class RequestResponseFilter extends OncePerRequestFilter {
    Logger logger = LoggerFactory.getLogger(RequestResponseFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        logger.info("ShareMarket App API called {} with body {} and APi response : {}  " ,
                request.getRequestURL() , request , response);
        filterChain.doFilter(request , response);
    }
}
