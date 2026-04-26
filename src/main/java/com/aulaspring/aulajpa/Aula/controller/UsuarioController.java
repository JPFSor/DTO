package com.aulaspring.aulajpa.Aula.controller;

import com.aulaspring.aulajpa.Aula.dto.UsuarioRequestDTO;
import com.aulaspring.aulajpa.Aula.dto.UsuarioResponseDTO;
import com.aulaspring.aulajpa.Aula.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService service;

    public UsuarioController(UsuarioService usuarioService) {
        this.service = usuarioService;
    }
    @PostMapping
    public UsuarioResponseDTO salvar(@RequestBody @Valid UsuarioRequestDTO usuario) {
        return this.service.salvar(usuario);
    }
    @GetMapping("{id}")
    public UsuarioResponseDTO porId(@PathVariable Long id) {
        return this.service.porId(id);
    }
    @GetMapping
    public List<UsuarioResponseDTO> todos() {
        return this.service.todos();
    }
    @PutMapping("{id}")
    public UsuarioResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioRequestDTO usuario) {
        return this.service.atualizar(id, usuario);
    }
    @DeleteMapping("{id}")
    public String excluir(@PathVariable Long id) {
        return this.service.excluir(id);
    }
}
