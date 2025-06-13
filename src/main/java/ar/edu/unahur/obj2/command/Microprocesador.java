package ar.edu.unahur.obj2.command;

import java.util.Arrays;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable {
    private static final Integer MIN_ADDR_VALUE = 0;
    private static final Integer MAX_ADDR_VALUE = 1023;
    private Integer programCounter = 0;
    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    List<Integer> addrs = Arrays.asList(new Integer[1024]);

    @Override
    public void incProgramCounter() {
        programCounter++;
    }

    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.stream().forEach(operacion -> operacion.execute(this));
    }

    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;

    }

    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }

    @Override
    public void copyFrom(Programable programable) {
        programCounter = programable.getProgramCounter();
        acumuladorA = programable.getAcumuladorA();
        acumuladorB = programable.getAcumuladorB();
    }

    @Override
    public Programable copy() {
        Microprocesador copia = new Microprocesador();
        copia.programCounter = this.programCounter;
        copia.acumuladorA = this.acumuladorA;
        copia.acumuladorB = this.acumuladorB;
        return copia;
    }

    @Override
    public void reset() {
        programCounter = 0;
        acumuladorA = 0;
        acumuladorB = 0;
        addrs = Arrays.asList(new Integer[1024]);
    }

    @Override
    public void setAddr(Integer addr) {
        if (!estaEnRango(addr))
            throw new IllegalArgumentException("La dirección de memoria no es válida");
        addrs.set(addr, acumuladorA);
    }

    @Override
    public Integer getAddr(Integer addr) {
        if (!estaEnRango(addr))
            throw new MicroException("La dirección de memoria no es válida");

        return addrs.get(addr);
    }

    private boolean estaEnRango(Integer addr) {
        return addr >= MIN_ADDR_VALUE && addr <= MAX_ADDR_VALUE;
    }

}