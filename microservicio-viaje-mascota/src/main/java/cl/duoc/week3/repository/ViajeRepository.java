package cl.duoc.week3.repository;

import cl.duoc.week3.domain.models.Mascota;
import cl.duoc.week3.domain.models.Usuario;
import cl.duoc.week3.domain.models.Viaje;
import cl.duoc.week3.domain.models.enums.RolEnum;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ViajeRepository implements IViajeRepository{
    @Override
    public List<Viaje> findAll() {
        return getList();
    }

    @Override
    public List<Viaje> findEmpty() {
        return List.of();
    }

    @Override
    public Viaje findById(Long id) {
        return getList()
                .stream()
                .filter(v->v.getId().equals(id))
                                            .findFirst()
                                            .orElse(null);
    }



    private List<Viaje>getList(){
        List<Viaje> viajes = new ArrayList<>();

        // Viaje 1
        Viaje viaje1 = new Viaje();
        viaje1.setId(1L);
        viaje1.setDireccion("Avenida Los Jardines");
        viaje1.setCiudad("Santiago");

        List<Usuario> usuarios1 = new ArrayList<>();
        Usuario usuario1 = new Usuario();
        usuario1.setRut("12345678-9");
        usuario1.setNombres("Carlos");
        usuario1.setApellidos("Perez");
        usuario1.setRol(RolEnum.DUENO_MASCOTA.getDescripcion());

        Mascota mascota1 = new Mascota();
        mascota1.setNombre("Firulais");
        mascota1.setEdad("3");
        usuario1.setMascota(mascota1);
        usuarios1.add(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setRut("98765432-1");
        usuario2.setNombres("Ana");
        usuario2.setApellidos("Gomez");
        usuario2.setRol(RolEnum.DUENO_MASCOTA.getDescripcion());

        Mascota mascota2 = new Mascota();
        mascota2.setNombre("Luna");
        mascota2.setEdad("5");
        usuario2.setMascota(mascota2);
        usuarios1.add(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setRut("11223344-5");
        usuario3.setNombres("Luis");
        usuario3.setApellidos("Martinez");
        usuario3.setRol(RolEnum.CONDUCTOR.getDescripcion());
        usuario3.setMascota(null);
        usuarios1.add(usuario3);

        viaje1.setUsuarios(usuarios1);

        // Viaje 2
        Viaje viaje2 = new Viaje();
        viaje2.setId(2L);
        viaje2.setDireccion("Calle Las Rosas");
        viaje2.setCiudad("Valparaíso");

        List<Usuario> usuarios2 = new ArrayList<>();
        Usuario usuario4 = new Usuario();
        usuario4.setRut("22334455-6");
        usuario4.setNombres("Camila");
        usuario4.setApellidos("Torres");
        usuario4.setRol(RolEnum.DUENO_MASCOTA.getDescripcion());

        Mascota mascota3 = new Mascota();
        mascota3.setNombre("Max");
        mascota3.setEdad("2");
        usuario4.setMascota(mascota3);
        usuarios2.add(usuario4);

        Usuario usuario5 = new Usuario();
        usuario5.setRut("55667788-9");
        usuario5.setNombres("Javier");
        usuario5.setApellidos("Lopez");
        usuario5.setRol(RolEnum.DUENO_MASCOTA.getDescripcion());

        Mascota mascota4 = new Mascota();
        mascota4.setNombre("Bella");
        mascota4.setEdad("4");
        usuario5.setMascota(mascota4);
        usuarios2.add(usuario5);

        Usuario usuario6 = new Usuario();
        usuario6.setRut("33445566-7");
        usuario6.setNombres("Diego");
        usuario6.setApellidos("Sanchez");
        usuario6.setRol(RolEnum.CONDUCTOR.getDescripcion());
        usuario6.setMascota(null);
        usuarios2.add(usuario6);

        viaje2.setUsuarios(usuarios2);

        // Viaje 3
        Viaje viaje3 = new Viaje();
        viaje3.setId(3L);
        viaje3.setDireccion("Avenida del Mar");
        viaje3.setCiudad("La Serena");

        List<Usuario> usuarios3 = new ArrayList<>();
        Usuario usuario7 = new Usuario();
        usuario7.setRut("44556677-8");
        usuario7.setNombres("Fernanda");
        usuario7.setApellidos("Alvarez");
        usuario7.setRol(RolEnum.DUENO_MASCOTA.getDescripcion());

        Mascota mascota5 = new Mascota();
        mascota5.setNombre("Toby");
        mascota5.setEdad("1");
        usuario7.setMascota(mascota5);
        usuarios3.add(usuario7);

        Usuario usuario8 = new Usuario();
        usuario8.setRut("77889900-1");
        usuario8.setNombres("Pablo");
        usuario8.setApellidos("Ramirez");
        usuario8.setRol(RolEnum.DUENO_MASCOTA.getDescripcion());

        Mascota mascota6 = new Mascota();
        mascota6.setNombre("Nina");
        mascota6.setEdad("6");
        usuario8.setMascota(mascota6);
        usuarios3.add(usuario8);

        Usuario usuario9 = new Usuario();
        usuario9.setRut("88990011-2");
        usuario9.setNombres("Mario");
        usuario9.setApellidos("Gonzalez");
        usuario9.setRol(RolEnum.CONDUCTOR.getDescripcion());
        usuario9.setMascota(null);
        usuarios3.add(usuario9);

        viaje3.setUsuarios(usuarios3);

        viajes.add(viaje1);
        viajes.add(viaje2);
        viajes.add(viaje3);
        return viajes;
    }
}
