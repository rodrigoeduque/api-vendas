package br.com.rodrigoeduque.apivendas.cliente.controller;

import br.com.rodrigoeduque.apivendas.cliente.dto.request.ClienteAtualizaRequest;
import br.com.rodrigoeduque.apivendas.cliente.dto.request.ClienteRequest;
import br.com.rodrigoeduque.apivendas.cliente.dto.response.ClienteDetalheResponse;
import br.com.rodrigoeduque.apivendas.cliente.dto.response.TodosClientesResponse;
import br.com.rodrigoeduque.apivendas.cliente.model.Cliente;
import br.com.rodrigoeduque.apivendas.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/clientes")
public class ClienteController {

    private ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<ClienteRequest> novoCliente(@RequestBody @Valid ClienteRequest request) {

        Cliente cliente = request.toModel();
        repository.save(cliente);

        URI uri = UriComponentsBuilder.fromPath("api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDetalheResponse> clienteDetalhe(@PathVariable Long id) {
        Optional<Cliente> possivelCliente = repository.findById(id);

        if (possivelCliente.isPresent()) {
            return ResponseEntity.ok().body(new ClienteDetalheResponse(possivelCliente.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<?>> todosClientes() {

        List<Cliente> todosClientes = repository.findAll();
        return ResponseEntity.ok().body(todosClientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDetalheResponse> atualizarCliente(@PathVariable Long id, @Valid @RequestBody ClienteAtualizaRequest request) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Cliente clienteAtualizado = request.atualizar(id, repository);

        return ResponseEntity.ok().body(new ClienteDetalheResponse(clienteAtualizado));
    }
}
