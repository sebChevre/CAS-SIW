import com.google.gson.Gson;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.sparql.engine.http.QueryEngineHTTP;
import dbpedia.DBPediaQuery;
import dbpedia.DBPediaQueryType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

/**
 * Created by sce on 15.01.2015.
 */
@WebServlet(name="population", urlPatterns = "/population")
public class PopulationServlet extends HttpServlet{


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Query query = null;
        try {
            query = QueryFactory.create(DBPediaQuery.getQueryfor(DBPediaQueryType.COUNTRY_POPULATION), Syntax.syntaxSPARQL);
        } catch (URISyntaxException e) {
            throw new ServletException("Exception during rdf query");
        }

        //  QueryExecution qExe = QueryExecutionFactory.sparqlService( "http://dbpedia.org/sparql", query );
        // ResultSet results = qExe.execSelect();

        QueryEngineHTTP httpQuery = new QueryEngineHTTP(DBPediaQuery.DBPEDIA_ENDPOINT,query);
        ResultSet results = httpQuery.execSelect();
        //ResultSetFormatter.out(System.out, results, query) ;


/*
        QueryEngineHTTP httpQuery = new QueryEngineHTTP(DBPediaQuery.DBPEDIA_ENDPOINT,query);

        ResultSet results = httpQuery.execSelect();
*/
        Countries countries = new Countries();

        while (results.hasNext()) {
            QuerySolution solution = results.next();
            // get the value of the variables in the select clause
            //String expressionValue = solution.get("expressionValue").asLiteral().getLexicalForm();
            String name = solution.get("name").toString().split("@")[0];
            //Literal population = solution.get("population").asLiteral();
            Literal population = solution.get("population").asLiteral();
            //Literal area = solution.get("area").asLiteral();
            //Literal density = solution.get("density").asLiteral();
            // print the output to stdout
            countries.addCountry(new Country(name,new Long(population.getLong()).toString()));
        }

        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();

        Gson gson = new Gson();

        String json = gson.toJson(countries);

        System.out.print(json);

        writer.print(json);


    }
}
