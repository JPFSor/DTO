package com.aulaspring.aulajpa.Aula.service;

import com.aulaspring.aulajpa.Aula.dto.UsuarioRequestDTO;
import com.aulaspring.aulajpa.Aula.dto.UsuarioResponseDTO;
import com.aulaspring.aulajpa.Aula.model.Usuario;
import com.aulaspring.aulajpa.Aula.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    private Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario user = new Usuario();
        user.setNome(usuarioRequestDTO.getNome());
        user.setEmail(usuarioRequestDTO.getEmail());
        user.setSenha(usuarioRequestDTO.getSenha());
        user.setCpf(usuarioRequestDTO.getCpf());
        return user;
    }
    private UsuarioResponseDTO toDTO(Usuario usuario) {
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .build();

    }
    public UsuarioResponseDTO salvar(UsuarioRequestDTO usuarioRequestDTO) {
        if (repository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Email já cadastrado"
            );
        }
        Usuario usuario = toEntity(usuarioRequestDTO);
        Usuario usuarioSalvo = this.repository.save(usuario);
        return toDTO(usuarioSalvo);
    }
    public List<UsuarioResponseDTO> todos() {
        return this.repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }
    public UsuarioResponseDTO porId(Long id) {
        Usuario usuario = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
                return toDTO(usuario);
    }
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setCpf(dto.getCpf());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        Usuario atualizado = repository.save(usuario);
        return toDTO(atualizado);
    }
    public String excluir(Long id) {
        Usuario usuario = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        this.repository.delete(usuario);
        return "Excluído com sucesso";
    }
}
