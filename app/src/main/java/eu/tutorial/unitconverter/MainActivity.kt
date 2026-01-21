package eu.tutorial.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.tutorial.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                    Box {
                        Button(onClick = {}) {
                            Text("Click Me")
                        }
                        DropdownMenu(expanded = false, onDismissRequest = {}) {
                            DropdownMenuItem(text = { Text("") }, onClick = {})
                            DropdownMenuItem(text = { Text("") }, onClick = {})
                            DropdownMenuItem(text = { Text("") }, onClick = {})

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    Column() {
        Row() {
            Column() {
                Text(text = "Unit Converter", Modifier.size(17.dp))
                OutlinedTextField(value = "", onValueChange = {})
            }
        }
        Row() {
            Column() {

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

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    Column(verticalArrangement = Arrangement.Center) {
        Row() {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Unit Converter")
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = "", onValueChange = {})
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row() {
            Column() {

            }
        }
    }
}