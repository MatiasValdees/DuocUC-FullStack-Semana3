
package cl.duoc.week3.service;

import cl.duoc.week3.domain.exceptions.EmisorNoEncotrado;
import cl.duoc.week3.domain.exceptions.EnvioNoEncontrado;
import cl.duoc.week3.domain.exceptions.ListaVaciaException;
import cl.duoc.week3.domain.exceptions.ReceptorNoEncotrado;
import cl.duoc.week3.domain.models.Envio;
import cl.duoc.week3.domain.models.enums.EstadoEnvio;
import cl.duoc.week3.repository.IClienteRepository;
import cl.duoc.week3.repository.IEnvioRepository;
import cl.duoc.week3.web.dtos.EnvioCreateRequest;
import cl.duoc.week3.web.dtos.EnvioUpdateRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnvioService implements IEnvioService{
    private final IEnvioRepository repository;
    private final IClienteRepository clienteRepository;

    public EnvioService(IEnvioRepository repository, IClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Envio findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EnvioNoEncontrado(id));
    }

    @Override
    public List<Envio> findAll() {
        List<Envio> envios= (List<Envio>) repository.findAll();
        if(envios.isEmpty()){
            throw new ListaVaciaException("Envíos");
        }
        return envios;
    }

    @Override
    public Envio create(EnvioCreateRequest request) {
        var envio= new Envio();
        setterEntities(envio,request.emisorId(),request.receptorId());
        envio.setDireccion(request.direccion());
        envio.setPais(request.pais());
        envio.setCiudad(request.ciudad());
        envio.setLongitud(request.longitud());
        envio.setLatitud(request.latitud());
        envio.setEstado(EstadoEnvio.PENDIENTE);
        envio.setFechaCreacion(LocalDateTime.now());
        return repository.save(envio);
    }

    @Override
    public Envio update(EnvioUpdateRequest request) {
        var envio= repository.findById(request.id())
                .orElseThrow(() -> new EnvioNoEncontrado(request.id()));
        setterEntities(envio,request.emisorId(),request.receptorId());
        envio.setDireccion(request.direccion());
        envio.setPais(request.pais());
        envio.setCiudad(request.ciudad());
        envio.setLongitud(request.longitud());
        envio.setLatitud(request.latitud());
        envio.setEstado(request.estado());
        return repository.save(envio);
    }

    @Override
    public void delete(Long id) {
        var envio= repository.findById(id)
                .orElseThrow(() -> new EnvioNoEncontrado(id));
        repository.delete(envio);
    }

    private void setterEntities(Envio envio, Long emisorId,Long receptorId){
        var emisor= clienteRepository.findById(emisorId)
                .orElseThrow(() -> new EmisorNoEncotrado(emisorId));
        var receptor= clienteRepository.findById(receptorId)
                .orElseThrow(() -> new ReceptorNoEncotrado(receptorId));
        envio.setEmisor(emisor);
        envio.setReceptor(receptor);

    }


}
