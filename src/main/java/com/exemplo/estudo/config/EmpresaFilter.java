package com.exemplo.estudo.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class EmpresaFilter extends OncePerRequestFilter {

    private static final String EMPRESA_HEADER = "X-Empresa-ID";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String empresaId = request.getHeader(EMPRESA_HEADER);
        if (empresaId != null) {
            EmpresaContextHolder.setEmpresaId(empresaId);
        }
        try {
            filterChain.doFilter(request, response);
        } finally {
            EmpresaContextHolder.clear();
        }
    }
}
