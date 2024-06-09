package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Delivery;
import proyecto.grupal.lp.comidas.regionales.Repositories.DeliveryRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IDeliveryService;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService implements IDeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }

    public void postDelivery(Delivery request) {
        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        deliveryRepository.save(request);
    }

    public Delivery putDelivery(Delivery request, Long id ) {
        Delivery delivery = deliveryRepository.findById(id).get();

        delivery.setDireccion(request.getDireccion());
        delivery.setNumeroContacto(request.getNumeroContacto());

        if (request.getEstado() == null) {
            delivery.setEstado(delivery.getEstado());
        } else {
            delivery.setEstado(request.getEstado());
        }

        return deliveryRepository.save(delivery);
    }

    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }

}
