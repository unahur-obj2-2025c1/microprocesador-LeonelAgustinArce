package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Add;
import ar.edu.unahur.obj2.command.comandos.Ifnz;
import ar.edu.unahur.obj2.command.comandos.Lod;
import ar.edu.unahur.obj2.command.comandos.Lodv;
import ar.edu.unahur.obj2.command.comandos.Nop;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.Str;
import ar.edu.unahur.obj2.command.comandos.Swap;
import ar.edu.unahur.obj2.command.comandos.Whnz;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class ProgramBuilder {

    List<Operable> operaciones = new ArrayList<>();

    public ProgramBuilder nop() {
        operaciones.add(new Nop());
        return this;
    }

    public ProgramBuilder add() {
        operaciones.add(new Add());
        return this;
    }

    public ProgramBuilder swap() {
        operaciones.add(new Swap());
        return this;
    }

    public ProgramBuilder lod(Integer add) {
        operaciones.add(new Lod(add));
        return this;
    }

    public ProgramBuilder str(Integer add) {
        operaciones.add(new Str(add));
        return this;
    }

    public ProgramBuilder lodv(Integer add) {
        operaciones.add(new Lodv(add));
        return this;
    }

    public ProgramBuilder ifnz(List<Operable> operacionesList) {
        operaciones.add(new Ifnz(operacionesList));
        return this;
    }

    public ProgramBuilder whno(List<Operable> operacionesList) {
        operaciones.add(new Whnz(operacionesList));
        return this;
    }

    public List<Operable> build() {
        if (operaciones.isEmpty())
            throw new MicroException("No se puede builder un progama sin operaciones");
        return operaciones;
    }
}
