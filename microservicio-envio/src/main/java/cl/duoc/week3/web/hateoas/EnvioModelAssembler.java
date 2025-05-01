package cl.duoc.week3.web.hateoas;

import cl.duoc.week3.domain.models.Envio;
import cl.duoc.week3.web.EnvioController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EnvioModelAssembler implements RepresentationModelAssembler<Envio, EntityModel<Envio>> {

    @Override
    public EntityModel<Envio> toModel(Envio envio) {
        return EntityModel.of(
                envio,
                linkTo(methodOn(EnvioController.class).getById(envio.getId())).withSelfRel(),
                linkTo(methodOn(EnvioController.class).delete(envio.getId())).withRel("delete"),
                linkTo(methodOn(EnvioController.class).update(null)).withRel("update"),
                linkTo(methodOn(EnvioController.class).getAll()).withRel("all")
        );
    }
}