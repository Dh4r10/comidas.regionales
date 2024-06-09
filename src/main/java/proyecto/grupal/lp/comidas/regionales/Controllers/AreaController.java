package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Area;
import proyecto.grupal.lp.comidas.regionales.Services.IAreaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/area")
public class AreaController {

    @Autowired
    private IAreaService areaService;

    @GetMapping
    public List<Area> getAllAreas() {
        return areaService.getAllAreas();
    }

    @GetMapping("/{id}")
    public Optional<Area> getAreaById(@PathVariable Long id) {
        return areaService.getAreaById(id);
    }

    @PostMapping
    public Area postArea(@RequestBody Area request) {
        areaService.postArea(request);
        return request;
    }

    @PutMapping("/{id}")
    public Area putArea(@PathVariable Long id, @RequestBody Area request) {
        return areaService.putArea(request, id);
    }

    @PatchMapping("/{id}")
    public Area patchArea(@PathVariable Long id, @RequestBody Area request) {
        return areaService.patchArea(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteArea(@PathVariable Long id) {
        areaService.deleteArea(id);
        return "Area con id=" + id + " eliminado correctamente";
    }

}
