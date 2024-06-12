package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Delivery;

import java.util.List;
import java.util.Optional;

public interface IDeliveryService {

    List<Delivery> getAllDeliveries();
    Optional<Delivery> getDeliveryById(Long id);
    void postDelivery(Delivery request);
    Delivery putDelivery(Delivery request, Long id);
    void deleteDelivery(Long id);

}
