package ar.edu.unahur.obj2.command.comandos;

import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class Ifnz extends CompositeCommand {

    public Ifnz(List<Operable> operaciones) {
        super(operaciones);
    }

    @Override
    public void doExecute(Programable micro) {
        if (this.notZero(micro)) {
            super.doExecute(micro);
        }
    }

}
