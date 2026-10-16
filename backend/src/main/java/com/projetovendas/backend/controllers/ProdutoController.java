package com.projetovendas.backend.controllers;

import com.projetovendas.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("get-all")
    public ResponseEntity<Object> getAllProduto(){
        return ResponseEntity.ok(produtoService.getAll());
    }
}
