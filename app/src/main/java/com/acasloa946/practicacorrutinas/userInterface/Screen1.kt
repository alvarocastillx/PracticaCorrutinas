package com.acasloa946.practicacorrutinas.userInterface

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp


@Composable
fun Screen1(viewmodel1:Viewmodel1) {

    val backgroundColor: Color by viewmodel1.backgroundColor.observeAsState(Color.Red)
    val contAPI: Int by viewmodel1.contAPI.observeAsState(0)
    val isLoading: Boolean by viewmodel1.isLoading.observeAsState(false)


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { viewmodel1.colorChanger() }, colors = ButtonDefaults.buttonColors(backgroundColor)) {
            Text("Cambiar color")
        }
        Spacer(Modifier.padding(10.dp))
        LoadingIndicator(isLoading)
        Button(onClick = { viewmodel1.fetchData() }) {
            Text(text = "Llamar API")
        }
        TextoAPI(contAPI)
    }
}

@Composable
fun TextoAPI(contAPI:Int) {
    if (contAPI>0) {
        Text(text = "Respuesta de la API ($contAPI)")
    }
}

@Composable
fun LoadingIndicator(isLoading: Boolean) {
    if (isLoading) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(150.dp)
        )
    }
}