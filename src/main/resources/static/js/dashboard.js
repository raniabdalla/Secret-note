let notesRaw = '{
                  "notes" : [
                    {
                      "id": 10001,
                      "title": "Bobs Phone Number",
                      "date_create": "2022-01-10",
                      "date_edit": "2022-01-10",
                      "content": "212-555-3030",
                      "color": "#ffe599"
                    },
                    {
                      "id": 10002,
                      "title": "Walmart Shopping",
                      "date_create": "2022-01-05",
                      "date_edit": "2022-01-10",
                      "content": "- shampoo<br>- painkillers<br>- parmesan cheese<br>- paper towels",
                      "color": "#d5a6bd"
                    },
                    {
                      "id": 10003,
                      "title": "Alices D&D character",
                      "date_create": "2022-01-03",
                      "date_edit": "2022-01-07",
                      "content": "Warlock Paladin<br>diety and patron the same - Corvea queen of ravens<br>|STR|12|<br>|DEX|9|<br>|CON|12|<br>|INT|10|<br>|WIS|13|<br>|CHA|16|",
                      "color": "#f9cb9c"
                    },
                    {
                      "id": 10004,
                      "title": "Shopventory pwd",
                      "date_create": "2022-01-06",
                      "date_edit": "2022-01-08",
                      "content": "store@<br>!nV3nt0ry<br><br>team@<br>1NV3ntory<br><br>company@<br>!nV3nt0ry1",
                      "color": "#b4a7d6"
                    },
                    {
                      "id": 10005,
                      "title": "x",
                      "date_create": "2022-01-02",
                      "date_edit": "2022-01-02",
                      "content": "wand of flaming sphere<br>three daggers<br>six vials of black powder<br>hat of disguise",
                      "color": "#ea9999"
                    }
                  ]
                }';

let newJSONobj = '{"name":"John","cars":{"mycar":"ford","borrowedcar":"audi"}}';

let notesObj = JSON.parse(notesRaw);
