package br.com.devsenior.ds_consulta_vendas.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
