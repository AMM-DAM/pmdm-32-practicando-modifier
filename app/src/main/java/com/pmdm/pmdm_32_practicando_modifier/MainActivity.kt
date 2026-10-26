package com.pmdm.pmdm_32_practicando_modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Column {
        EncabezadoCentro()
        ListadoGrados()
    }
}

@Composable
fun EncabezadoCentro(modifier: Modifier = Modifier) {
    Column {
        Text("IES Doctor Balmis")
        Text("Ciclos Formativos Informática")
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