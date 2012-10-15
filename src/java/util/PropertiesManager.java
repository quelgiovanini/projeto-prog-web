package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author Prado
 */
public class PropertiesManager {
  private String fileName;
  
  public PropertiesManager(String fileName){
    this.fileName = fileName;
  }
  
  public void createPropertiesFile(HashMap dados) throws IOException{
    Properties props = new Properties();
    Set valores = dados.entrySet();
    Iterator it = valores.iterator();
    while(it.hasNext()){
      Map.Entry me = (Map.Entry) it.next();
      String chave = (String) me.getKey();
      String valor = (String) me.getValue();
      props.setProperty(chave, valor);
    }
    FileOutputStream out = new FileOutputStream(fileName);
    props.store(out, null);
    out.close();
  }
  
  public HashMap readPropertiesFile() throws IOException{
    Properties properties;
    StringTokenizer sToken;
    HashMap lista = new HashMap();
    int count=0;

    InputStream is = getClass().getResourceAsStream( fileName );
    properties = new Properties();
    properties.load( is );

    for (Enumeration list = properties.propertyNames(); list.hasMoreElements(); count++) {
        String entry = (String) list.nextElement();
        //System.out.println("entrada = " + entry);
        lista.put(entry, properties.getProperty(entry));
    }
    return lista;    
  }
}
