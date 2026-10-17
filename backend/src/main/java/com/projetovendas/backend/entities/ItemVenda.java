package com.projetovendas.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "item_venda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itv_id")
    private Long id;

    @Column(name = "itv_quantidade")
    private int quantidade;

    @Column(name = "itv_precounitario")
    private double precoUnitario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pro_id", nullable = false)
    private Produto produto;

    public ItemVenda() {
    }

    public ItemVenda(int quantidade, double precoUnitario, Produto produto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.produto = produto;
    }

    public ItemVenda(Long id, int quantidade, double precoUnitario, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
