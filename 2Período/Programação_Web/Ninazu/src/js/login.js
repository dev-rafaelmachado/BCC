const form = document.getElementById("formLogin");

function verfValues(campo) {
  if (campo.value != "") {
    campo.style.border = "none";
    return false;
  }
  return true;
}

function login() {
  // Regex
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
  if (verefi >= 3) {
    const data = new FormData(form);
    fetch("../../backend/login.php", {
      method: "POST",
      body: data,
    }).then(async (resp) => {
      const obj = await resp.json();
      if(obj == null){
        alert("Email e/ou senha incorretos")
      } else {
        sessionStorage.setItem('loginToken', obj.cpf);
        window.location.href = "main.html";
      }
    });
  }
}
