package com.mamen.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mamen.fitnessapp.ui.screen.EditProfileScreen
import com.mamen.fitnessapp.ui.screen.ProfileScreen
import com.mamen.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FitnessApp()
                }
            }
        }
    }
}

@Composable
fun FitnessApp() {
    // Variables a utilizar
    var nom: String by remember { mutableStateOf(value = "Laia Soler") }
    var email: String by remember { mutableStateOf(value = "laia.soler@example.com") }
    var dataNaixement: Long by remember { mutableStateOf(value = 1234567890) }
    var genere: String by remember { mutableStateOf(value = "Dona") }
    var alsada: Int by remember { mutableStateOf(value = 170) }
    var pes: Double by remember { mutableStateOf(value = 60.0) }
    var pesObjectiu: Double by remember { mutableStateOf(value = 60.0) }
    var editant: Boolean by remember { mutableStateOf(value = false) }
    var objectiu: String by remember { mutableStateOf(value = "Guanyar massa muscular") }
    var nivellActivitat: String by remember { mutableStateOf(value = "Moderat") }

    if (editant) {
        EditProfileScreen(
            nom,
            email,
            dataNaixement,
            genere,
            alsada,
            pes,
            pesObjectiu,
            objectiu,
            nivellActivitat,
            { nomN, emailN, dataNaixementN, genereN, alsadaN,
              pesN, pesObjectiuN, objectiuN, nivellActivitatN ->
                nom = nomN
                email = emailN
                dataNaixement = dataNaixementN
                genere = genereN
                alsada = alsadaN
                pes = pesN
                pesObjectiu = pesObjectiuN
                objectiu = objectiuN
                nivellActivitat = nivellActivitatN
                editant = false
            })
    } else {
        ProfileScreen(
            nom, email, dataNaixement, genere, alsada,
            pes, objectiu, nivellActivitat, { editant = true })
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnessAppTheme {
        FitnessApp()
    }
}
