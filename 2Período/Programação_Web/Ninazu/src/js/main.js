var Token = sessionStorage.getItem('loginToken');
console.log("Token: " + Token)

if(Token == null){
    window.location.href = "login.html";
}