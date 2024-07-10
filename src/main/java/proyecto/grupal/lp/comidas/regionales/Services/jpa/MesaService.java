package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Dto.AreaDto;
import proyecto.grupal.lp.comidas.regionales.Dto.MesaDto;
import proyecto.grupal.lp.comidas.regionales.Dto.MesaDtoGetRequest;
import proyecto.grupal.lp.comidas.regionales.Dto.SalonDto;
import proyecto.grupal.lp.comidas.regionales.Entities.Area;
import proyecto.grupal.lp.comidas.regionales.Entities.Mesa;
import proyecto.grupal.lp.comidas.regionales.Entities.Salon;
import proyecto.grupal.lp.comidas.regionales.Repositories.AreaRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.MesaRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.SalonRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IMesaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MesaService implements IMesaService {

    @Autowired
    private MesaRepository mesaRepository;
    @Autowired
    private SalonRepository salonRepository;
    @Autowired
    private AreaRepository areaRepository;

    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll().stream().filter(
                m -> m.getEstado()
        ).toList();
    }

    public MesaDtoGetRequest getMesaDtoGetRequest(Long idSucursal, Long idSalon, Long idArea) {
        MesaDtoGetRequest mesaDtoGetRequest = new MesaDtoGetRequest();

        List<Salon> salones = salonRepository.findAll().stream().filter(s -> s.getSucursal().getId() == idSucursal && s.getEstado()).toList();

        List<SalonDto> salonDtos = new ArrayList<>();

        for (Salon salon : salones) {
            SalonDto salonDto = new SalonDto();
            salonDto.setIdSalon(salon.getId());
            salonDto.setNombre(salon.getNombre());

            salonDtos.add(salonDto);
        }

        mesaDtoGetRequest.setSalones(salonDtos);

        List<Area> areas;

        if (idSalon != 0) {
            areas = areaRepository.findAll().stream().filter(a -> a.getSalon().getId() == idSalon && a.getEstado()).toList();
        } else {
            System.out.println("No se encontro el idSalon");
            Long newIdSalon;
            newIdSalon = salonDtos.get(0).getIdSalon();
            areas = areaRepository.findAll().stream().filter(a -> a.getSalon().getId() == newIdSalon && a.getEstado()).toList();
        }

        List<AreaDto> areaDtos = new ArrayList<>();

        for (Area area : areas) {
            AreaDto areaDto = new AreaDto();
            areaDto.setIdArea(area.getId());
            areaDto.setNombre(area.getNombre());

            areaDtos.add(areaDto);
        }

        mesaDtoGetRequest.setAreas(areaDtos);

        List<Mesa> mesas;

        if (idArea != 0) {
            mesas = mesaRepository.findAll().stream().filter(m -> m.getArea().getId() == idArea && m.getEstado()).toList();
        } else {
            System.out.println("No se encontro el area");
            Long newIdArea;
            newIdArea = areaDtos.get(0).getIdArea();
            mesas = mesaRepository.findAll().stream().filter(m -> m.getArea().getId() == newIdArea && m.getEstado()).toList();
        }

        List<MesaDto> mesaDtos = new ArrayList<>();

        for (Mesa mesa : mesas) {
            MesaDto mesaDto = new MesaDto();
            mesaDto.setIdMesa(mesa.getId());
            mesaDto.setTipoMesa(mesa.getTipoMesa());
            mesaDto.setNumero(mesa.getNumero());
            mesaDto.setCapacidad(mesa.getCapacidad());
            mesaDto.setReservado(mesa.getReservado());
            mesaDto.setOcupado(mesa.getOcupado());
            mesaDto.setEstado(mesa.getEstado());

            mesaDtos.add(mesaDto);
        }

        mesaDtoGetRequest.setMesas(mesaDtos);

        return mesaDtoGetRequest;
    }

    public Optional<Mesa> getMesaById(Long id) {
        return mesaRepository.findById(id);
    }

    public void postMesa(Mesa request) {
        if (request.getReservado() == null) {
            request.setReservado(false);
        }

        if (request.getOcupado() == null) {
            request.setOcupado(false);
        }

        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        mesaRepository.save(request);
    }

    public Mesa putMesa(Mesa request, Long id) {
        Mesa mesa = mesaRepository.findById(id).get();

        mesa.setArea(request.getArea());
        mesa.setTipoMesa(request.getTipoMesa());
        mesa.setNumero(request.getNumero());
        mesa.setCapacidad(request.getCapacidad());

        if (request.getReservado() == null) {
            mesa.setReservado(mesa.getReservado());
        } else {
            mesa.setReservado(request.getReservado());
        }

        if (request.getOcupado() == null) {
            mesa.setOcupado(mesa.getOcupado());
        } else {
            mesa.setOcupado(request.getOcupado());
        }

        if (request.getEstado() == null) {
            mesa.setEstado(mesa.getEstado());
        } else {
            mesa.setEstado(request.getEstado());
        }

        return mesaRepository.save(mesa);
    }

    public void deleteMesa(Long id) {
        mesaRepository.deleteById(id);
    }

}
