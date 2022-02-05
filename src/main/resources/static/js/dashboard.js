import notesRaw from "/js/testingNotes.js";

function drawNote(note, zindex) {
    console.log(note.id);

    let noteText = `<p class="noteTitle">${note.title}</p><p class="noteContent">${note.content}</p>`;

    let noteDiv = document.createElement("div");
    noteDiv.className = "note";
    noteDiv.style.backgroundColor = note.color;
    noteDiv.style.left = note.xpos;
    noteDiv.style.top = note.ypos;
    noteDiv.style.width = note.xsize;
    noteDiv.style.height = note.ysize;
    noteDiv.style.zindex = zindex;
    noteDiv.innerHTML = noteText;
    dashboardContainer.appendChild(noteDiv);
}

window.addEventListener("load", function() {

    const notesObj = JSON.parse(notesRaw);

    const htmlBody = document.getElementsByTagName("body")[0];
    const dashboardContainer = document.getElementById("dashboardContainer");

    let zindex = 100;

    for (let note of notesObj.notes) {
        drawNote(note, zindex);
        zindex = zindex + 10;
    }

});