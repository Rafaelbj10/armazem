package br.com.estudos.crud.controller;

import br.com.estudos.crud.dto.UsuarioDto;
import br.com.estudos.crud.model.Usuario;
import br.com.estudos.crud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @GetMapping
    public List<UsuarioDto> listar(){
        List<Usuario> usuario = usuarioService.listar();

        List<UsuarioDto> usuarioDto = new ArrayList<>();

        for (Usuario u : usuario){

            UsuarioDto dto = new UsuarioDto();

            dto.setId(u.getId());
            dto.setNome(u.getNome());
            dto.setEndereco(u.getEndereco());

            usuarioDto.add(dto);
        }
        return usuarioDto;
    }

    @GetMapping("/{id}")
    public List<UsuarioDto> buscar(@PathVariable Long id){

        List<Usuario> usuario = usuarioService.listar();
        List<UsuarioDto> usuarioDto = new ArrayList<>();

        for (Usuario u : usuario){

            UsuarioDto dto = new UsuarioDto();
            dto.setId(u.getId());
            dto.setNome(u.getNome());
            dto.setEndereco(u.getEndereco());

            usuarioDto.add(dto);
        }
        return usuarioDto;
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioDto usuarioDto){
        Usuario usuario = usuarioService.cadastrar(usuarioDto.transformaParaObjeto());
        return new ResponseEntity(usuarioDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@RequestBody UsuarioDto usuarioDto,@PathVariable Long id){
        usuarioService.alterar(usuarioDto.transformaParaObjeto(), id);
        return new ResponseEntity(usuarioDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        usuarioService.deletar(id);
    }




}
