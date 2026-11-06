package com.mamen.fitnessapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mamen.fitnessapp.tools.CalcularIMC
import com.mamen.fitnessapp.ui.theme.FitnessAppTheme

@Composable
fun WeightTrackingScreen(
    pesActual : Double,
    pesObjectiu : Double,
    alsada: Int
) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(top = 16.dp)) {
            Card(Modifier.weight(1f).padding(8.dp)) {
                Text("Pes actual:")
                Text("$pesActual Kg")
            }

            Card(Modifier.weight(1f).padding(8.dp)) {
                Text("Pes objectiu:")
                Text("$pesObjectiu Kg")
            }

            Card(Modifier.weight(1f).padding(8.dp)) {
                Text("IMC")
                var imc = CalcularIMC.calcularIMC(pesActual, alsada)
                Text(imc.toString())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeightTrackingScreenPreview() {
    FitnessAppTheme {
        WeightTrackingScreen(70.0, 65.0, 170)
    }
}