import services.ProductService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

public class ProductClient {
    public static void main(String[] args) {
        try {
            Context context = createInitialContext();
            ProductService productService = (ProductService) context.lookup("ejb:/JavaEEWebApp//ProductServiceImpl!ru.drsdgdby.ProductService");
            productService.getProducts().forEach(System.out::println);
        } catch (IOException | NamingException e) {
            e.printStackTrace();
        }
    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(ProductClient.class
                .getClassLoader()
                .getResourceAsStream("jndi.properties"));
        return new InitialContext(env);
    }
}
