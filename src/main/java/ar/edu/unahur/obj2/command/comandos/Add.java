package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Add extends Command {

    @Override
    public void doExecute(Programable micro) {
        Integer resutlado = micro.getAcumuladorA() + micro.getAcumuladorB();
        micro.setAcumuladorA(resutlado);
        micro.setAcumuladorB(0);
    }

}
