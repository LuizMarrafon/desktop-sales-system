package com.projetovendas.backend.controllers;

import com.projetovendas.backend.entities.Erro;
import com.projetovendas.backend.entities.ItemVenda;
import com.projetovendas.backend.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item-venda")
public class ItemVendaController {

    @Autowired
    ItemVendaService itemVendaService;

    @GetMapping("get-all")
    public ResponseEntity<Object> getAllItemVenda() {
        return ResponseEntity.ok(itemVendaService.getAll());
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody ItemVenda itemVenda) {
        itemVenda = itemVendaService.save(itemVenda);
        if (itemVenda != null) {
            return ResponseEntity.ok(itemVenda);
        }
        return ResponseEntity.badRequest().body(new Erro("Erro ao salvar"));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody ItemVenda itemVenda) {
        ItemVenda itemVendaAlterado = itemVendaService.save(itemVenda);
        if (itemVendaAlterado != null) {
            return ResponseEntity.ok(itemVendaAlterado);
        }
        return ResponseEntity.badRequest().body(new Erro("Erro ao alterar"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (itemVendaService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body(new Erro("Erro ao deletar"));
    }
}
