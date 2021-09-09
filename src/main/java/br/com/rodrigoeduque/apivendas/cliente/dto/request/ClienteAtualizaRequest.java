package br.com.rodrigoeduque.apivendas.cliente.dto.request;

import br.com.rodrigoeduque.apivendas.cliente.model.Cliente;
import br.com.rodrigoeduque.apivendas.cliente.repository.ClienteRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteAtualizaRequest {

    @NotBlank
    @Length(max = 150)
    private String nome;
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }


    public Cliente atualizar(Long id, ClienteRepository repository) {
        Cliente cliente = repository.findById(id).get();
        cliente.setNome(nome);
        cliente.setCpf(cpf);

        return cliente;
    }
}
