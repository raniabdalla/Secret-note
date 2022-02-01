import notesRaw from "/js/testingNotes.js";

function drawNote(note) {
    console.log(note.id);

    let noteText = `<p class="noteTitle">${note.title}</p><p class="noteContent">${note.content}</p>`;

    let noteDiv = document.createElement("div");
    noteDiv.className = "note";
    noteDiv.style.backgroundColor = note.color;
    noteDiv.style.left = note.xpos;
    noteDiv.style.top = note.ypos;
    noteDiv.style.minwidth = note.xsize;
    noteDiv.style.minheight = note.ysize;
    noteDiv.innerHTML = noteText;
    dashboardContainer.appendChild(noteDiv);
}

window.addEventListener("load", function() {

    const notesObj = JSON.parse(notesRaw);

    const htmlBody = document.getElementsByTagName("body")[0];
    const dashboardContainer = document.getElementById("dashboardContainer");

    for (let note of notesObj.notes) {
        drawNote(note);
    }

});