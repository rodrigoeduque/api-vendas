package br.com.rodrigoeduque.apivendas.cliente.dto.response;

import br.com.rodrigoeduque.apivendas.cliente.model.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class ClienteDetalheResponse {

    private Long id;
    private String nome;
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dhCadastro;

    public ClienteDetalheResponse(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dhCadastro = cliente.getDhCadastro();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDateTime getDhCadastro() {
        return dhCadastro;
    }
}
