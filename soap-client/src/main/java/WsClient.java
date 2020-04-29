import services.ProductService;
import services.ProductServiceWs;

import java.net.MalformedURLException;
import java.net.URL;

public class WsClient {
    public static void main(String[] args) throws MalformedURLException {
        System.setProperty("javax.xml.soap.SAAJMetaFactory", "com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl");
        URL wsUrl = new URL("http://localhost:8080/JavaEE8WebApp/ProductService/ProductServiceImpl?wsdl");
        ProductService productService = new ProductService(wsUrl);
        ProductServiceWs port = productService.getProductServiceImplPort();
        port.findAll().forEach(product -> System.out.println(product.getTitle()));
    }

}
