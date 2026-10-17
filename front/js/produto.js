function cadastroProduto(){
    const produto = {}
    produto.nome = document.getElementById('product-name').value
    produto.descricao = document.getElementById('product-description').value
    produto.preco = document.getElementById('product-price').value
    produto.quantidadeEstoque = document.getElementById('product-stock').value
    const requestOptions = { method: "POST", headers: {"Content-Type": "application/json"},
        body: JSON.stringify(produto)
    };
    fetch("http://localhost:8080/produto", requestOptions)
        .then(response => {
            if(response.status===200){
                return response.json()
                    .then(produto => {
                        alert(produto.nome+" adicionado com sucesso!");
                        carregarProdutos();
                    });
            }
            else {
                alert("Erro ao adicionar o produto!");
            }
    })
}

function carregarProdutos(){
    const select = document.getElementById('product-table-body');

    fetch('http://localhost:8080/produto/get-all')
    .then(response => response.json())
    .then(produtos => {
        let linhas = ""
        for(produto of produtos){
            linhas += `<tr>
                <td>${produto.nome}</td>
                <td>${produto.descricao}</td>
                <td>R$ ${produto.preco.toFixed(2)}</td>
                <td>${produto.quantidadeEstoque}</td>
                <td>${produto.quantidadeEstoque > 0 ? "Em estoque" : "Fora de estoque"}</td>
                <td><button class="delete-button" type="button" aria-label="Excluir produto ${produto.id}" title="Excluir produto" onclick="deletarProduto(${produto.id})"><span class="material-symbols-outlined">delete</span></button></td>
            </tr>`
        }
        select.innerHTML = linhas;
    })
}

function deletarProduto(id){
    fetch('http://localhost:8080/produto/' + id, { method: 'DELETE' })
        .then(response => {
            if(response.ok){
                carregarProdutos();
            } else {
                console.error('Não foi possível excluir o produto.');
            }
        })
        .catch(error => console.error('Erro ao excluir produto:', error));
}
