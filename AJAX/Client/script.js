/*------------------------------ 1ra opcion ---------*/
document.addEventListener('DOMContentLoaded', () => {
    //console.log(nodeTree);
    console.log("AJAX HTTML REQUEST: \n");
    document.getElementById("photo").addEventListener("mouseover", bigNameSet);
    document.getElementById("photo").addEventListener("mouseout", normalNameSet);

    getWorkExperience();
});

/*------------------------------ 2da opcion ---------*/
function bigNameSet() {
    let element = document.getElementById("name");
    element.style.backgroundColor = "antiquewhite";
    element.style.fontStyle = "italic";
    console.log("Image onmouseover");
}

function normalNameSet(x) {
    let element = document.getElementById("name");
    element.style.backgroundColor = "initial";
    element.style.fontStyle = "initial";
    console.log("Image onmouseout");
}

/*-------------------------Peticion AJAX -----------*/
/** http request  */
function getWorkExperience() {
    let request = new XMLHttpRequest();
    let works = [];
    request.open('GET', 'http://localhost:8080/work/');
    request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText) {
                works = JSON.parse(this.responseText);
                console.log("json parse: ", works);

                let table = document.getElementById("expericeTable");
                let body = table.getElementsByTagName('tbody')[0];
                for (let i = 0; i < works.length; ++i) {
                    // Create row
                    let newRow = body.insertRow();
                    // Create td filling with proper data
                    let year = newRow.insertCell();
                    let company = newRow.insertCell();
                    let job = newRow.insertCell();
                    year.appendChild(document.createTextNode(works[i].year));
                    company.appendChild(document.createTextNode(works[i].company));
                    job.appendChild(document.createTextNode(works[i].job));
                }

            }
        }
    };
    request.send();
}