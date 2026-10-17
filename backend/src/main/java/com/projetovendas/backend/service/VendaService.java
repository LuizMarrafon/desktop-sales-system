package com.projetovendas.backend.service;

import com.projetovendas.backend.entities.Venda;
import com.projetovendas.backend.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> getAll() {
        return vendaRepository.findAll();
    }

    public Venda getId(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public Venda save(Venda venda) {
        Venda novaVenda;
        try {
            novaVenda = vendaRepository.save(venda);
        } catch (Exception e) {
            novaVenda = null;
        }
        return novaVenda;
    }

    public boolean delete(Long id) {
        if (getId(id) == null) {
            return false;
        }
        vendaRepository.deleteById(id);
        return true;
    }
}
