package edu.geadaadrian.appdummy


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.geadaadrian.appdummy.ui.theme.AppDummyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppDummyTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
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
        modifier = Modifier.background(Color.Cyan),
        color = MaterialTheme.colorScheme.error
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppDummyTheme {
        //Greeting("Android")
        EjemploModifier()
    }
}

@Composable
fun EjemploModifier() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){

        // El orden de los modificadores afecta al resultado visual
        Text(
            text = "Con padding fuera del fondo",
            modifier = Modifier
                .background(Color.Yellow)   // el fondo NO incluye el padding
                .padding(16.dp)             // el padding se aplica DENTRO del fondo
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Con fondo sobre el padding",
            modifier = Modifier
                .background(Color.Red)
                .padding(16.dp)             // el padding se aplica ANTES del fondo
                .background(Color.Yellow)   // el fondo SÍ incluye el padding
        )

    }

}






