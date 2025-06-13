package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Lodv extends Command {
    private Integer value;

    public Lodv(Integer value) {
        this.value = value;
    }

    @Override
    public void doExecute(Programable micro) {
        micro.setAcumuladorA(value);
    }

}
