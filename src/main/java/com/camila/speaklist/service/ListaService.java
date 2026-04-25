package com.camila.speaklist.service;

import com.camila.speaklist.model.ItemLista;
import com.camila.speaklist.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaService {

    @Autowired
    private ItemRepository repository;

    // Adiciona novo item
    public ItemLista adicionarItem(String nome, Integer quantidade, String unidade) {
        if (repository.existsByNomeIgnoreCase(nome)) {
            throw new RuntimeException("Item '" + nome + "' já está na lista!");
        }
        ItemLista item = new ItemLista();
        item.setNome(nome);
        item.setQuantidade(quantidade);
        item.setUnidade(unidade);
        return repository.save(item);
    }

    // Substitui a quantidade de um item
    public ItemLista atualizarQuantidade(String nome, Integer novaQuantidade) {
        ItemLista item = repository.findByNomeIgnoreCase(nome)
                .orElseThrow(() -> new RuntimeException("Item '" + nome + "' não encontrado!"));
        item.setQuantidade(novaQuantidade);
        return repository.save(item);
    }

    // Soma quantidade a um item existente
    public ItemLista somarQuantidade(String nome, Integer quantidade) {
        ItemLista item = repository.findByNomeIgnoreCase(nome)
                .orElseThrow(() -> new RuntimeException("Item '" + nome + "' não encontrado!"));
        item.setQuantidade(item.getQuantidade() + quantidade);
        return repository.save(item);
    }

    // Subtrai quantidade de um item existente
    public ItemLista subtrairQuantidade(String nome, Integer quantidade) {
        ItemLista item = repository.findByNomeIgnoreCase(nome)
                .orElseThrow(() -> new RuntimeException("Item '" + nome + "' não encontrado!"));
        int novaQuantidade = item.getQuantidade() - quantidade;
        if (novaQuantidade <= 0) {
            repository.delete(item);
            throw new RuntimeException("Item '" + nome + "' removido pois quantidade chegou a zero!");
        }
        item.setQuantidade(novaQuantidade);
        return repository.save(item);
    }

    // Remove item completamente
    public void removerItem(String nome) {
        ItemLista item = repository.findByNomeIgnoreCase(nome)
                .orElseThrow(() -> new RuntimeException("Item '" + nome + "' não encontrado!"));
        repository.delete(item);
    }

    // Lista todos os itens
    public List<ItemLista> listarItens() {
        return repository.findAll();
    }
}