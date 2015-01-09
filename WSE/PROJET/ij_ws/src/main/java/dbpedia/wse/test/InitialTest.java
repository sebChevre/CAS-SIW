package dbpedia.wse.test;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.impl.ResourceImpl;
import com.hp.hpl.jena.sparql.engine.http.QueryEngineHTTP;
/**
 * Created by sce on 09.01.2015.
 */
public class InitialTest {

    public static void main(String[] args) {

        System.setProperty("http.proxyHost", "proxy.ju.globaz.ch");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "proxy.ju.globaz.ch");
        System.setProperty("https.proxyPort", "8080");

        String sparqlEndpoint = "http://www.ebi.ac.uk/rdf/services/atlas/sparql";

        String sparqlQuery = "" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX atlasterms: <http://rdf.ebi.ac.uk/terms/atlas/>" +
                "SELECT distinct ?expressionValue ?pvalue \n" +
                "WHERE { \n" +
                "?value rdfs:label ?expressionValue . \n" +
                "?value atlasterms:pValue ?pvalue . \n" +
                "?value atlasterms:isMeasurementOf ?probe . \n" +
                "?probe atlasterms:dbXref ?uniprotAccession .\n" +
                "} \n" +
                "ORDER BY ASC(?pvalue)";


        Query query = QueryFactory.create(sparqlQuery, Syntax.syntaxARQ) ;
        // we want to bind the ?uniprotAccession variable in the query
        // to the URI for Q16850 which is http://purl.uniprot.org/uniprot/Q16850
        QuerySolutionMap querySolutionMap = new QuerySolutionMap();
        querySolutionMap.add("uniprotAccession", new ResourceImpl("http://purl.uniprot.org/uniprot/Q16850"));
        ParameterizedSparqlString parameterizedSparqlString = new ParameterizedSparqlString(query.toString(), querySolutionMap);

        QueryEngineHTTP httpQuery = new QueryEngineHTTP(sparqlEndpoint,parameterizedSparqlString.asQuery());
        // execute a Select query
        ResultSet results = httpQuery.execSelect();
        while (results.hasNext()) {
            QuerySolution solution = results.next();
            // get the value of the variables in the select clause
            String expressionValue = solution.get("expressionValue").asLiteral().getLexicalForm();
            String pValue = solution.get("pvalue").asLiteral().getLexicalForm();
            // print the output to stdout
            System.out.println(expressionValue + "\t" + pValue);
        }

    }
}
