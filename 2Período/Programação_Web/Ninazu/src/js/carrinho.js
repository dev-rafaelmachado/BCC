const Token = sessionStorage.getItem("loginToken"),
        listaEle = document.getElementById("lista"),
        ttPrecoELE = document.getElementById("TTpreco");

if(Token == null){
  window.location.href = "login.html";
}

function loadCarrinho(){
    let data = new FormData();
    data.append("cpfUser", Token);

    fetch("../../backend/listarCarrinho.php", {
    method: "POST",
    body: data,
    }).then(async (resp) => {
    const obj = await resp.json();
    console.log(obj);
    if(obj['status'] == "s"){
      mostrarProdutos(obj['Carrinho'])
    } else {
      listaEle.innerHTML = " <h4 class='CrrVazio'> Carrinho Vazio </h4> ";
      ttPrecoELE.textContent = " Total: 0,00"
    }
    });
}
function mostrarProdutos(content) {
  listaEle.innerHTML = "";
  ttPrecoELE.textContent = "";
  let precoTotal = 0.00;
  for (let index = 0; index < content.length; index++) {
    let produto = "";
    
    let preco = content[index]['preco']
    
    precoTotal += parseFloat(preco); 
    listaEle.innerHTML += produto
    
    preco = preco.replace('.',',')

    produto += "<div class='card-produto'>"
    produto += "<div>"
    produto += " <div class='imgDiv'> <img src='"+ content[index]['img_link'] +"' alt='PRODUTO'> </div>"
    produto += "<span>"
    produto += "<h2>"+ content[index]['nome'] +"</h2>"
    produto += "<h5> " + preco + "</h5>";
    produto += "<div class='qntd'>"
    produto += "<h3> Quantidade: </h3>"
    produto += "<input placeholder='Quantidade' type='number' value='"+ content[index]['quantidade'] +"'>"
    produto += "</div>"
    produto += "</span>"
    produto += "</div>"
    produto += "<button onclick='removeProdutoCarrinho(" + content[index]['id_produto'] + ")'> Remover <br> do carrinho</button>"
    produto += "</div>"

    listaEle.innerHTML += produto
  }
  let precoTotalStr = precoTotal.toString();
  precoTotalStr = precoTotalStr.replace('.',',')

  ttPrecoELE.textContent = " Total: " + precoTotalStr
}

loadCarrinho()

function removeProdutoCarrinho(p_idProduto){
    
    let dataProduto = new FormData();
    dataProduto.append("cpfUser", Token);
    dataProduto.append("idProduto", p_idProduto);

    fetch("../../backend/rmvProdutoCarrinho.php",{
        method: "POST",
        body: dataProduto,
    }).then(() => {
      loadCarrinho()
    });

}
