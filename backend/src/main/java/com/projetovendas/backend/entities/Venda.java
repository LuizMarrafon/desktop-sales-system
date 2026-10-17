package com.projetovendas.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ven_id")
    private Long id;

    @Column(name = "ven_data")
    private LocalDateTime dataVenda = LocalDateTime.now();

    @Column(name = "ven_valortotal")
    private double valorTotal;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ven_id", nullable = false)
    private List<ItemVenda> itens = new ArrayList<>();

    public Venda() {
    }

    public Venda(LocalDateTime dataVenda, double valorTotal) {
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public Venda(Long id, LocalDateTime dataVenda, double valorTotal) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        if (itens == null) {
            this.itens = new ArrayList<>();
        } else {
            this.itens = itens;
        }
    }

    public void addItem(ItemVenda item) {
        this.itens.add(item);
    }
}
