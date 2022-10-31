
var     Token = sessionStorage.getItem('loginToken');
const   fType = document.getElementById('formType'),
        catalogo = document.getElementById('catalogo'),
        typeELE = document.getElementById("typeID")
        typesAceitos = ["Todas","Alimentos","Acessórios","Roupas"];


console.log("Token: " + Token)


if(Token == null){
    window.location.href = "http://192.168.1.2/Ninazu/src/html/login.html";
}

function listarProdutos() {
    data = new FormData(fType);
    fetch("../../backend/listarProdutos.php", {
        method: "POST",
        body: data,
      }).then(async (resp) => {
        const obj = await resp.json();
        mostrarProdutos(obj)
      });
}

function mostrarProdutos(content){
    catalogo.innerHTML = ""
    for (let index = 0; index < content.length; index++) {
        let produto = ""

        let preco = content[index]['preco']
        preco = preco.replace('.',',')
        produto += "<div class='card-produto'> ";
        produto += "<div> <img src="+ content[index]['img_link'] + " alt='img-Produto'> </div>";
        produto += "<h2>" + content[index]['nome'] +  " </h2> ";
        produto += "<h5> " + preco + "</h5>";
        produto += "<button onclick='adcProdutoCarrinho(" + content[index]['id_produto'] + ")' type='button' class='bt-adcCarrinho'>Adicionar ao carrinho</button>";
        produto += "</div>";
        catalogo.innerHTML += produto
    }

}

function verifiTypes(element){
    for (let index = 0; index < typesAceitos.length; index++) {
        if (element == typesAceitos[index]) {
            return true
        }
    }
    return false
}

function search(){
    if (verifiTypes(typeELE.value)) {
        listarProdutos()
    }
    return false;
}

listarProdutos()


function adcProdutoCarrinho(p_idProduto){

    let dataProduto = new FormData();
    dataProduto.append("cpfUser", Token);
    console.log(Token)
    dataProduto.append("idProduto", p_idProduto);
    console.log(p_idProduto)

    fetch("../../backend/adcProdutoCarrinho.php",{
        method: "POST",
        body: dataProduto,
    })
}