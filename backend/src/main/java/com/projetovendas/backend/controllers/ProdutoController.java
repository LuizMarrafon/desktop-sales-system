package com.projetovendas.backend.controllers;

import com.projetovendas.backend.entities.Erro;
import com.projetovendas.backend.entities.Produto;
import com.projetovendas.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("get-all")
    public ResponseEntity<Object> getAllProduto(){
        return ResponseEntity.ok(produtoService.getAll());
    }

    @GetMapping("get-by-keyword/{kw}")
    public ResponseEntity<Object> getAllKeyWord(@PathVariable String kw){
        return ResponseEntity.ok(produtoService.getByKeyWord(kw));
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Produto produto){
        produto = produtoService.save(produto);
        if(produto != null){
            return ResponseEntity.ok(produto);
        }
        else{
            return ResponseEntity.badRequest().body(new Erro("Erro ao salvar"));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        if(produtoService.delete(id))
            return ResponseEntity.noContent().build();
        return ResponseEntity.badRequest().body(new Erro("Erro ao deletar"));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Produto produto){
        if(produtoService.save(produto)!=null){
            return ResponseEntity.ok().body(produto);
        }
        else
            return ResponseEntity.badRequest().body(new Erro("Erro ao alterar"));
    }
}
