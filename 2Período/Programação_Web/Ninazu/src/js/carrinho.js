const Token = sessionStorage.getItem("loginToken"), // ^ Define o CPF do usuario pelo sessionStorage
  listaEle = document.getElementById("lista"), // ^ Traz o elemento DOM da lista de produtos (sessão da pagina para colocar os produtos do carrinho)
  ttPrecoELE = document.getElementById("TTpreco"); // ^ Traz o elemento DOM que indica o preço total

var statsCarrinho; // Status para definir o estado do carrinho

if (Token == null) {
  // ? Caso não exista um token, Redirecione para o login
  window.location.href = "login.html";
}

// -->-->-->-->--#-->-->-->-->--#-->-->-->-->-- //

function loadCarrinho() {
  // & Traz todos os produtos do banco de dados do carrinho do usuario

  // * Formata os dados
  let data = new FormData();
  data.append("cpfUser", Token);

  // ~ Envia utilizando o metodo post os dados do usuario para o Back-end
  fetch("../../backend/listarCarrinho.php", {
    method: "POST",
    body: data,
  }).then(async (resp) => {
    // ~ [Promisse]
    const obj = await resp.json(); // ^ Espere a resposta chegar e guarde em objeto

    if (obj["status"] == "s") {
      // ? Caso o status code seja positivo, Mostre os produtos do carrinho na página HTML
      statsCarrinho = "Cheio";
      mostrarProdutos(obj["Carrinho"]);
    } else {
      // ? Caso o status code seja negativo, Escreva na página "Carrinho Vazio" e defina o preço total como "0,00"
      listaEle.innerHTML = " <h4 class='CrrVazio'> Carrinho Vazio </h4> ";
      statsCarrinho = "Vazio";
      ttPrecoELE.textContent = " Total: 0,00";
    }
  });
}

function mostrarProdutos(content) {
  // & Coloca todos os produtos do carrinho no HTML apartir de um objeto
  listaEle.innerHTML = ""; // Define a lista do carrinho como vazia
  ttPrecoELE.textContent = ""; // Define o preço total como vazio

  let precoTotal = 0.0; // ^ Cria uma variavel para calcular o preço total

  for (let index = 0; index < content.length; index++) {
    // ~ Passa por todos os produtos do carrinho

    let produto = ""; // Cria/Limpa o produto

    let preco = content[index]["preco"]; // Guarda o preço em uma variavel
    let quantidade = content[index]["quantidade"];
    preco = parseFloat(preco); preco = preco.toFixed(2) // Round 2
    precoTotal += parseFloat(preco) * parseInt(quantidade); // Soma o (preço * quantidade) ao preço total
    preco = preco.replace(".", ","); // Altera o "." por uma ","

    // * -->-->- Cria um elemento HTML com todas os atributos do produto do carrinho ->-->-- //
    produto += "<div class='card-produto'>";
    produto += "<div>";
    produto +=
      " <div class='imgDiv'> <img src='" +
      content[index]["img_link"] +
      "' alt='PRODUTO'> </div>";
    produto += "<span>";
    produto += "<h2>" + content[index]["nome"] + "</h2>";
    produto += "<h5> " + "R$ " + preco + "</h5>";
    produto += "<div class='qntd'>";
    produto += "<h3> Quantidade: </h3>";
    produto += "<span>" + quantidade + "</span>";
    produto +=
      "<button onclick='altQntd(" +
      content[index]["id_produto"] +
      ",1)'> + </button> <button onclick='altQntd(" +
      content[index]["id_produto"] +
      ",-1)'> – </button> ";
    produto += "</div>";
    produto += "</span>";
    produto += "</div>";
    produto +=
      "<button onclick='removeProdutoCarrinho(" +
      content[index]["id_produto"] +
      ")'> Remover <br> do carrinho</button>";
    produto += "</div>";
    // * -->-->-->-->-- //

    listaEle.innerHTML += produto; // * Insere o produto dentro da lista do carrinho
  }
  precoTotal = precoTotal.toFixed(2); // Arredodanda o valor totala para 2 casas decimais
  let precoTotalStr = precoTotal.toString(); // Transforma o preço para string para poder mudar os caracteres
  precoTotalStr = precoTotalStr.replace(".", ","); // Altera o "." por uma ","

  ttPrecoELE.textContent = " Total: R$ " + precoTotalStr ; // * Altera o preço total para a var precoTotalStr
}

loadCarrinho(); // Lista os produtos pela 1º vez quando entra na página

// -->-->-->-->--#-->-->-->-->--#-->-->-->-->-- //

function removeProdutoCarrinho(p_idProduto) {
  // & Adiciona um produto no carrinho apartir de seu ID

  // * Formata os dados
  let dataProduto = new FormData();
  dataProduto.append("cpfUser", Token);
  dataProduto.append("idProduto", p_idProduto);

  // ~ Envia utilizando o metodo post os dados do produto e do CPF do usuario para o Back-end
  fetch("../../backend/rmvProdutoCarrinho.php", {
    method: "POST",
    body: dataProduto,
  }).then(() => {
    // ~ [Promisse]
    loadCarrinho(); // Carregue os produtos novamente
  });
}

function altQntd(p_idProduto, operação) {
  // & Altera a quantidade de um produto especifico (mais ou menos)

  // * Formata os dados
  let dataProduto = new FormData();
  dataProduto.append("cpfUser", Token);
  dataProduto.append("idProduto", p_idProduto);
  dataProduto.append("operacao", operação);

  // ~ Envia utilizando o metodo post os dados do produto, do CPF do usuario e da operação na quantidade para o Back-end
  fetch("../../backend/altQuantidade.php", {
    method: "POST",
    body: dataProduto,
  }).then(() => {
    // ~ [Promisse]
    loadCarrinho(); // Carregue os produtos novamente
  });
}

// -->-->-->-->--#-->-->-->-->--#-->-->-->-->-- //

function finalizarCompra() {
  if (statsCarrinho == "Vazio") {
    // ? Caso o carrinho ainda esteja vazio, alerte o usuário.
    alert("O Carrinho ainda está vazio, adicione alguns produtos");
  
  } else {
    valorTotal = ttPrecoELE.textContent
    sessionStorage.setItem("valorTotal", valorTotal);
    window.location.href = "compra.html";
  }
}
