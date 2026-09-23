async function onClick_CatFact() {
    let catFactParagraph = document.getElementById("cat-fact");
    let catFactReq = await fetch("https://meowfacts.herokuapp.com/");
    let parsedCatFact = await catFactReq.json();
    catFactParagraph.innerHTML = parsedCatFact.data[0];
}