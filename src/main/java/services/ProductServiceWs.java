package services;

import entities.Product;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.Serializable;
import java.util.List;

@WebService
public interface ProductServiceWs extends Serializable {
    @WebMethod
    List<Product> getProductsWs();

    @WebMethod
    Product getProductByIdWs(Long id);

    @WebMethod
    void saveOrUpdateProductWs(Product product);

    @WebMethod
    void deleteProductWs(Product product);

    @WebMethod
    Product getProductByTitleWs(String title);

    @WebMethod
    List<Product> findByCategoryWs(Long id);
}