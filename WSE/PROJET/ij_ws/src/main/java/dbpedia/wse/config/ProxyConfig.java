package dbpedia.wse.config;

/**
 * Created by sce on 09.01.2015.
 */
public class ProxyConfig {

    public static final void defineProxy(){
        System.setProperty("http.proxyHost", "proxy.ju.globaz.ch");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "proxy.ju.globaz.ch");
        System.setProperty("https.proxyPort", "8080");
    }
}
