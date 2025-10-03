package com.example.crud_mensagens.service;


import com.example.crud_mensagens.model.Mensagem;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MensagemService {

    private List<Mensagem> mensagens = new ArrayList<>();
    private int nextId = 1;

    // Create
    public Mensagem adicionarMensagem(String texto) {
        Mensagem mensagem = new Mensagem(nextId++, texto);
        mensagens.add(mensagem);
        return mensagem;
    }

    // Read (all)
    public List<Mensagem> listarMensagens() {
        return mensagens;
    }

    // Read (by id)
    public Mensagem buscarPorId(int id) {
        return mensagens.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update
    public Mensagem atualizarMensagem(int id, String novoTexto) {
        Mensagem mensagem = buscarPorId(id);
        if (mensagem != null) {
            mensagem.setTexto(novoTexto);
        }
        return mensagem;
    }

    // Delete
    public boolean removerMensagem(int id) {
        return mensagens.removeIf(m -> m.getId() == id);
    }
}

