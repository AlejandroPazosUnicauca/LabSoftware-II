package co.unicauca.microkernel.plugins.argentina;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 *
 * @author diego
 */
public class ArgentinaDeliveryPlugin implements IDeliveryPlugin{

    /**
     * Calcular el costo de envío de un producto de la tienda enviado dentro de
     * México.
     *
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();

        double cost;

        //El peso del producto determina el costo.
        if (product.getWeight() <= 2 && product.getHeight() <= 5) {

            cost = 7;

        } else {

            //El peso adicional después de 2 kg se cobra a 0.5 por kilo.
            cost = 7 + (product.getWeight() - 2) * 0.5 + (product.getHeight() - 2) *0.5;

        }

        return cost;
    }
}
