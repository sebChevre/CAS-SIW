package mas.wse.rdf;

import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.vocabulary.FOAF;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;
import org.openrdf.model.vocabulary.XMLSchema;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.config.RepositoryConfigException;
import org.openrdf.repository.manager.RemoteRepositoryManager;

public class EX3_4 {

	static RepositoryConnection connection;
	
	public static void main(String args[]) throws RepositoryException, RepositoryConfigException{
		Repository rep = initializeRepoRemote();
		connection = rep.getConnection();

		String namespace = "http://james_bond.eia-fr.ch/";
		ValueFactory fctory = rep.getValueFactory();
		
		//personnes
		URI eve = fctory.createURI(namespace,"eve");
		connection.add(eve, RDF.TYPE, FOAF.PERSON);
		connection.add(eve, RDFS.LABEL,fctory.createLiteral("Eve Moneypenny",XMLSchema.STRING));
		
		URI auric = fctory.createURI(namespace,"auric");
		connection.add(auric, RDF.TYPE, FOAF.PERSON);
		connection.add(auric, RDFS.LABEL,fctory.createLiteral("Auric Goldfinger",XMLSchema.STRING));
		
		URI ernst = fctory.createURI(namespace,"ernst");
		connection.add(ernst, RDF.TYPE, FOAF.PERSON);
		connection.add(ernst, RDFS.LABEL,fctory.createLiteral("Ernst Stavo Blofeld",XMLSchema.STRING));
		
		URI white = fctory.createURI(namespace,"white");
		connection.add(white, RDF.TYPE, FOAF.PERSON);
		connection.add(white, RDFS.LABEL,fctory.createLiteral("Bill White",XMLSchema.STRING));
		
		URI greene = fctory.createURI(namespace,"greene");
		connection.add(greene, RDF.TYPE, FOAF.PERSON);
		connection.add(greene, RDFS.LABEL,fctory.createLiteral("Dominique Greene",XMLSchema.STRING));
		
		URI mitch = fctory.createURI(namespace,"mitch");
		connection.add(mitch, RDF.TYPE, FOAF.PERSON);
		connection.add(mitch, RDFS.LABEL,fctory.createLiteral("Craig Mitchell",XMLSchema.STRING));
		
		URI me = fctory.createURI(namespace,"me");
		connection.add(me, RDF.TYPE, FOAF.PERSON);
		connection.add(me, RDFS.LABEL,fctory.createLiteral("James Bond",XMLSchema.STRING));
		
		//organisation
		URI mi6 = fctory.createURI(namespace,"mi6");
		connection.add(mi6, RDF.TYPE, FOAF.ORGANIZATION);
		connection.add(mi6, RDFS.LABEL,fctory.createLiteral("Secret Intelligence Service",XMLSchema.STRING));
		
		//groupe
		URI badguys = fctory.createURI(namespace,"badguys");
		connection.add(badguys, RDF.TYPE, FOAF.GROUP);
		
		//knows
		connection.add(me, FOAF.KNOWS, white);
		connection.add(me, FOAF.KNOWS, ernst);
		connection.add(me, FOAF.KNOWS, auric);
		connection.add(me, FOAF.KNOWS, eve);
		
		connection.add(eve, FOAF.KNOWS, me);
		
		
		//mi6
		connection.add(me, FOAF.MEMBER, mi6);
		connection.add(eve, FOAF.MEMBER, mi6);
		
		//badguys
		connection.add(auric,FOAF.MEMBER, badguys);
		connection.add(ernst,FOAF.MEMBER, badguys);
		connection.add(greene,FOAF.MEMBER, badguys);
		
		
		
		
		
		
		
		connection.close();
	}
	
	
	
	
	static Repository initializeRepoRemote() throws RepositoryException, RepositoryConfigException{
		String serverUrl = "http://localhost:8080/openrdf-sesame";
		RemoteRepositoryManager manager = new RemoteRepositoryManager(serverUrl);
		manager.initialize();
		
		Repository repo = manager.getRepository("MAS_WSE");
		repo.initialize();
		return repo;
		
	}
}
