/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td_ws_sopa_consummer;

/**
 *
 * @author seb
 */
public class TD_WS_SOPA_CONSUMMER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TD_WS_SOPA_CONSUMMER.addMessage("sdsd","dasdasd","dasdad");
    }

    private static boolean addMessage(java.lang.String author, java.lang.String title, java.lang.String content) {
        td_ws_sopa_consummer.BlogWS_Service service = new td_ws_sopa_consummer.BlogWS_Service();
        td_ws_sopa_consummer.BlogWS port = service.getBlogWSPort();
        return port.addMessage(author, title, content);
    }
    
}
