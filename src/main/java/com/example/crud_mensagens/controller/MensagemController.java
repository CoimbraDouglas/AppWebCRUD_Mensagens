package com.example.crud_mensagens.controller;

import com.example.crud_mensagens.model.Mensagem;
import com.example.crud_mensagens.service.MensagemService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    private final MensagemService service;

    public MensagemController(MensagemService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Mensagem adicionarMensagem(@RequestBody Mensagem mensagem) {
        return service.adicionarMensagem(mensagem.getTexto());
    }

    // Read all
    @GetMapping
    public List<Mensagem> listarMensagens() {
        return service.listarMensagens();
    }

    // Read by id
    @GetMapping("/{id}")
    public Mensagem buscarMensagem(@PathVariable int id) {
        return service.buscarPorId(id);
    }

    // Update
    @PutMapping("/{id}")
    public Mensagem atualizarMensagem(@PathVariable int id, @RequestBody Mensagem mensagem) {
        return service.atualizarMensagem(id, mensagem.getTexto());
    }

    // Delete
    @DeleteMapping("/{id}")
    public String removerMensagem(@PathVariable int id) {
        boolean removido = service.removerMensagem(id);
        return removido ? "Mensagem removida com sucesso!" : "Mensagem não encontrada!";
    }
}

