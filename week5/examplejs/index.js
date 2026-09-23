let form = document.querySelector("#form");
form.addEventListener('submit', searchForPokemon);

function searchForPokemon(event) {
    event.preventDefault();

    let name = document.querySelector("#name");
    console.log("search for :" + name);

}