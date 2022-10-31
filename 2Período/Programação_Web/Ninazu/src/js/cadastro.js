const form = document.getElementById("formRegistro");

function verfValues(campo) {
  if (campo.value != "") {
    campo.style.border = "none";
    return false;
  }
  return true;
}

function cadastro() {
  // & Regex
  let verefi = 0;
  for (let index = 1; index < form.children.length - 1; index++) {
    if (verfValues(form.children[index])) {
      if (
        form.children[index].name != " " &&
        form.children[index].type != "button"
      )
        form.children[index].style.border = "1px red solid";
    } else {
      verefi++;
    }
  }
  if (verefi >= 5) {
    if (form.children["senha"].value != form.children["cfsenha"].value) {
      alert("Senha e Confirmar senha estão diferentes!");
    } else if (form.children["nome"].value.length > 50) {
      alert("Nome até 50 caracteres!");
    } else if (form.children["senha"].value.length > 20) {
      alert("Senha até 20 caracteres!");
    } else if (form.children["cpf"].value.length != 11) {
      alert("No CPF digite apenas os números. Ex: 00033355599");
    } else {
      // & POST
      const data = new FormData(form);
      fetch("../../backend/gravarCadastro.php", {
        method: "POST",
        body: data,
      }).then(async (resp) => {
        const obj = await resp.json();
        console.log(obj);
        if (obj["mensagem"] == "Gravado com sucesso") {
          window.location.href = "login.html";
        }
      });
    }
  }
}
