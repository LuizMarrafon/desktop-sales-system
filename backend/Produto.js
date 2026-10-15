class produto{
    #id;
    #nome;
    #preco;
    #quantidadeEstoque;
    #estoqueMinimo;

    constructor(id, nome, preco, quantidadeEstoque, estoqueMinimo){
        if (!nome.trim()) {
            throw new Error("O nome é obrigatório");
        }

        if (!Number.isFinite(preco) || preco < 0) {
            throw new Error("Preço inválido");
        }

        if (!Number.isInteger(quantidadeEstoque) || quantidadeEstoque < 0) {
            throw new Error("Estoque inválido");
        }

        this.#id = id;
        this.#nome = nome;
        this.#preco = preco;
        this.#quantidadeEstoque = quantidadeEstoque;
        this.#estoqueMinimo = estoqueMinimo;
    }
    getId() {
        return this.#id;
    }
    getNome() {
        return this.#nome;
    }
    getPreco() {
        return this.#preco;
    }
    getQuantidadeEstoque() {
        return this.#quantidadeEstoque;
    }
    getEstoqueBaixo(){
        return this.#estoqueMinimo >= this.#quantidadeEstoque;
    }

    alterarPreco(novoPreco) {
        if (!Number.isFinite(novoPreco) || novoPreco < 0) {
            throw new Error("Preço inválido");
        }
        this.#preco = novoPreco;
    }

    retirarEstoque(quantidade) {
        if (!Number.isInteger(quantidade) || quantidade < 0) {
            throw new Error("Quantidade inválida");
        }
        if (quantidade > this.#quantidadeEstoque) {
            throw new Error("Estoque insuficiente");
        }
        this.#quantidadeEstoque -= quantidade;
    }
}