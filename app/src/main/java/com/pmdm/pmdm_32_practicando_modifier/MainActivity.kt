package com.pmdm.pmdm_32_practicando_modifier

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmdm.pmdm_32_practicando_modifier.ui.theme.AndroidTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTemplateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun InformacionScreen(modifier: Modifier = Modifier) {
    Column (
        modifier.background(color = MaterialTheme.colorScheme.secondary)
    ) {
        EncabezadoCentro()
        ListadoGrados()
    }
}

@Composable
fun TextoFormateado(
    text: String,
    style: TextStyle = MaterialTheme.typography.headlineMedium
) {
    Text(
        text = text,
        style = style,
        color = MaterialTheme.colorScheme.inversePrimary
    )
}

@Composable
fun EncabezadoCentro(modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.inversePrimary,
                shape = MaterialTheme.shapes.medium
            )
            .padding(16.dp)
    ) {
        TextoFormateado(
            text = "IES Doctor Balmis",
            style = MaterialTheme.typography.headlineLarge
        )
        TextoFormateado(
            text = "Ciclos Formativos Informática",
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

@Composable
fun ListadoGrados(modifier: Modifier = Modifier) {
    Column {
        Text("SMR")
        Text("ASIR")
        Text("DAW")
        Text("DAM")
    }
}

@Preview(showBackground = true)
@Composable
fun InformacionScreenPreview() {
    AndroidTemplateTheme() {
        InformacionScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidTemplateTheme {
        Greeting("Android")
    }
}