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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorial.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {

    Column(verticalArrangement = Arrangement.Center) {
        var fromUnit by remember { mutableStateOf("") }
        var toUnit by remember { mutableStateOf("") }
        var inputOfUser by remember { mutableStateOf("") }
        var output by remember { mutableStateOf("") }

        fun calculateConversion() {
            if (fromUnit != "" && toUnit != "") {
                output = when {
                    fromUnit == "Centimeters" && toUnit == "Millimeters" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) * 10).toString()
                    fromUnit == "Millimeters" && toUnit == "Centimeters" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) / 10).toString()
                    fromUnit == "Meters" && toUnit == "Centimeters" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) * 100).toString()
                    fromUnit == "Centimeters" && toUnit == "Meters" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) / 100).toString()
                    fromUnit == "Meters" && toUnit == "Millimeters" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) * 1000).toString()
                    fromUnit == "Millimeters" && toUnit == "Meters" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) / 1000).toString()
                    fromUnit == "Feet" && toUnit == "Meters" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) * 0.3048).toString()
                    fromUnit == "Feet" && toUnit == "Millimeters" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) * 304.8).toString()
                    fromUnit == "Feet" && toUnit == "Centimeters" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) * 30.48).toString()
                    fromUnit == "Meters" && toUnit == "Feet" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) / 0.3048).toString()
                    fromUnit == "Centimeters" && toUnit == "Feet" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) / 30.48).toString()
                    fromUnit == toUnit -> inputOfUser
                    fromUnit == "Millimeters" && toUnit == "Feet" ->
                        ((inputOfUser.toDoubleOrNull() ?: 0.0) / 304.8).toString()
                    else ->
                        "Unsupported conversion"
                }
            }
        }

        Row() {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Unit Converter", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = inputOfUser, onValueChange = fun (e) {
                    inputOfUser = e
                    calculateConversion()
                })
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Box() {
                var isOpen by remember { mutableStateOf(false) }

                Button(onClick = { isOpen = !isOpen }) {
                    Text(text= when {
                        fromUnit == "" -> "From Unit"
                        else -> fromUnit
                    })
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Select a unit to convert")
                }
                DropdownMenu(expanded = isOpen, onDismissRequest = {
                    isOpen = false
                    calculateConversion()
                }) {
                    DropdownMenuItem(onClick = {
                        fromUnit = "Centimeters"
                        isOpen = false
                        calculateConversion()
                                               }, text = { Text("Centimeters") })
                    DropdownMenuItem(onClick = {
                        fromUnit = "Meters"
                        isOpen = false
                        calculateConversion()
                                               }, text = { Text("Meters") })
                    DropdownMenuItem(onClick = {
                        fromUnit = "Feet"
                        isOpen = false
                        calculateConversion()
                                               }, text = { Text("Feet") })
                    DropdownMenuItem(onClick = {
                        fromUnit = "Millimeters"
                        isOpen = false
                        calculateConversion()
                                               }, text = { Text("Millimeters") })
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box() {
                var isOpen by remember { mutableStateOf(false) }

                Button(onClick = { isOpen = !isOpen }) {
                    Text(text= when {
                        toUnit == "" -> "To Unit"
                        else -> toUnit
                    })
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Select a unit to convert to")
                }
                DropdownMenu(expanded = isOpen, onDismissRequest = {
                    isOpen = false
                    calculateConversion()
                }) {
                    DropdownMenuItem(onClick = {
                        toUnit = "Centimeters"
                        isOpen = false
                        calculateConversion()
                                               }, text = { Text("Centimeters") })
                    DropdownMenuItem(onClick = {
                        toUnit = "Meters"
                        isOpen = false
                        calculateConversion()
                                               }, text = { Text("Meters") })
                    DropdownMenuItem(onClick = {
                        toUnit = "Feet"
                        isOpen = false
                        calculateConversion()
                                               }, text = { Text("Feet") })
                    DropdownMenuItem(onClick = {
                        toUnit = "Millimeters"
                        isOpen = false
                        calculateConversion()}, text = { Text("Millimeters") })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row() {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Output:")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = output)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    Column(verticalArrangement = Arrangement.Center) {
        var fromUnit by remember { mutableStateOf("") }
        var toUnit by remember { mutableStateOf("") }

        Row() {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Unit Converter")
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = "", onValueChange = {})
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Box() {
                var isOpen by remember { mutableStateOf(false) }

                Button(onClick = { isOpen = !isOpen }) {
                    Text(text= when {
                        fromUnit == "" -> "From Unit"
                        else -> fromUnit
                    })
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Select a unit to convert")
                }
                DropdownMenu(expanded = isOpen, onDismissRequest = { isOpen = false}) {
                    DropdownMenuItem(onClick = { fromUnit = "Centimeters" }, text = { Text("Centimeters") })
                    DropdownMenuItem(onClick = { fromUnit = "Meters" }, text = { Text("Meters") })
                    DropdownMenuItem(onClick = { fromUnit = "Feet"}, text = { Text("Feet") })
                    DropdownMenuItem(onClick = { fromUnit = "Millimeters" }, text = { Text("Millimeters") })
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box() {
                var isOpen by remember { mutableStateOf(false) }

                Button(onClick = { isOpen = !isOpen }) {
                    Text(text= when {
                        toUnit == "" -> "To Unit"
                        else -> toUnit
                    })
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Select a unit to convert to")
                }
                DropdownMenu(expanded = isOpen, onDismissRequest = { isOpen = false }) {
                    DropdownMenuItem(onClick = { toUnit = "Centimeters" }, text = { Text("Centimeters") })
                    DropdownMenuItem(onClick = { toUnit = "Meters" }, text = { Text("Meters") })
                    DropdownMenuItem(onClick = { toUnit = "Feet"}, text = { Text("Feet") })
                    DropdownMenuItem(onClick = { toUnit = "Millimeters" }, text = { Text("Millimeters") })
                }
            }
        }
    }
}