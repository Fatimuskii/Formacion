//import {Student} from './WebPage.js'
//import { WebWindow, WebDocument } from './libraries/ROOADFExtension_WebProjects/WebProjects.js'



export function SayHello() :void {
  console.log("Running module's exported code whenever module is already loaded.\nCompiled at the server.");
}
export function Welcome() :void {
  console.log("Running module's exported code once page has been loaded.\nCompiled at the server.");
}

document.addEventListener('DOMContentLoaded',
      (event) => 
      {
        var Method_ = "DOM Content. Loaded event.";
        var HTMLDivE :HTMLDivElement;
        
        console.log(Method_);

        console.log( Method_ + " Dynamic Content. Creating...");
        HTMLDivE = WebPage_GetDynamicContent();
        console.log( Method_ + " Dynamic Content. Created.");

        console.log( Method_ + " Dynamic Content. Appending...");
        document.body.appendChild(HTMLDivE);
        console.log( Method_ + " Dynamic Content. Appended.");

        Welcome();
      }
  );

function WebPage_GetDynamicContent() :HTMLDivElement {
  var HTMLDivE :HTMLDivElement;
  var HTMLAnchorE :HTMLAnchorElement;
  var HTMLUListE :HTMLUListElement;
  var HTMLUListIE_01 :HTMLLIElement;
  var HTMLUListIE_02 :HTMLLIElement;
  var HTMLUListIE_03 :HTMLLIElement;
  var HTMLUListIE_04 :HTMLLIElement;
  var HTMLElementContent :string;
  
  //let user = "Jane User IX";
  //let user = [0, 1, 2];
  //let user = { firstName: "Jane", lastName: "User" };
  //let user = new Student("Sierras", "", "D.");

  //HTMLElementContent = "<p>Welcome to the PoC Project's Menu. For any questions contact <a>" + user.fullName + "</a></p>"
  HTMLElementContent += "<p>Current time ["+ new Date().toISOString() + "].</p>";

  /* Div Element */
  HTMLDivE = document.createElement('div');
  HTMLDivE.innerHTML = HTMLElementContent;

  /* Unordered List Element */
  HTMLUListE = document.createElement('ul');


  /* List Item 01 Element */
  HTMLUListIE_01 = document.createElement('li');

  HTMLAnchorE = document.createElement('a');
  HTMLAnchorE.href = 'Test.GUIControls.html';
  HTMLAnchorE.textContent = "GUI Controls";
  HTMLAnchorE.target = "_Blank";

  HTMLUListIE_01.appendChild(HTMLAnchorE);

  /* List Item 02 Element */
  HTMLUListIE_02 = document.createElement('li');

  HTMLAnchorE = document.createElement('a');
  HTMLAnchorE.href = 'Test.ObjectDesigner.GUI.html';
  HTMLAnchorE.textContent = "Object Designer";
  HTMLAnchorE.target = "_Blank";

  HTMLUListIE_02.appendChild(HTMLAnchorE);

    /* List Item 03 Element */
    HTMLUListIE_03 = document.createElement('li');

    HTMLAnchorE = document.createElement('a');
    HTMLAnchorE.href = 'Test.APIRequest.html';
    HTMLAnchorE.textContent = "OpenHAB API Request";
    HTMLAnchorE.target = "_Blank";
  
    HTMLUListIE_03.appendChild(HTMLAnchorE);

  /* List Item 04 Element */
  HTMLUListIE_04 = document.createElement('li');

  HTMLAnchorE = document.createElement('a');
  HTMLAnchorE.href = 'Test.Websockets.html';
  HTMLAnchorE.textContent = "WebSockets PoC";
  HTMLAnchorE.target = "_Blank";

  HTMLUListIE_04.appendChild(HTMLAnchorE);


  /* Unordered List Element Items */
  
  HTMLUListE.appendChild(HTMLUListIE_01);
  HTMLUListE.appendChild(HTMLUListIE_02); 
  HTMLUListE.appendChild(HTMLUListIE_03);
  HTMLUListE.appendChild(HTMLUListIE_04);


  /* DIV Element */
  HTMLDivE.appendChild(HTMLUListE);
  //HTMLDivE.style.cssText = 'position:absolute;width:100%;height:100%;opacity:0.3;z-index:100;background:#000';
  
  return HTMLDivE;
}

console.log("Module [TypescriptPoC_02]. Loaded.");