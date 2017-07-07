package br.com.erichmantai.model.dao;

import br.com.erichmantai.model.business.Order;

/**
 *
 * @author erichmantai
 */
public class OrderDAO extends AbstractDAO<Order> {

    public OrderDAO() {
        super(Order.class);
    }

}
