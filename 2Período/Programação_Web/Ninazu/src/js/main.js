var Token = sessionStorage.getItem("loginToken"); // ^ Define o CPF(token) do usuario pelo sessionStorage

if (Token == null) {
  // ? Caso não exista um token, Redirecione para o login
  window.location.href = "login.html";
}
