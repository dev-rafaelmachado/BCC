const Token = sessionStorage.getItem("loginToken"); // ^ Define o CPF do usuario pelo sessionStorage

const fType = document.getElementById("formType"), // ^ Traz o elemento DOM do forumulario da categoria
  catalogo = document.getElementById("catalogo"), // ^ Traz o elemento DOM do Catalogo (sessão da pagina para colocar os produtos)
  typeELE = document.getElementById("typeID"); // ^ Traz o elemento DOM do Input da categoria

typesAceitos = ["Todas", "Alimentos", "Acessórios", "Vitaminas"]; // ^ Define um array com as categorias aceitas

if (Token == null) {
  // ? Caso não exista um token, Redirecione para o login
  window.location.href = "login.html";
}

function listarProdutos(){ 
  // & Traz todos os produtos do banco de dados

  data = new FormData(fType); // * Formata os dados

  // ~ Envia utilizando o metodo post os dados do input type para o Back-end
  fetch("../../backend/listarProdutos.php", {
    method: "POST",
    body: data,
  }).then(async (resp) => {
    // ~ [Promisse]
    const obj = await resp.json(); // ^ Espere a resposta chegar e guarde em objeto
    mostrarProdutos(obj); // * Envie o objeto com os produtos para a função que fara o Modal (colocar os produtos no HTML)
  });
}

function mostrarProdutos(content) {
  // & Coloca todos os produtos no HTML apartir de um objeto

  catalogo.innerHTML = ""; // Define o catalogo como vazio

  for (let index = 0; index < content.length; index++) {
    // ~ Passa por todos os produtos

    let produto = ""; // Cria/Limpa o produto
    let preco = content[index]["preco"]; // Guarda o preço em uma variavel
    preco = parseFloat(preco); preco = preco.toFixed(2) // Round 2
    preco = preco.replace(".", ","); // Altera o "." por uma ","

    // * -->-->- Cria um elemento HTML com todas os atributos do produto ->-->-- //
    produto += "<div class='card-produto'> ";
    produto +=
      "<div> <img src=" +
      content[index]["img_link"] +
      " alt='img-Produto'> </div>";
    produto += "<h2>" + content[index]["nome"] + " </h2> ";
    produto += "<h5> " + "R$ " + preco  + "</h5>";
    produto +=
      "<button onclick='adcProdutoCarrinho(" +
      content[index]["id_produto"] + 
      ")' type='button' class='bt-adcCarrinho'>Adicionar ao carrinho</button>";
    produto += "</div>";
    // * -->-->-->-->-- //

    catalogo.innerHTML += produto; // * Insere o produto dentro do catalogo
  }
}

listarProdutos(); // Lista os produtos pela 1º vez quando entra na página

// -->-->-->-->--#-->-->-->-->--#-->-->-->-->-- //

function verifiTypes(element) {
  // & Verifica se existe um input de categoria valido
  for (let index = 0; index < typesAceitos.length; index++) {
    // ~ Passa por todos as categorias aceitas
    if (element == typesAceitos[index]) {
      // ? Caso o input seja igual a uma categoria aceita
      return true;
    }
  }
  return false; // ? Caso não
}

function search() {
  // & Pesquisa os produtos baseado com a categoria inserida no input Categoria
  if (verifiTypes(typeELE.value)) {
    // ? Caso exista um input de categoria valida, pesquise e rotorne os dados
    listarProdutos();
  }
  return false; // - # - //
}

function adcProdutoCarrinho(p_idProduto) {
  document.getElementById('carrinho').src = "../../imgs/CarrinhoBullet.png"
  // & Adiciona um produto no carrinho apartir de seu ID

  // * Formata os dados
  let dataProduto = new FormData();
  dataProduto.append("cpfUser", Token);
  dataProduto.append("idProduto", p_idProduto);

  // ~ Envia utilizando o metodo post os dados do produto para o Back-end
  fetch("../../backend/adcProdutoCarrinho.php", {
    method: "POST",
    body: dataProduto,
  });
}
