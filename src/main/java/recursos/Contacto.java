package recursos;

import java.time.LocalDate;

public class Contacto {
    public String nombre;
    public long numero;
    public LocalDate fechaAltaAgenda;

    public Contacto(String no, long nu, LocalDate fe) {
        this.nombre = no;
        this.numero = nu;
        this.fechaAltaAgenda = fe;
    }

    public Contacto(String no, long nu, String fe) {
        this.nombre = no;
        this.numero = nu;
        this.fechaAltaAgenda = LocalDate.parse(fe);
    }

    public Contacto(String no, long nu) {
        this.nombre = no;
        this.numero = nu;
        this.fechaAltaAgenda = LocalDate.now();
    }
}
