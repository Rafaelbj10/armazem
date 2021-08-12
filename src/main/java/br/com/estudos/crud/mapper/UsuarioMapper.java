package br.com.estudos.crud.mapper;

import br.com.estudos.crud.dto.UsuarioDto;
import br.com.estudos.crud.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public List<UsuarioDto> getUsuariosDtoByForEachNormal(List<Usuario> usuarioList){

        List<UsuarioDto> usuarioDto = new ArrayList<>();

        for (Usuario usuario : usuarioList){

            UsuarioDto dto = new UsuarioDto();

            dto.setId(usuario.getId());
            dto.setNome(usuario.getNome());
            dto.setEndereco(usuario.getEndereco());

            usuarioDto.add(dto);

        }

        return usuarioDto;

    }

}
