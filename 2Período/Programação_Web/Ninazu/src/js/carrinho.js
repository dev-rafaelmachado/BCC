const Token = sessionStorage.getItem("loginToken"),
        listaEle = document.getElementById("lista");

function loadCarrinho(){
    let data = new FormData();
    data.append("cpfUser", Token);

    fetch("../../backend/listarCarrinho.php", {
    method: "POST",
    body: data,
    }).then(async (resp) => {
    const obj = await resp.json();
    console.log(obj);
    mostrarProdutos(obj)
    });
}
function mostrarProdutos(content) {
  listaEle.innerHTML = "";
  for (let index = 0; index < content.length; index++) {
    let produto = "";
    
    let preco = content[index]['preco']
    preco = preco.replace('.',',')

    produto += "<div class='card-produto'>"
    produto += "<div>"
    produto += "<img src='"+ content[index]['img_link'] +"' alt='PRODUTO'>"
    produto += "<span>"
    produto += "<h2>"+ content[index]['nome'] +"</h2>"
    produto += "<h5> " + preco + "</h5>";
    produto += "<input placeholder='Quantidade' type='number' value='1'>"
    produto += "</span>"
    produto += "</div>"
    produto += "<button onclick='removeProdutoCarrinho(" + content[index]['id_produto'] + ")' class='bt-rmvCarrinho'> Remover <br> do carrinho</button>"
    produto += "</div>"
    
    listaEle.innerHTML += produto
  }
}

loadCarrinho()

function removeProdutoCarrinho(p_idProduto){
    
    let dataProduto = new FormData();
    dataProduto.append("cpfUser", Token);
    dataProduto.append("idProduto", p_idProduto);

    fetch("../../backend/rmvProdutoCarrinho.php",{
        method: "POST",
        body: dataProduto,
    })

    loadCarrinho()

}
