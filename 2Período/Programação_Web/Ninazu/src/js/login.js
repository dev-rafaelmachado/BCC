const form = document.getElementById("formLogin"); // ^ Traz os dados do DOM do formulário

function verfValues(campo) {
  // & Função que verifica se o campo está preenchido

  if (campo.value != "") {
    campo.style.border = "none"; // * Define um Estilo para a borda do campo
    return false; // ! Caso esteja preenchido
  }
  return true; // ! Caso não esteja preenchido
}

function login() {
  // * ->-->- REGEX ->-->- //
  
  let verefi = 0;
  for (let index = 1; index < form.children.length - 1; index++) {
    // ~ Verifica se todos os campos estáo preenchidos

    if (verfValues(form.children[index])) {
      // ? Caso não esteja preenchido
      if (
        form.children[index].name != " " &&
        form.children[index].type != "button"
      ) {
        // ? Caso seja um campo
        form.children[index].style.border = "1px red solid";
      }
    } else {
      // ? Caso esteja preenchido
      verefi++;
    }
  }

  if (verefi >= 2) {
    // ? Caso todos os campos estejam preenchidos

    const data = new FormData(form); // * Formata os dados

    // ~ Envia utilizando o metodo post os dados do formulario para o Back-end
    fetch("../../backend/login.php", {
      method: "POST",
      body: data,
    }).then(async (resp) => {
      // ~ [Promisse]
      const obj = await resp.json(); // ^ Espere a resposta chegar e guarde em objeto

      if (obj.status == "n") {
        // ? Caso não exista um retorno, Alerte para o usuario
        alert("Email e/ou senha incorretos");
      } else {
        // ? Caso exista, salve o cpf e redirecione para o main page
        sessionStorage.setItem("loginToken", obj.cpf);
        window.location.href = "main.html";
      }
    });
  }
}
