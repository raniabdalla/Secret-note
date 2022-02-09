window.addEventListener("load", function() {
    const colors = [
        "#d0e0e3", //Bluegray
        "#a9d5e3", //Bluelight
        "#7ebed2", //Blue
        "#ffdb91", //Yellow
        "#fec4ae", //Orange
        "#e9bad3" //Pink
    ];
    randomColor = colors[colors.length * Math.random() << 0];
    document.getElementById("notecolor").setAttribute("value", randomColor);
});