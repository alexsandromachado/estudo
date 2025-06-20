package com.exemplo.estudo.config;

public class EmpresaContextHolder {

    private static final ThreadLocal<String> empresaId = new ThreadLocal<>();

    public static void setEmpresaId(String id){
        empresaId.set(id);
    }

    public static String getEmpresaId(){
        return empresaId.get();
    }

    public static void clear(){
        empresaId.remove();
    }
}
