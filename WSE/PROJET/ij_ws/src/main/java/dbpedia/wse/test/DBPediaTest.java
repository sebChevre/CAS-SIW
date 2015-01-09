package dbpedia.wse.test;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.sparql.engine.http.QueryEngineHTTP;
import dbpedia.wse.config.ProxyConfig;

/**
 * Created by sce on 09.01.2015.
 */
public class DBPediaTest {

    public static void main(String[] args) {

        ProxyConfig.defineProxy();

        Query query = QueryFactory.create(DBPediaQuery.getQueryfor(DBPediaQueryType.SWISS_LOCALITY_AS_MUNICIPALITY_NAME), Syntax.syntaxSPARQL) ;

        QueryEngineHTTP httpQuery = new QueryEngineHTTP(DBPediaQuery.DBPEDIA_ENDPOINT,query);

        ResultSet results = httpQuery.execSelect();

        while (results.hasNext()) {
            QuerySolution solution = results.next();
            // get the value of the variables in the select clause
            //String expressionValue = solution.get("expressionValue").asLiteral().getLexicalForm();
            String value = solution.get("value").toString();
            // print the output to stdout
            System.out.println(value);
        }
    }
}
