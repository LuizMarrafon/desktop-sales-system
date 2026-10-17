package com.projetovendas.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;
    @Column(name = "pro_nome")
    private String nome;
    @Column(name = "pro_desc")
    private String descricao;
    @Column(name = "pro_preco")
    private double preco;
    @Column(name = "pro_qtdestoque")
    private int quantidadeEstoque;
    @Column(name = "pro_ativo")
    private boolean ativo;

    public Produto() {
    }

    public Produto(String nome, String descricao, double preco, int quantidadeEstoque, boolean ativo) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.ativo = ativo;
    }

    public Produto(String nome, String descricao, double preco, int quantidadeEstoque){
        this(nome, descricao, preco, quantidadeEstoque, true);
    }

    public Produto(Long id, String nome, String descricao, double preco, int quantidadeEstoque, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
