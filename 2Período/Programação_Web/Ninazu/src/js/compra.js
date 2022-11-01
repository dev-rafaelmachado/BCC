var Token = sessionStorage.getItem("loginToken"), // ^ Define o CPF do usuario pelo sessionStorage
  tipoPag; // Cria a variavel tipo de pagamento

const valorTotal = sessionStorage.getItem("valorTotal"),
  ttPrecoELE = document.getElementById("ttPreco"),
  metdPagELE = document.getElementById("metdPag"),
  formCompELE = document.getElementById("formComp"),
  formCartao =
    "<div><input name='numCartao' type='text' placeholder='Número do Cartão'><input name='nomeTitular' type='text' placeholder='Nome do Titular'><input name='dataVencimento' type='text' placeholder='Data de Vencimento (MM/YY)'><input name='cvv'  type='text' placeholder='CVV'></div> <button type='button' class='btn-comp' onclick='comprar()'> Comprar </button>",
  formPIX =
    "<span class='pixCpCl'> <h2> Pix Copia e Cola: </h2> <p>00020126490014br.gov.bcb.pix0127pes.rafaelmachado@gmail.com5204000053039865802BR5919Rafael Leal Machado6009Sao Paulo62070503***6304F097</p>  <button type='button' class='btn-comp' onclick='comprar()'> Comprar </button> </span>";

if (Token == null) {
  // ? Caso não exista um token, Redirecione para o login
  window.location.href = "login.html";
}

ttPrecoELE.textContent = valorTotal;

metdPagELE.addEventListener("change", (event) => {
  event.preventDefault();

  if (metdPagELE.value == "Cartão de Crédito") {
    formCompELE.innerHTML = formCartao;
    tipoPag = "Cartão de Crédito";
  } else if (metdPagELE.value == "Pix") {
    formCompELE.innerHTML = formPIX;
    tipoPag = "Pix";
  }
});

// -->-->-->-->--#-->-->-->-->--#-->-->-->-->-- //

function verfValues(campo) {
  // & Função que verifica se o campo está preenchido

  if (campo.value != "") {
    campo.style.border = "none"; // * Define um Estilo para a borda do campo
    return false; // ! Caso esteja preenchido
  }
  return true; // ! Caso não esteja preenchido
}

function comprar() {
  // * Formatando Valor Total
  var valorTT = valorTotal;
  valorTT = valorTT.replace(",", ".");
  valorTT = valorTT.split(" ");

  if (tipoPag == "Cartão de Crédito") {
    console.log("TESTE");
    // * ->-->- REGEX ->-->- //
    let verefi = 0;
    for (let index = 0; index < 4; index++) {
      if (verfValues(formCompELE[index])) {
        // ? Caso não esteja preenchido
        formCompELE[index].style.border = "0.1px red solid";
      } else {
        // ? Caso esteja preenchido
        verefi++;
      }
    }
    if (verefi >= 4) {
      // * More Regex
      if (formCompELE[0].value.length != 19) {
        alert(
          "Número do cartão apenas os digitos com espaços. Ex: 1111 2222 3333 4444"
        );
      } else if (formCompELE[1].value.length > 50) {
        alert("Nome somente até 50 caracteres");
      } else if (
        formCompELE[2].value.length != 5 ||
        formCompELE[2].value[2] != "/"
      ) {
        alert("Data de Vencimento apenas mês e ano (MM/YY) Ex: 12/22");
      } else if (formCompELE[3].value.length != 3) {
        alert("CVV (Código de Segurança) são 3 digitos Ex: 123");
      } else {
        // & ->-->- POST ->-->- //

        // * Formata os dados
        const data = new FormData(formCompELE);
        data.append("cpfUser", Token);
        data.append("tipoPag", tipoPag);
        data.append("valorTT", parseFloat(valorTT[2]));

        // ~ Envia utilizando o metodo post os dados do formulario para o Back-end
        fetch("../../backend/gravarCompra.php", {
          method: "POST",
          body: data,
        }).then(async (resp) => {
          // ~ [Promisse]
          const obj = await resp.json(); // ^ Espere a resposta chegar e guarde em objeto

          if (obj["mensagem"] == "Gravado com sucesso") {
            // ? Caso o status code esteja positivo redirecione para a pagina main
            window.location.href = "main.html";
          }
        });
      }
    }
  } else {
    // * Formata os dados
    const data = new FormData();
    data.append("cpfUser", Token);
    data.append("tipoPag", tipoPag);
    data.append("valorTT", parseFloat(valorTT[2]));

    // ~ Envia utilizando o metodo post os dados cpf, tipoPag, valor Total para o Back-end
    fetch("../../backend/gravarCompra.php", {
      method: "POST",
      body: data,
    }).then(async (resp) => {
      // ~ [Promisse]
      const obj = await resp.json(); // ^ Espere a resposta chegar e guarde em objeto

      if (obj["mensagem"] == "Gravado com sucesso") {
        // ? Caso o status code esteja positivo redirecione para a pagina main
        window.location.href = "main.html";
      }
    });
  }
}
