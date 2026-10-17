package com.projetovendas.backend.service;

import com.projetovendas.backend.entities.ItemVenda;
import com.projetovendas.backend.repositories.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public List<ItemVenda> getAll() {
        return itemVendaRepository.findAll();
    }

    public ItemVenda getId(Long id) {
        return itemVendaRepository.findById(id).orElse(null);
    }

    public ItemVenda save(ItemVenda itemVenda) {
        ItemVenda novoItemVenda;
        try {
            novoItemVenda = itemVendaRepository.save(itemVenda);
        } catch (Exception e) {
            novoItemVenda = null;
        }
        return novoItemVenda;
    }

    public boolean delete(Long id) {
        if (getId(id) == null) {
            return false;
        }
        itemVendaRepository.deleteById(id);
        return true;
    }
}
