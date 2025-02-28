package br.com.senai.meuprojeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.meuprojeto.entity.Produto;
import br.com.senai.meuprojeto.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public ResponseEntity<List<br.com.senai.meuprojeto.entity.Produto>> findAll(){
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok().body(produtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<br.com.senai.meuprojeto.entity.Produto> findById(@PathVariable Long id){
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }
    @PostMapping("/inserir")
    public ResponseEntity<Produto> insertNew(@RequestBody Produto produto){
        Produto produtoInserido = produtoService.insertNew(produto);
        return ResponseEntity.ok().body(produtoInserido);
    }
    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produtoAlterado){
        Produto produto = produtoService.update(id, produtoAlterado);
        return ResponseEntity.ok().body(produto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = produtoService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }




}
