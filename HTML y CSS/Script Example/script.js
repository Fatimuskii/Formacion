document.addEventListener('DOMContentLoaded', () => {
    let nodeTree = getNodeTree(document.documentElement);
    //console.log(nodeTree);
    console.log("TREE NODE FOR MY CV: \n" + showTree(nodeTree, 0));
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
            children: children
        };
    }
    return {
        nodeName: node.nodeName,
        children: null
    }
}

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