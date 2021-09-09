package br.com.rodrigoeduque.apivendas.servico.model;

import br.com.rodrigoeduque.apivendas.cliente.model.Cliente;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 250)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private BigDecimal valor;
}
