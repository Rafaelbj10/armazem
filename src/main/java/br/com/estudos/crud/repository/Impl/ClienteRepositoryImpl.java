package br.com.estudos.crud.repository.Impl;

import br.com.estudos.crud.parameters.ClienteRequest;
import br.com.estudos.crud.presenters.cliente.ClienteDto;
import br.com.estudos.crud.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static br.com.estudos.crud.utils.queries.ClienteQuery.BUSCAR_POR_ID;
import static br.com.estudos.crud.utils.queries.ClienteQuery.INSERT_CLIENT;

@RequiredArgsConstructor
@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final JdbcTemplate jdbcTemplate;

    public void insertClient(final ClienteRequest request) {
        jdbcTemplate.update(INSERT_CLIENT, request.getNome(), request.getCpf(), request.getEndereco());
    }

    @Override
    public ClienteDto buscar(final String cpf) {
        try {
            return jdbcTemplate.queryForObject(BUSCAR_POR_ID, new BeanPropertyRowMapper<>(ClienteDto.class), cpf);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Não foi possível encontrar o cliente na base.");
        }

    }

}



