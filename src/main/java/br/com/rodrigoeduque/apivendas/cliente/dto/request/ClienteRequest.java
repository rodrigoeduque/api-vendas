package br.com.rodrigoeduque.apivendas.cliente.dto.request;

import br.com.rodrigoeduque.apivendas.cliente.model.Cliente;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteRequest {


    @NotBlank
    @Length(max = 150)
    private String nome;
    @NotBlank
    @Size(min = 11, max = 11)
    @CPF
    private String cpf;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Cliente toModel() {
        return new Cliente(nome,
                cpf);
    }
}
