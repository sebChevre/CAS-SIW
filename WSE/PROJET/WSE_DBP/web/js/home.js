var originData = [];
var svg;
var x,y;
var xAxis, yAxis;
var margin, height, width;
var tip;

/**
 * DOM ready
 */
$(function () {

    //récupération des données de population
    $.getJSON( "/population", function( data ) {

        //Iteration sur les données récupérés
        $.each( data.countries, function( pays ) {
            originData.push(data.countries[pays]);
        });

        initGui();
        initGraphZone();
        draw();

    });
});

/**
 * Initailisation des controles et events utilisateurs
 */
function initGui () {
    var nbreValeursSelection = $("#nombres_valeurs");
    var sensValeursSelection = $("#sens_valeurs");

    nbreValeursSelection.prop("selectedIndex", -1);
    sensValeursSelection.prop("selectedIndex", -1);

    nbreValeursSelection.on('change',function (){
        var sensValue = sensValeursSelection.find(":selected").val();
        if(sensValue || $(this).val() === 'all'){
            draw($(this).val());
        }

    });

    sensValeursSelection.on('change',function (){
        var nbreValue = nbreValeursSelection.find(":selected").val();
        if(nbreValue){
            draw(nbreValue,$(this).val())
        }
    });
}

/**
 * Initialisation de la zone de graphique
 */
function initGraphZone(){
    //marges de la zone de graphique
    margin = {top: 40, right: 20, bottom: 120, left: 100},
        width = 1200 - margin.left - margin.right,
        height = 700 - margin.top - margin.bottom;

    //formattage des valeurs de population
    formatPop = d3.format(",");

    //echelle des x --> noms des pays
    x = d3.scale.ordinal()
        .rangeRoundBands([0, width], .1);
    //echelle des y --> valeurs population
    y = d3.scale.linear()
        .range([height, 0]);

    //Axes x, y
    xAxis = d3.svg.axis()
        .scale(x)
        .orient("bottom");

    yAxis = d3.svg.axis()
        .scale(y)
        .orient("left")
        .tickFormat(formatPop);

    //Tooltip pour les barres
    tip = d3.tip()
        .attr('class', 'd3-tip')
        .offset([-10, 0])
        .html(function(d) {
            return "<strong>" + d.pays + '<strong><br/><strong>Population:</strong><span style=\'color:red\'>' + formatPop(d.population) + "</span>";
        })
    //Initialisation de la zone svg
    svg = d3.select("#barChartZone").append("svg")
        .attr("width", width + margin.left + margin.right)
        .attr("height", height + margin.top + margin.bottom)
        .append("g")
        .attr("transform", "translate(" + margin.left + "," + margin.top + ")");
    //application du tooltip
    svg.call(tip);

}

/**
 * Dessin et refresh du graphique proprement dits
 * @param nbValues le nombre de valeurs sélectionnées
 * @param sens le sens des valeurs que l'on veut afficher
 */
function draw(nbValues,sens) {

    //récupération en local des données à travailler
    var data = originData;

    //tri des données selon population
    data.sort(function(a,b){
        return b.population - a.population;
    });

    //Définition du nombres de valeurs à traiter
    if(nbValues){

        if(sens === '+'){
            data = data.slice(0,nbValues);
        }else{
            data = data.slice(data.length-nbValues,data.length)
        }

    }

    //on enlève les axes
    svg.select(".y.axis").remove();
    svg.select(".x.axis").remove();

    //on redéfinit le domaine des axes
    x.domain(data.map(function(d) { return d.pays; }));

    y.domain([0, d3.max(data, function(d) {
        return parseInt(d.population);
    })]);

    //on définit le svg
    svg.append("g")
        .attr("class", "x axis")
        .attr("transform", "translate(0," + height + ")")
        .call(xAxis)
        .selectAll("text")
        .style("text-anchor", "end")
        .attr("dx", "-.8em")
        .attr("dy", ".15em")
        .attr("transform", function(d) {
            return "rotate(-65)"
        });

    svg.append("g")
        .attr("class", "y axis")
        .call(yAxis);

    var bar = svg.selectAll(".bar")
        .data(data);

    bar.enter().append("rect")
        .attr("class", "bar")
        .attr("x", function(d) {
            return x(d.pays);
        })
        .attr("width", x.rangeBand())
        .attr("y", function(d) {
            return y(d.population);
        })
        .attr("height", function(d) {
            return height - y(d.population);
        })
        .on('mouseover', tip.show)
        .on('mouseout', tip.hide)
        .on('click',function () {alert('ok')})

    bar.exit().remove();

    bar
        .transition()
        .duration(750)
        .attr("y", function(d) {
            return y(d.population); })
        .attr("height", function(d) {
            return height - y(d.population); })
        .attr("x", function(d) {
            return x(d.pays);
        })
        .attr("width", x.rangeBand());

}


function type(d) {
    d.population = +d.population;
    console.log(d.population)
    return d;
}