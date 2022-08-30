function addNumbers(X) {
    const nElements = document.querySelector("#inpt").value;
    const box = document.querySelector("#result");

    box.innerHTML = "";

    for (let num = X; num < nElements; num+=2) {
        box.innerHTML += "<div class='card'>" + num + "</div>"
    }
}