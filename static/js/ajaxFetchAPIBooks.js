 function fetchBooks() {
  fetch('/books', {method :'get'}).
      then(res => res.json()).
      then(data => {
            var jsonArr = data.books;
        	let i = 0
        	let str = '';
            while (i < jsonArr.length) {
                  str = str + jsonArr[i].title + ' by ' + jsonArr[i].author + '<br>';
                  i++;
            }
            document.getElementById("books").innerHTML = str;
       }).
      catch(err => {
        console.log(err);
      });
}