 async function updatePage() {
    let response = await fetch('/counter', {method :'get'});


    let json = await response.json();
    console.log(json);
    document.getElementById("messageFromServer").innerHTML = json.message;

}
setInterval(updatePage, 1000)
