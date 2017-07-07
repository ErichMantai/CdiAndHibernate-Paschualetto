package br.com.erichmantai.controller;
import br.com.erichmantai.model.business.Product;
import br.com.erichmantai.model.dao.ProductDAO;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author erichmantai
 */
@Named("productBean")
@RequestScoped
public class ProductController extends AbstractController {

    @Inject
    private ProductDAO productDAO;

    @Inject
    private Product product;

    public String save() {
        productDAO.save(product);
        return "";
    }

    public List<Product> findAll() {
        return productDAO.listAll();
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
