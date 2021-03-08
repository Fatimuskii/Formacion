/*let objetos = document.getElementsByTagName('body');
          for (let i = 0; i < objetos.length; i++) {
         console.log("Elemento: " + objetos[i]);
                                                }*/



document.addEventListener('DOMContentLoaded', () => {
    let nodeTree = getNodeTree(document.documentElement);
    //console.log(nodeTree);
    console.log("TREE NODE FOR MY CV: \n" + showTree(nodeTree, 1));
});



//console.log(showTree(nodeTree));

function getNodeTree(node) {

    if (node.hasChildNodes()) {
        let children = [];
        for (let i = 0; i < node.children.length; ++i) {
            children.push(getNodeTree(node.children[i]));
        }

        return {
            nodeName: node.nodeName,
            parentName: node.parentNode.nodeName,
            children: children
        };
    }
    return {
        nodeName: node.nodeName,
        parentName: node.parentNode.nodeName,
        children: null
    }
}

/*
function showTree(node, iteration) {
    if (!node) return "Error";
    let txt = "";

    txt += showSpaces(iteration) + "Node: " + node.nodeName + '\n';
    txt += showSpaces(iteration) + "Parent: " + node.parentName + '\n';

    if (node.children != null) {

        /*txt += "Content: " + node.content + '\n';
        for (let i = 0; i < node.children.length; ++i) {
            txt += showSpaces(iteration) + "Children: \n" + showSpaces(iteration) + showTree(node.children[i], iteration++) + "\n";
            iteration--;
        }


    } else {
        txt += showSpaces(iteration) + node.nodeName + " has no children\n";
    }

    return txt;
}*/

function showTree(node, iteration) {
    if (!node) return "Error";
    let txt = "";

    txt += showSpaces(iteration) + "Node: " + node.nodeName + '\n';
    if (node.children != null) {

        for (let i = 0; i < node.children.length; ++i) {
            iteration++;
            txt += showTree(node.children[i], iteration);
            iteration--;
        }

    }

    return txt;
}

function showSpaces(number) {

    let spaces = "";
    for (let i = 0; i < number; ++i) {
        spaces += "\t";
    }
    spaces += "-";

    return spaces;
}