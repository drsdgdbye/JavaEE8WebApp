package services;

import entities.Category;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.Serializable;

@WebService
public interface CategoryServiceWs extends Serializable {
    @WebMethod
    void saveCategoryWs(Category category);
}
