package com.mamen.fitnessapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mamen.fitnessapp.tools.CalcularIMC
import com.mamen.fitnessapp.ui.theme.FitnessAppTheme

@Composable
fun WeightTrackingScreen(
    pesActual : Double,
    pesObjectiu : Double,
    alsada: Int,
) {
    var pesNou: Double by remember { mutableStateOf(value = 0.0) }

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(top = 16.dp)) {
            Card(
                Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text("Pes actual:")
                Text("$pesActual Kg")
            }

            Card(
                Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text("Pes objectiu:")
                Text("$pesObjectiu Kg")
            }

            Card(
                Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text("IMC")
                var imc = CalcularIMC.calcularIMC(pesActual, alsada)
                Text(imc.toString())
            }
        }
        Text("Registrar nou pes",
            Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 8.dp))
        OutlinedTextField(
            value = pesNou.toString(),
            onValueChange = { pesNou = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("Pes en Kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
        )
        Button(
            onClick = {
                // TODO: Guardar pes
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            Text("Guardar pes")
        }

        Text("Evolució del pes",
                Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 16.dp))
        Box(modifier = Modifier.fillMaxWidth()
                .height(50.dp))

        Text("Últims registres",
            Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun WeightTrackingScreenPreview() {
    FitnessAppTheme {
        WeightTrackingScreen(70.0, 65.0, 170)
    }
}