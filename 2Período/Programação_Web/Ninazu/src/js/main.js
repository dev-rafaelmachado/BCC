var Token = sessionStorage.getItem('loginToken');
console.log("Token: " + Token)

if(Token == null){
    window.location.href = "http://192.168.1.2/Ninazu/src/html/login.html";
}