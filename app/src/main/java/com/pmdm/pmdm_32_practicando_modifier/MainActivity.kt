package com.pmdm.pmdm_32_practicando_modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    val paddingModifier = Modifier.padding(2.dp);

    Column (
        modifier
            .background(color = MaterialTheme.colorScheme.secondary)
            .padding(4.dp)
    ) {
        EncabezadoCentro(paddingModifier)
        ListadoGrados(paddingModifier)
    }
}

@Composable
fun TextoFormateado(
    text: String,
    style: TextStyle = MaterialTheme.typography.headlineMedium,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = style,
        color = MaterialTheme.colorScheme.inversePrimary,
        modifier = modifier
    )
}

@Composable
fun TextoEstiloCiclos(
    text: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.then(Modifier
            .background(color)
            .padding(6.dp)
            .fillMaxWidth()
        )
    )
}

@Composable
fun EncabezadoCentro(modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.then(Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.inversePrimary,
                shape = MaterialTheme.shapes.medium
            )
            .padding(16.dp)
        )
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
    val marginModifier = Modifier.padding(1.dp)
    Column (modifier = modifier) {
        TextoEstiloCiclos("SMR", MaterialTheme.colorScheme.errorContainer, marginModifier)
        TextoEstiloCiclos("ASIR", MaterialTheme.colorScheme.tertiaryContainer, marginModifier)
        TextoEstiloCiclos("DAW", MaterialTheme.colorScheme.secondaryContainer, marginModifier)
        TextoEstiloCiclos("DAM", MaterialTheme.colorScheme.primaryContainer, marginModifier)
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