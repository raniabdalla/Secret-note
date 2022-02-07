function drawNote(note, zindex) {

//    let rowDiv = document.createElement("div");
//    rowDiv.className = "row";
//
//    let noteAnchor = document.createElement("div")

    var randomColor = function (obj) {
        var keys = Object.keys(obj);
        return obj[keys[ keys.length * Math.random() << 0]];
    };

    let noteText = `<div class="noteName">${note.name}</div><hr><p class="noteContent">${note.content}</p>`;

    let noteDiv = document.createElement("div");
    noteDiv.className = "col m-2 p-2 noteDrag";
    noteDiv.style.backgroundColor = randomColor(Colors);
//    noteDiv.style.left = note.xpos;
//    noteDiv.style.top = note.ypos;
//    noteDiv.style.width = note.xsize;
    noteDiv.style.height = note.ysize;
//    noteDiv.style.zindex = zindex;
    noteDiv.innerHTML = noteText;



    dashboardContainer.appendChild(noteDiv);
}



const Colors = {
    Bluegray: "#d0e0e3",
    Bluelight: "#a9d5e3",
    Blue: "#7ebed2",
    Yellow: "#ffdb91",
    Orange: "#fec4ae",
    Pink: "#e9bad3"
}

window.addEventListener("load", function() {

    console.log(notes);

    const htmlBody = document.getElementsByTagName("body")[0];
    const dashboardContainer = document.getElementById("dashboardContainer");
    dashboardContainer.className = "row p-3";
//    dashboardContainer.appendChild()


    let zindex = 100;
    let i = 0;

    for (let note of notes) {
        drawNote(note, zindex);
        zindex = zindex + 10;
    }

});