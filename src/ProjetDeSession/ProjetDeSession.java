

package ProjetDeSession;
/**
 *
 * @author YOUSSEF
 */
public class ProjetDeSession {

    public static void main(String[] args) throws Exception {
        reclamationDoc reclamations = new reclamationDoc("src/XML/inputfile.xml");
      
       reclamations.execution();
       
       reclamations.saveToFile("src/XML/refunds.xml");
}
}
