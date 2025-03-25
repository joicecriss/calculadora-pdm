package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(innerPadding)
                }
            }
        }
    }
}

@Composable
fun MainContent(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier.padding(innerPadding).padding(8.dp).fillMaxSize()
    ) {
        var val1 by remember { mutableStateOf("") }
        var val2 by remember { mutableStateOf("") }
        var result by remember { mutableStateOf("") }
        var scrollState = remember { ScrollState(0) }

        OutlinedTextField(
            value = val1,
            onValueChange = {
                val1 = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Digite aqui...", fontSize = 18.sp) },
            label = { Text("Valor 1", fontSize = 18.sp) },
            textStyle = TextStyle(
                fontSize = 18.sp
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = val2,
            onValueChange = {
                val2 = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Digite aqui...", fontSize = 18.sp) },
            label = { Text("Valor 2", fontSize = 18.sp) },
            textStyle = TextStyle(
                fontSize = 18.sp
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Row(Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if(val1.isNotBlank() && val2.isNotBlank()) {
                        val n1 = val1.toInt()
                        val n2 = val2.toInt()
                        val soma = n1 + n2
                        val1 = ""
                        val2 = ""

                        result += "$n1 + $n2 = $soma\n";
                    }
                },
                Modifier.padding(8.dp)
            ) {
                Text(
                    text ="+",
                    fontSize = 18.sp
                )
            }
            Button(
                onClick = {
                    if(val1.isNotBlank() && val2.isNotBlank()) {
                        val n1 = val1.toInt()
                        val n2 = val2.toInt()
                        val sub = n1 - n2
                        val1 = ""
                        val2 = ""

                        result += "$n1 - $n2 = $sub\n";
                    }
                },
                Modifier.padding(8.dp)
            ) {
                Text(
                    text ="-",
                    fontSize = 18.sp
                )
            }
            Button(
                onClick = {
                    if(val1.isNotBlank() && val2.isNotBlank()) {
                        val n1 = val1.toInt()
                        val n2 = val2.toInt()
                        val multip = n1 * n2
                        val1 = ""
                        val2 = ""

                        result += "$n1 * $n2 = $multip\n";
                    }
                },
                Modifier.padding(8.dp)
            ) {
                Text(
                    text ="*",
                    fontSize = 18.sp
                )
            }
            Button(
                onClick = {
                    if(val1.isNotBlank() && val2.isNotBlank()) {
                        val n1 = val1.toInt()
                        val n2 = val2.toInt()
                        val divisao = n1 / n2
                        val1 = ""
                        val2 = ""

                        result += "$n1 / $n2 = $divisao\n";
                    }
                },
                Modifier.padding(8.dp)
            ) {
                Text(
                    text ="/",
                    fontSize = 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 4.dp)) // margin
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            Text(
                text = result,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraTheme {
        MainContent(PaddingValues(0.dp))
    }
}