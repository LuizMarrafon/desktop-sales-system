package com.projetovendas.backend.service;

import com.projetovendas.backend.entities.Produto;
import com.projetovendas.backend.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAll(){
        List<Produto> produtoList = produtoRepository.findAll();
        return produtoList;
    }

    public Produto getId(Long id){
        Produto produto = produtoRepository.findById(id).orElse(null);
        return produto;
    }

    public Produto save(Produto produto){
        Produto novoProduto;
        try{
            novoProduto = produtoRepository.save(produto);
        } catch (Exception e) {
            novoProduto = null;
        }
        return novoProduto;
    }

    public boolean delete(Long id) {
        if (getId(id) == null)
            return false;
        else {
            produtoRepository.deleteById(id);
            return true;
        }
    }

    public List<Produto> getByKeyWord(String kw){
        List<Produto> produtoList = produtoRepository.findAllByKeyWord(kw.toUpperCase());
        return produtoList;
    }
}
