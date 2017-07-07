package br.com.erichmantai.controller;

import br.com.erichmantai.model.business.Order;
import br.com.erichmantai.model.dao.OrderDAO;
import br.com.erichmantai.model.dao.PersonDAO;
import br.com.erichmantai.model.dao.ProductDAO;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author erichmantai
 */
@Named("orderBean")
@RequestScoped
public class OrderController extends AbstractController {

    @Inject
    private OrderDAO orderDAO;
    
    @Inject
    private PersonDAO personDAO;

    @Inject
    private ProductDAO productDAO;
    
    @Inject
    private Order order;

    public OrderController() {
        this.order = new Order();
    }

    public String save() {
        order.setPerson(personDAO.find(order.getPerson().getId()));
        order.setProduct(productDAO.find(order.getProduct().getId()));
        orderDAO.save(order);
        return "";
    }
    
    public List<Order> findAll() {
        return orderDAO.listAll();
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
