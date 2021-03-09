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

function getWorkExperience() {
    let request = new XMLHttpRequest();
    let works = [];
    request.open('GET', 'http://localhost:8080/work/');
    request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //document.getElementById("demo").innerHTML = this.responseText;
            if (this.responseText) {
                works = JSON.parse(this.responseText);
                console.log("json parse: ", works);

                let table = document.getElementById("expericeTable");
                let body = table.getElementsByTagName('tbody')[0];
                for (let i = 0; i < works.length; ++i) {

                    let newRow = body.insertRow();
                    /** Create td */
                    var year = newRow.insertCell();
                    var company = newRow.insertCell();
                    var job = newRow.insertCell();
                    year.appendChild(document.createTextNode(works[i].year));
                    company.appendChild(document.createTextNode(works[i].company));
                    job.appendChild(document.createTextNode(works[i].job));

                }

            }


        }
    };
    request.send();
}