package com.mamen.fitnessapp.tools

import kotlin.math.round

class CalcularIMC {
    companion object {
        fun calcularIMC(pesActual: Double, alsada: Int): Double {
            var alsadaMetres = alsada.toDouble() / 100
            return round(pesActual / (alsadaMetres * alsadaMetres) * 100) / 100
        }
    }
}