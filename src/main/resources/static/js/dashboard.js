window.addEventListener("load", function() {

  let note1 = {
      id: 10001,
      title: "Bobs Phone Number",
      date_create: "2022-01-10",
      date_edit: "2022-01-10",
      content: "212-555-3030",
      color: "#ffe599",
      xsize: 200,
      ysize: 180,
      xpos: 50,
      ypos: 50
    }

  let note2 = {
    id: 10002,
    title: "Walmart Shopping",
    date_create: "2022-01-05",
    date_edit: "2022-01-10",
    content: "- shampoo<br>- painkillers<br>- parmesan cheese<br>- paper towels",
    color: "#d5a6bd",
    xsize: 200,
    ysize: 180,
    xpos: 10,
    ypos: 10
  }

// const notesObj = {note1, note2};
  const notesRaw = `{
                      {
                        "id": 10001,
                        "title": "Bobs Phone Number",
                        "date_create": "2022-01-10",
                        "date_edit": "2022-01-10",
                        "content": "212-555-3030",
                        "color": "#ffe599",
                        "xsize": 200,
                        "ysize": 180,
                        "xpos": 20,
                        "ypos": 20
                      },
                      {
                        "id": 10002,
                        "title": "Walmart Shopping",
                        "date_create": "2022-01-05",
                        "date_edit": "2022-01-10",
                        "content": "- shampoo<br>- painkillers<br>- parmesan cheese<br>- paper towels",
                        "color": "#d5a6bd",
                        "xsize": 200,
                        "ysize": 180,
                        "xpos": 40,
                        "ypos": 40
                      },
                      {
                        "id": 10003,
                        "title": "Alices D&D character",
                        "date_create": "2022-01-03",
                        "date_edit": "2022-01-07",
                        "content": "Warlock Paladin<br>diety and patron the same - Corvea queen of ravens<br>|STR|12|<br>|DEX|9|<br>|CON|12|<br>|INT|10|<br>|WIS|13|<br>|CHA|16|",
                        "color": "#f9cb9c",
                        "xsize": 200,
                        "ysize": 180,
                        "xpos": 60,
                        "ypos": 60
                      },
                      {
                        "id": 10004,
                        "title": "Shopventory pwd",
                        "date_create": "2022-01-06",
                        "date_edit": "2022-01-08",
                        "content": "store@<br>!nV3nt0ry<br><br>team@<br>1NV3ntory<br><br>company@<br>!nV3nt0ry1",
                        "color": "#b4a7d6",
                        "xsize": 200,
                        "ysize": 180,
                        "xpos": 80,
                        "ypos": 80
                      },
                      {
                        "id": 10005,
                        "title": "",
                        "date_create": "2022-01-02",
                        "date_edit": "2022-01-02",
                        "content": "wand of flaming sphere<br>three daggers<br>six vials of black powder<br>hat of disguise",
                        "color": "#ea9999",
                        "xsize": 200,
                        "ysize": 180,
                        "xpos": 100,
                        "ypos": 100
                      }
                    }`;
    console.log(notesObj);

    let stringifiedObj = JSON.stringify(notesObj);
    console.log(stringifiedObj);

    let parsedObj = JSON.parse(stringifiedObj);
    console.log(parsedObj);


});