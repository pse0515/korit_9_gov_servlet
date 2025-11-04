package com.korit.servlet_study.ch05;

public class Filter3 implements Filter{
    @Override
    public void doFilter(Request req, Response resp, FilterChain filterChain) {
        filterChain.doFilter(req,resp);
    }
}