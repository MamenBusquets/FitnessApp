package com.mamen.fitnessapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mamen.fitnessapp.R
import com.mamen.fitnessapp.ui.components.CalendariPicker
import com.mamen.fitnessapp.ui.components.MenuDesplegable

@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixement: Long,
    genere: String,
    alsada: Int,
    pes: Double,
    pesObjectiu: Double,
    objectiu: String,
    nivellActivitat: String,
    guardar: (String, String, Long, String, Int, Double, Double, String, String) -> Unit,
) {
    var nomNou: String by remember { mutableStateOf(value = nom) }
    var emailNou: String by remember { mutableStateOf(value = email) }
    var dataNaixementNou: Long by remember { mutableStateOf(value = dataNaixement) }
    var genereNou: String by remember { mutableStateOf(value = genere) }

    // Guardamos los valores como String mientras se editan para permitir borrar el campo completamente y escribir decimales (p. ej. "60.5" o "60,5")
    var alsadaText: String by remember { mutableStateOf(value = alsada.toString()) }
    var pesText: String by remember { mutableStateOf(value = pes.toString()) }
    var pesObjectiuText: String by remember { mutableStateOf(value = pesObjectiu.toString()) }

    var objectiuNou: String by remember { mutableStateOf(value = objectiu) }
    var nivellActivitatNou: String by remember { mutableStateOf(value = nivellActivitat) }
    var opcionsGenere = listOf("Masculí", "Femení", "Prefereixo no dir-ho")
    var opcionsObjectiu = listOf("Guanyar massa muscular", "Baixar de pes", "Mantenir el pes")
    var opcionsNivellActivitat = listOf("Baix", "Moderat", "Alt")

    // Text Field Outlined es la cajita de texto con el borde por fuera
    Column() {
        // Imatge del perfil
        Row(Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
            .padding(start = 16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_usuari),
                contentDescription = null,
                Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.White)

            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                horizontalAlignment = Alignment.End
            ) {
                Button(onClick = {}) { Text(text = "Canviar foto") }
                Button(onClick = {}) { Text(text = "Eliminar foto") }
            }
        }

        // Dades personals
        Text(
            text = "Dades personals",
            Modifier.padding(top = 16.dp, start = 8.dp),
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = nomNou,
            onValueChange = { nomNou = it },
            label = { Text("Nom complet") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = emailNou,
            onValueChange = { emailNou = it },
            label = { Text("Email") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        // Data de naixement --> DATA PICKER
        CalendariPicker(
            label = "Data de naixement",
            selectedDateMillis = dataNaixementNou,
            onDateSelected = { dataNaixementNou = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        // Gènere --> DROPDOWN MENU
        MenuDesplegable(
            label = "Gènere",
            opcions = opcionsGenere,
            valorSeleccionat = genereNou,
            onValorSeleccionat = { genereNou = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        // Dades físiques
        Text(
            text = "Dades físiques",
            Modifier.padding(top = 16.dp, start = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            // Campo de altura: utiliza 'alsadaText' (String) y abre el teclado numérico para introducir la altura
            OutlinedTextField(
                value = alsadaText,
                onValueChange = { alsadaText = it },
                label = { Text("Alçada (cm)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )

            // Campo de peso: utiliza 'pesText' (String) y abre el teclado decimal para permitir escribir decimales (puntos o comas)
            OutlinedTextField(
                value = pesText,
                onValueChange = { pesText = it },
                label = { Text("Pes (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )

            // Campo de peso objetivo: utiliza 'pesObjectiuText' (String) y abre el teclado decimal para permitir escribir decimales
            OutlinedTextField(
                value = pesObjectiuText,
                onValueChange = { pesObjectiuText = it },
                label = { Text(text = "Pes objectiu (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
        }

        // Objectiu principal
        Text(
            text = "Objectiu principal",
            Modifier.padding(top = 16.dp, start = 8.dp),
            fontWeight = FontWeight.Bold
        )
        MenuDesplegable(
            label = " ",
            opcions = opcionsObjectiu,
            valorSeleccionat = objectiuNou,
            onValorSeleccionat = { objectiuNou = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        // Nivell d'activitat
        Text(
            text = "Nivell d'activitat",
            Modifier.padding(top = 16.dp, start = 8.dp),
            fontWeight = FontWeight.Bold
        )
        MenuDesplegable(
            label = " ",
            opcions = opcionsNivellActivitat,
            valorSeleccionat = nivellActivitatNou,
            onValorSeleccionat = { nivellActivitatNou = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        // Botón guardar: convierte el texto de cada campo a Int/Double (cambiando comas por puntos si es necesario). Si el campo está vacío, mantiene el valor anterior.
        Button(onClick = {
            val alsadaFinal = alsadaText.toIntOrNull() ?: alsada
            val pesFinal = pesText.replace(',', '.').toDoubleOrNull() ?: pes
            val pesObjectiuFinal = pesObjectiuText.replace(',', '.').toDoubleOrNull() ?: pesObjectiu
            guardar(
                nomNou,
                emailNou,
                dataNaixementNou,
                genereNou,
                alsadaFinal,
                pesFinal,
                pesObjectiuFinal,
                objectiuNou,
                nivellActivitatNou
            )
        }) {
            Text("Guardar canvis",
                Modifier.background(Color.Blue))
        }
    }

}