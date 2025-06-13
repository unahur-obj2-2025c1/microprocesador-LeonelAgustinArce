package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.ProgramBuilder;
import ar.edu.unahur.obj2.command.Programable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class ProgramBuilderTest {

    Programable programable = new Microprocesador();

    @BeforeEach
    void setUp() {
        programable.reset();
    }

    @Test
    void alBuildearUnProgramaConInstruccionesSimples_CuandoSeLoPasamosAUnMicrocontrolador_FuncionaCorrectamente() {
        ProgramBuilder programBuilder = new ProgramBuilder();

        programable.run(
                programBuilder
                        .lodv(2)
                        .str(0)
                        .lodv(8)
                        .swap()
                        .lodv(5)
                        .add()
                        .swap()
                        .lod(0)
                        .add().build());

        assertEquals(15, programable.getAcumuladorA());
        assertEquals(0, programable.getAcumuladorB());
        assertEquals(9, programable.getProgramCounter());
    }

    @Test
    void alBuildearUnProgramaConInstrucciones_CuandoSeLoPasamosAUnMicrocontrolador_FuncionaCorrectamente() {
        ProgramBuilder rutina = new ProgramBuilder();
        ProgramBuilder programBuilderPpal = new ProgramBuilder();

        programable.run(
                programBuilderPpal
                        .lodv(5)
                        .ifnz(rutina
                                .nop()
                                .nop()
                                .swap()
                                .build())
                        .build());

        assertEquals(0, programable.getAcumuladorA());
        assertEquals(5, programable.getAcumuladorB());
        assertEquals(5, programable.getProgramCounter());
    }

    @Test
    void alBuildearUnProgramaSinInstrucciones_SeLanzaUnError() {
        ProgramBuilder programBuilder = new ProgramBuilder();
        assertThrows(MicroException.class, programBuilder::build);

    }
}
