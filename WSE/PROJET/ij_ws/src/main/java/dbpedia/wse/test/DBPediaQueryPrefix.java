package dbpedia.wse.test;

/**
 * Created by sce on 09.01.2015.
 */
public enum DBPediaQueryPrefix {

    DB("PREFIX db: <http://dbpedia.org/resource/>"),
    ONTOLOGY("PREFIX onto: <http://dbpedia.org/ontology/>"),
    RDF("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"),
    DBPEDIA("PREFIX dbpedia: <http://dbpedia.org/>"),
    DBPEDIA_PROP("PREFIX dbpprop: <http://dbpedia.org/property/>"),
    DBPEDIA_RESSOURCE("PREFIX : <http://dbpedia.org/resource/>");

    public String prefix;

    DBPediaQueryPrefix(String prefix){
        this.prefix = prefix;
    }
}
