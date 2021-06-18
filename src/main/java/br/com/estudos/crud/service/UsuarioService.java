package br.com.estudos.crud.service;

import br.com.estudos.crud.model.Usuario;
import br.com.estudos.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscar(@PathVariable Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario cadastrar(@RequestBody Usuario usuario){
         usuarioRepository.save(usuario);
         return usuario;
    }

    public void alterar(@RequestBody Usuario imput, @PathVariable Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            Usuario entity = usuario.get();

            entity.setId(imput.getId());
            entity.setNome(imput.getNome());
            entity.setEndereco(imput.getEndereco());
            entity.setCpf(imput.getCpf());
            entity.setDataNascimento(imput.getDataNascimento());

            usuarioRepository.save(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não existe no banco");
        }

    }

    public void deletar(@PathVariable Long id){
        usuarioRepository.deleteById(id);
    }

}
