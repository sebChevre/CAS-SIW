package dbpedia.wse.test;

/**
 * Created by sce on 09.01.2015.
 */
public class DBPediaQuery {


    private static final String CARRIAGE_RETURN = "\n";
    public static final String DBPEDIA_ENDPOINT = "http://dbpedia.org/sparql";

    static final String getQueryfor(DBPediaQueryType queryType){

        switch(queryType){
            case SWISS_LOCALITY_AS_RESSOURCE:return swissLocality();
            case SWISS_LOCALITY_AS_MUNICIPALITY_NAME:return swissLocalityMunicipaliytName();

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
}
