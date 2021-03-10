const url = 'http://localhost:8080/work/';
const urlPost = 'http://localhost:8080/work/sendEmail';

document.addEventListener('DOMContentLoaded', () => {
    //console.log(nodeTree);
    console.log("AJAX Fetch Request: \n");
    document.getElementById("photo").addEventListener("mouseover", bigNameSet);
    document.getElementById("photo").addEventListener("mouseout", normalNameSet);
    let form = document.getElementById('form');
    form.addEventListener('submit', function(event) {
        /** Evitamos el envio cuando damos al submit */
        event.preventDefault();
        sendEmailByFetch(event);
    });

});

function sendEmailByFetch(e) {
    e.preventDefault()
    e.stopPropagation()
    const email = document.getElementById('email').value
    if (email != "") {
        //const password = document.getElementById('password').value
        var sendObject = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email })
        }

        console.log("objecto to send: ", sendObject);
        fetch(urlPost, sendObject)
            .then(data => data.text())
            .then(text => alert(text));
    } else {
        alert("Please write an email");
    }


}

function showMessage(message) {
    console.log(message);
}

function bigNameSet() {
    let element = document.getElementById("name");
    element.style.backgroundColor = "antiquewhite";
    element.style.fontStyle = "italic";
    //console.log("Image onmouseover");
}

function normalNameSet(x) {
    let element = document.getElementById("name");
    element.style.backgroundColor = "initial";
    element.style.fontStyle = "initial";
    //console.log("Image onmouseout");
}

/*------------------------- Peticion AJAX -----------*/
/** Con fetch   */


fetch(url)
    .then((resp) => resp.json())
    .then(function(data) {

        let table = document.getElementById("expericeTable");
        let body = table.getElementsByTagName('tbody')[0];

        //console.log("data response: ", data);
        let works = data;
        return works.map(function(work) {
            // Create row
            let newRow = body.insertRow();
            // Create td filling with proper data
            let year = newRow.insertCell();
            let company = newRow.insertCell();
            let job = newRow.insertCell();
            year.appendChild(document.createTextNode(work.year));
            company.appendChild(document.createTextNode(work.company));
            job.appendChild(document.createTextNode(work.job));
        })
    })
    .catch(function(error) {
        //console.log(error);
    });

/*var data = { username: 'example' };

fetch(url, {
        method: 'POST', // or 'PUT'
        body: JSON.stringify(data), // data can be `string` or {object}!
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
    .catch(error => console.error('Error:', error))
    .then(response => console.log('Success:', response));*/

/** FETCH
     * 
     *  let formEl = document.getElementById('contactForm');
    formEl.addEventListener('submit', function(event) {
        // 1. Setup the request
        // ================================
        // 1.1 Headers
        /*let headers = new Headers();
        // Tell the server we want JSON back
        headers.set('Accept', 'application/json');
*/
// 1.2 Form Data
// We need to properly format the submitted fields.
// Here we will use the same format the browser submits POST forms.
// You could use a different format, depending on your server, such
// as JSON or XML.
/*let formData = new FormData();
        for (let i = 0; i < formEl.length; ++i) {
            formData.append(formEl[i].name, formEl[i].value);
        }

        // This is for the purpose of this demo using jsFiddle AJAX Request endpoint
        //formData.append('json', JSON.stringify({ example: 'return value' }));

        var fetchOptions = {
            method: 'POST',
            headers,
            body: formData
        };

        // 2. Make the request
        // ================================

        console.log("REQUEST: ", fetchOptions);
        let email = document.getElementById("femail").value;

        var responsePromise = fetch(urlPost + "/" + email);

        // 3. Use the response
        // ================================
        responsePromise
        // 3.1 Convert the response into JSON-JS object.
            .then(function(response) {
                console.log(response);
                return response.json();
            })
            // 3.2 Do something with the JSON data
            .then(function(jsonData) {
                console.log(jsonData);
                console.log("The server has received  the email correclty!")
            });


        event.preventDefault();
    });
     */