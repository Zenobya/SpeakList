package com.camila.speaklist.controller;

import com.camila.speaklist.model.ItemLista;
import com.camila.speaklist.service.ImagemService;
import com.camila.speaklist.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/lista")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @Autowired
    private ImagemService imagemService;

    @PostMapping("/adicionar")
    public ResponseEntity<ItemLista> adicionar(
            @RequestParam String nome,
            @RequestParam Integer quantidade,
            @RequestParam String unidade) {
        ItemLista item = listaService.adicionarItem(nome, quantidade, unidade);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<ItemLista> atualizar(
            @RequestParam String nome,
            @RequestParam Integer quantidade) {
        ItemLista item = listaService.atualizarQuantidade(nome, quantidade);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/somar")
    public ResponseEntity<ItemLista> somar(
            @RequestParam String nome,
            @RequestParam Integer quantidade) {
        ItemLista item = listaService.somarQuantidade(nome, quantidade);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/subtrair")
    public ResponseEntity<String> subtrair(
            @RequestParam String nome,
            @RequestParam Integer quantidade) {
        listaService.subtrairQuantidade(nome, quantidade);
        return ResponseEntity.ok("Quantidade de '" + nome + "' atualizada!");
    }

    @DeleteMapping("/remover")
    public ResponseEntity<String> remover(@RequestParam String nome) {
        listaService.removerItem(nome);
        return ResponseEntity.ok("Item '" + nome + "' removido com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<ItemLista>> listar() {
        List<ItemLista> itens = listaService.listarItens();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("/imagem")
    public ResponseEntity<byte[]> gerarImagem() throws IOException {
        byte[] imagem = imagemService.gerarImagemLista();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=lista.png")
                .contentType(MediaType.IMAGE_PNG)
                .body(imagem);
    }
}