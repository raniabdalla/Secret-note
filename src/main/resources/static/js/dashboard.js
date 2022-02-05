import notesRaw from "/js/testingNotes.js";

function drawNote(note, zindex) {
    console.log(note.id);

//    let rowDiv = document.createElement("div");
//    rowDiv.className = "row";
//
//    let noteAnchor = document.createElement("div")


    let noteText = `<p class="noteTitle">${note.title}</p><hr><p class="noteContent">${note.content}</p>`;

    let noteDiv = document.createElement("div");
    noteDiv.className = "col m-2 p-2";
    noteDiv.style.backgroundColor = note.color;
//    noteDiv.style.left = note.xpos;
//    noteDiv.style.top = note.ypos;
//    noteDiv.style.width = note.xsize;
    noteDiv.style.height = note.ysize;
//    noteDiv.style.zindex = zindex;
    noteDiv.innerHTML = noteText;



    dashboardContainer.appendChild(noteDiv);
}

window.addEventListener("load", function() {

    const notesObj = JSON.parse(notesRaw);

    const htmlBody = document.getElementsByTagName("body")[0];
    const dashboardContainer = document.getElementById("dashboardContainer");
    dashboardContainer.className = "row p-3";
//    dashboardContainer.appendChild()


    let zindex = 100;
    let i = 0;

    for (let note of notesObj.notes) {
        drawNote(note, zindex);
        zindex = zindex + 10;
    }

});