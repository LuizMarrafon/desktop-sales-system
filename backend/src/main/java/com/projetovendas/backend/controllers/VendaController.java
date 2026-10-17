package com.projetovendas.backend.controllers;

import com.projetovendas.backend.entities.Erro;
import com.projetovendas.backend.entities.Venda;
import com.projetovendas.backend.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("venda")
@CrossOrigin(origins = "*")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @GetMapping("get-all")
    public ResponseEntity<Object> getAllVenda() {
        return ResponseEntity.ok(vendaService.getAll());
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Venda venda) {
        venda = vendaService.save(venda);
        if (venda != null) {
            return ResponseEntity.ok(venda);
        }
        return ResponseEntity.badRequest().body(new Erro("Erro ao salvar"));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Venda venda) {
        Venda vendaAlterada = vendaService.save(venda);
        if (vendaAlterada != null) {
            return ResponseEntity.ok(vendaAlterada);
        }
        return ResponseEntity.badRequest().body(new Erro("Erro ao alterar"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (vendaService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body(new Erro("Erro ao deletar"));
    }
}
