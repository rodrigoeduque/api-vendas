package br.com.rodrigoeduque.apivendas.servico.repository;

import br.com.rodrigoeduque.apivendas.servico.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
