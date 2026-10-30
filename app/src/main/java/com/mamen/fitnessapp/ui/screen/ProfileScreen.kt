package com.mamen.fitnessapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mamen.fitnessapp.R
import java.util.Calendar
import java.util.TimeZone

fun calcularEdat(dataNaixement: Long): Int {
    return try {
        val naixement = Calendar.getInstance(TimeZone.getTimeZone("UTC")).apply {
            timeInMillis = dataNaixement
        }
        val avui = Calendar.getInstance()

        var edat = avui.get(Calendar.YEAR) - naixement.get(Calendar.YEAR)

        val mesAvui = avui.get(Calendar.MONTH)
        val mesNaixement = naixement.get(Calendar.MONTH)
        val diaAvui = avui.get(Calendar.DAY_OF_MONTH)
        val diaNaixement = naixement.get(Calendar.DAY_OF_MONTH)

        if (mesAvui < mesNaixement || (mesAvui == mesNaixement && diaAvui < diaNaixement)) {
            edat--
        }
        edat
    } catch (_: Exception) {
        0
    }
}

@Composable
fun ProfileScreen(
    nom: String,
    email: String,
    dataNaixement: Long,
    genere: String,
    alsada: Int,
    pes: Double,
    objectiu: String,
    nivellActivitat: String,
    editar: () -> Unit,
) {

    Column() {
        // Caixa de foto, nom i email
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.ic_usuari),
                contentDescription = null,
                Modifier
                    .padding(top = 32.dp)
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White)

            )
            Text(
                text = nom,
                fontSize = 20.sp,
                fontWeight = Bold,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = email,
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        // Caixa informació personal
        Card(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                Arrangement.SpaceEvenly
            ) {
                // Edat
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.ic_calendari),
                        contentDescription = null,
                        Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                            .size(20.dp)
                    )
                    val edat = calcularEdat(dataNaixement)
                    Text(
                        "Edat",
                        color = Color.Gray,
                    )
                    Text(
                        "$edat",
                        fontWeight = FontWeight.Bold
                    )
                }
                // Génere
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.ic_genere),
                        contentDescription = null,
                        Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                            .size(20.dp),


                    )
                    Text(
                        "Génere",
                        color = Color.Gray,
                    )
                    Text(
                        genere,
                        fontWeight = FontWeight.Bold
                    )
                }
                // Alçada
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.ic_regla),
                        contentDescription = null,
                        Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                            .size(20.dp),


                    )
                    Text(
                        "Alçada",
                        color = Color.Gray,
                    )
                    Text(
                        "$alsada cm",
                        fontWeight = FontWeight.Bold
                    )
                }
                // Pes
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.ic_bascula),
                        contentDescription = null,
                        Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                            .size(20.dp),


                    )
                    Text(
                        "Pes",
                        color = Color.Gray,
                    )
                    Text(
                        "$pes kg",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Caixa d'objectius
        Text(
            "Objectius",
            fontSize = 20.sp,
            fontWeight = Bold,
            modifier = Modifier.padding(16.dp)
        )

        Card(
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(12.dp),
        ) {
            Text(objectiu, Modifier.padding(8.dp))
        }

        // Caixa de nivell d'activitat
        Text(
            "Nivell d'activitat",
            fontSize = 20.sp,
            fontWeight = Bold,
            modifier = Modifier.padding(16.dp)
        )
        Card(
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(12.dp),
        ) {
            Text(nivellActivitat, Modifier.padding(8.dp))
        }

    }
    // Botón para editar el perfil (símbolo del lápiz)
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
        Image(
            painterResource(R.drawable.ic_editar), contentDescription = "Edit",
            alignment = Alignment.TopEnd,
            modifier = Modifier
                .padding(top = 20.dp, end = 16.dp)
                .size(50.dp)
                .clickable { editar() }
        )
    }
}