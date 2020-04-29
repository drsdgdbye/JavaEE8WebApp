package rest;

import entities.Product;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/products")
public interface ProductServiceRs {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> getProductsRs();

    @GET
    @Path("/{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    Product getProductByIdRs(@PathParam("id") Long id);

    @PUT
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    void saveOrUpdateProductRs(Product product);

    @DELETE
    @Path("/delete")
    void deleteProductRs(Product product);

    @GET
    @Path("/{title}/title")
    @Produces(MediaType.APPLICATION_JSON)
    Product getProductByTitleRs(@PathParam("title") String title);

    @GET
    @Path("/{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> findByCategoryRs(@PathParam("id") Long id);
}
