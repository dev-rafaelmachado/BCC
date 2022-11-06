const form = document.getElementById("formRegistro"); // ^ Traz o elemento DOM do formulário

function verfValues(campo) {
  // & Função que verifica se o campo está preenchido

  if (campo.value != "") {
    campo.style.border = "none"; // * Define um Estilo para a borda do campo
    return false; // ! Caso esteja preenchido
  }
  return true; // ! Caso não esteja preenchido
}

function cadastro() {
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
      // ? Caso não seja um campo
      verefi++;
    }
  }

  if (verefi >= 5) {
    // ? Caso todos os campos estejam preenchidos

    // * More Regex
    if (form.children["senha"].value != form.children["cfsenha"].value) {
      // ? Caso a senha e o confirmar senha sejam diferentes
      alert("Senha e Confirmar senha estão diferentes!");
    } else if (form.children["nome"].value.length > 50) {
      // ? Caso o nome esteja maior que 50
      alert("Nome até 50 caracteres!");
    } else if (form.children["senha"].value.length > 20) {
      // ? Caso a senha esteja maior que 20
      alert("Senha até 20 caracteres!");
    } else if (form.children["cpf"].value.length != 11) {
      // ? Caso o CPF não tenha 11 digitos
      alert("No CPF digite apenas os números. Ex: 00033355599");
    } else {
      // & ->-->- POST ->-->- //
      const data = new FormData(form); // * Formata os dados

      // ~ Envia utilizando o metodo post os dados do formulario para o Back-end
      fetch("../../backend/gravarCadastro.php", {
        method: "POST",
        body: data,
      }).then(async (resp) => {
        // ~ [Promisse]
        const obj = await resp.json(); // ^ Espere a resposta chegar e guarde em objeto

        if (obj["mensagem"] == "Gravado com sucesso") {
          // ? Caso o status code esteja positivo redirecione para a pagina de login
          window.location.href = "login.html";
        }
      });
    }
  }
}
