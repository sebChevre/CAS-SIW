package dbpedia;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by sce on 09.01.2015.
 */
public class DBPediaQuery {


    private static final String CARRIAGE_RETURN = "\n";
    public static final String DBPEDIA_ENDPOINT = "http://dbpedia.org/sparql";

    public static final String getQueryfor(DBPediaQueryType queryType) throws IOException, URISyntaxException {

        System.setProperty("http.proxyHost", "proxy.ju.globaz.ch");
        System.setProperty("http.proxyPort", "8080");

        switch(queryType){
            case SWISS_LOCALITY_AS_RESSOURCE:return swissLocality();

            case SWISS_LOCALITY_AS_MUNICIPALITY_NAME:return swissLocalityMunicipaliytName();

            case COUNTRY_POPULATION:return europeanCountryPopulation();

            default: throw new IllegalArgumentException("The type passed is not supported [" + queryType + "]");
        }
    }

    private static String swissLocality() {

        StringBuilder query = new StringBuilder();

        query.append(DBPediaQueryPrefix.DB.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.ONTOLOGY.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.RDF.prefix).append(CARRIAGE_RETURN);

        query.append("select distinct ?value where {").append(CARRIAGE_RETURN);
        query.append("?value rdf:type onto:Settlement .").append(CARRIAGE_RETURN);
        query.append("?value onto:country db:Switzerland").append(CARRIAGE_RETURN).append("}");

        System.out.println(query.toString());
        return query.toString();

    }

    private static String swissLocalityMunicipaliytName() {

        StringBuilder query = new StringBuilder();

        query.append(DBPediaQueryPrefix.DB.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.ONTOLOGY.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.RDF.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.DBPEDIA_RESSOURCE.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.DBPEDIA.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.DBPEDIA_PROP.prefix).append(CARRIAGE_RETURN);

        query.append("select distinct ?value where {").append(CARRIAGE_RETURN);
        query.append("?st rdf:type onto:Settlement .").append(CARRIAGE_RETURN);
        query.append("?st onto:country db:Switzerland .").append(CARRIAGE_RETURN);
        query.append("?st dbpprop:municipalityName ?value").append(CARRIAGE_RETURN).append("}");

        System.out.println(query.toString());
        return query.toString();

    }

    private static String europeanCountryPopulation() throws IOException, URISyntaxException {

        StringBuilder query = new StringBuilder();

       /* query.append(DBPediaQueryPrefix.OWL.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.XSD.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.RDFS.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.RDF.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.FOAF.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.DC.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.DBPEDIA_RESSOURCE.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.DBPEDIA.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.DBPEDIA_PROP.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.SKOS.prefix).append(CARRIAGE_RETURN);
        query.append(DBPediaQueryPrefix.YAGO.prefix).append(CARRIAGE_RETURN);

        query.append("select ?name ?population  where {").append(CARRIAGE_RETURN);
        query.append("?x a yago:EuropeanCountries .").append(CARRIAGE_RETURN);
        query.append("?x dbpprop:commonName ?name .").append(CARRIAGE_RETURN);
        query.append("OPTIONAL{?x dbpprop:populationDensityKm ?density }").append(CARRIAGE_RETURN);
        query.append("OPTIONAL{?x dbpprop:areaKm ?area}").append(CARRIAGE_RETURN);
        query.append("OPTIONAL{?x dbpedia-owl:populationTotal ?populationTotal }").append(CARRIAGE_RETURN);
        query.append("OPTIONAL{?x dbpprop:populationCensus ?popRecense }").append(CARRIAGE_RETURN);
        query.append("OPTIONAL{?x dbpprop:frTotalPopulationEstimate ?popEstimation }").append(CARRIAGE_RETURN);
        query.append("BIND(").append(CARRIAGE_RETURN);
        query.append("IF(bound(?populationTotal),").append(CARRIAGE_RETURN);
        query.append("xsd:integer(?populationTotal),").append(CARRIAGE_RETURN);
        query.append("IF(bound(?popRecense),").append(CARRIAGE_RETURN);
        query.append("xsd:integer(?popRecense),").append(CARRIAGE_RETURN);
        query.append("IF(bound(?popEstimation),").append(CARRIAGE_RETURN);
        query.append("xsd:integer(?popEstimation),").append(CARRIAGE_RETURN);
        query.append("xsd:integer(?density * ?area))").append(CARRIAGE_RETURN).append(")").append(")");
        query.append("as ?population)").append("}").append(CARRIAGE_RETURN);
        //query.append("order by asc (?name)");

        System.out.println(query.toString());
        return query.toString();*/

        ClassLoader classLoader = DBPediaQuery.class.getClassLoader();
        File file = new File(classLoader.getResource("rdf_query/country_test.rq").getFile());

        byte[] encoded = Files.readAllBytes(Paths.get(file.toURI()));
        String rdf = new String(encoded);
        System.out.println(rdf);
        return rdf;

    }
}
