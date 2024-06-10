package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Dto.DeliveryGetRequestDto;
import proyecto.grupal.lp.comidas.regionales.Entities.Delivery;

import java.util.List;

public interface IDeliveryService {

    List<Delivery> getAllDeliveries();
    DeliveryGetRequestDto getDeliveryById(Long id);
    void postDelivery(Delivery request);
    Delivery putDelivery(Delivery request, Long id);
    void deleteDelivery(Long id);

}
