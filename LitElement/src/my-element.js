// Archivo js
// My-element stander de web component 

// Pasos: 
// 1º npm init 
// 2º npm install lit-element
// 3º npm install -g polymer-cli
import { LitElement, html } from 'lit-element';

//Camel case 
class MyElement extends LitElement {

    // Como se debe representar un componente en el navegador
    render() {
        return html `
            <style>
                h2{
                    color:blue
                }
            </style>
            <h2> Ejemplo</h2>
            <p> Soy My Element y estoy perfectamente funcionando</p>
            <p> Llevo ${this.clics} clics</p>
            <button @click="${this.incrementar}"> Click aqui </button>
        `;
    }

    static get properties() {
        return {
            clics: { type: Number }
        };
    }

    constructor() {
        super(); // importante ponerlo

        this.clics = 0;

    }

    incrementar() {
        this.clics++;
    }
}
// registra un nuevo componente web (nombreElement, nombreClase)
customElements.define('my-element', MyElement);