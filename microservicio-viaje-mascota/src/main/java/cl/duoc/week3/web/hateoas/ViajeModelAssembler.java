package cl.duoc.week3.web.hateoas;

import cl.duoc.week3.domain.models.Viaje;
import cl.duoc.week3.web.ViajeController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ViajeModelAssembler implements RepresentationModelAssembler<Viaje, EntityModel<Viaje>> {

    @Override
    public EntityModel<Viaje> toModel(Viaje viaje) {
        return EntityModel.of(
                viaje,
                linkTo(methodOn(ViajeController.class).getById(viaje.getId())).withSelfRel(),
                linkTo(methodOn(ViajeController.class).delete(viaje.getId())).withRel("delete"),
                linkTo(methodOn(ViajeController.class).update(null)).withRel("update"),
                linkTo(methodOn(ViajeController.class).getAll()).withRel("all")
        );
    }
}
