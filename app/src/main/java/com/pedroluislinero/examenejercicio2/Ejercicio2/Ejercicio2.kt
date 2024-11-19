package com.pedroluislinero.examenkotlin.Ejercicio2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/* Ejercicio 2: Selección de Color con Elevación de Estado
Objetivo: Crea una aplicación que permita al usuario seleccionar un color de una lista y
mostrar el color seleccionado en una vista.
Pasos:
1. El componente principal mostrará una fila con todos los colores y debajo el color
seleccionado.
2. Define el estado del color seleccionado en el componente principal.
3. Pasa el estado y la función para cambiar el color a un componente hijo que contiene la
lista de colores.
4. En el componente hijo, muestra la lista de colores y permite al usuario seleccionar
uno. */

@Composable
fun Ejercicio2(){
    val selectedColor = remember { mutableStateOf(Color.White) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text =  "Selecciona un color")

        Box(
            modifier = Modifier.size(100.dp)
                .background(selectedColor.value)
                .padding(8.dp)
        ) {
            Text(
                text = "Color",
                modifier = Modifier.align(Alignment.Center),
                color = if (selectedColor.value != Color.White) Color.White else Color.Black
            )
        }

        Spacer(modifier =  Modifier.height(16.dp))

        //Componente hijo para los colores
        SeleccionColor(selectedColor)
    }
}

@Composable
fun SeleccionColor(selectedColor: MutableState<Color>) {

    val color1 = Color.Red
    val color2 = Color.Blue
    val color3 = Color.Cyan
    val color4 = Color.Green
    val color5 = Color.DarkGray
    val color6 = Color.Yellow

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        ColorBox(color = color1, selectedColor = selectedColor)
        Spacer(modifier = Modifier.height(12.dp))

        ColorBox(color = color2, selectedColor = selectedColor)
        Spacer(modifier = Modifier.height(12.dp))

        ColorBox(color = color3, selectedColor = selectedColor)
        Spacer(modifier = Modifier.height(12.dp))

        ColorBox(color = color4, selectedColor = selectedColor)
        Spacer(modifier = Modifier.height(12.dp))

        ColorBox(color = color5, selectedColor = selectedColor)
        Spacer(modifier = Modifier.height(12.dp))

        ColorBox(color = color6, selectedColor = selectedColor)
        Spacer(modifier = Modifier.height(12.dp))
    }

}

@Composable
fun ColorBox(color: Color, selectedColor: MutableState<Color>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(color)
            .padding(12.dp)
            .clickable { selectedColor.value = color }
    )
}
