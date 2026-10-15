package com.example.damflix
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class FormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FormularioDAMFlix()
                }
            }
        }
    }
}

@Composable
fun FormularioDAMFlix() {
    var titulo by remember { mutableStateOf("") }
    var director by remember { mutableStateOf("") }
    var anio by remember { mutableStateOf("") }
    var esVista by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CampoEntrada(
            valor = titulo,
            onCambio = { titulo = it },
            etiqueta = "Título de la película"
        )

        CampoEntrada(
            valor = director,
            onCambio = { director = it },
            etiqueta = "Director/a"
        )

        CampoEntrada(
            valor = anio,
            onCambio = { anio = it },
            etiqueta = "Año de estreno"
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = esVista,
                onCheckedChange = { esVista = it }
            )
            Text("Ya he visto esta película")
        }

        Button(
            onClick = { /* Guardar película */ },
            enabled = titulo.isNotBlank() && director.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Película")
        }
    }
}

@Composable
fun CampoEntrada(valor: String, onCambio: (String) -> Unit, etiqueta: String) {
    OutlinedTextField(
        value = valor,
        onValueChange = onCambio,
        label = { Text(etiqueta) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}