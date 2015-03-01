var init = function() {
    $('.knapp').click(function() {
        alert("I am an alert box!");
    });

    var map = L.map('leaflet-kart', {
        maxZoom: 24,
        minZoom: 1,
        zoomControl: false,
        crs: L.CRS.Simple
    }).setView([0, 0], 1);

    map.setMaxBounds(new L.LatLngBounds([0,500], [500,0]));

    var imageUrl = 'http://i57.tinypic.com/2i8deac.png'
    var imageBounds = [[500,0], [0,370]];

    L.imageOverlay(imageUrl, imageBounds).addTo(map);
};

    $(document).ready(init);