
function gravar(){

    $.ajax({
        type: "POST",
        url: "../conexao.php",
        data: {
            "email": document.getElementById("email").value,
            "senha": document.getElementById("senha").value
        }
    });
}

function list(){
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "../listar.php",
        success: function (retorno) {
            console.log(retorno);
            

            var count = Object.keys(retorno).length
            for (let index = 0; index < count; index++) {
                var id = retorno[index]["id"]
                var email = retorno[index]["email"]
                var senha = retorno[index]["senha"]
                
                let IDhead = document.getElementById("thead")
                IDhead.innerHTML = '<th> ID </th><th> Email </th><th> Senha </th>'

                //console.log(id + email + senha)
                let idTable = document.getElementById("tbody")
                
                
                var valores = [id, email, senha]
                let tr = document.createElement("tr");

                for (let j = 0; j < 3; j++) {
                    let td = document.createElement("td");
                    td.classList.add('campo')
                    let valor = valores[j]
                    var valorIst = document.createTextNode(valor)
                    // console.log(valorIst)
                    td.appendChild(valorIst)
                    tr.appendChild(td)
                    idTable.appendChild(tr) 
                }
            }
        }
    });
}