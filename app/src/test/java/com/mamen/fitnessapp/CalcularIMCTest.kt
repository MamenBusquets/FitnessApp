package com.mamen.fitnessapp

import com.mamen.fitnessapp.tools.CalcularIMC
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CalcularIMCTest {
    @Test
    fun calcularIMCPesNormal() {
        var pesActual = 70.0
        var alsada = 170
        var imc = CalcularIMC.calcularIMC(pesActual, alsada)
        assertEquals(24.22, imc, 0.1)
    }

    @Test
    fun calcularIMCPesInferiorCero() {
        var pesActual = -1.0
        var alsada = 170
        var imc = CalcularIMC.calcularIMC(pesActual, alsada)
        assertEquals(0.0, imc, 0.1)
    }

    @Test
    fun calcularIMCAlsadaInferiorCero() {
        var pesActual = 70.0
        var alsada = -1
        var imc = CalcularIMC.calcularIMC(pesActual, alsada)
        assertEquals(0.0, imc, 0.1)
    }
}
