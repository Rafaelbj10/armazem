package br.com.estudos.crud.repository;

import br.com.estudos.crud.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Cliente, Long> {
}
