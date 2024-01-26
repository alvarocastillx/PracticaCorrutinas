package com.acasloa946.practicacorrutinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.acasloa946.practicacorrutinas.userInterface.Screen1
import com.acasloa946.practicacorrutinas.userInterface.Viewmodel1
import com.acasloa946.practicacorrutinas.ui.theme.PracticaCorrutinasTheme

class MainActivity : ComponentActivity() {

    private val viewModel1vs1 : Viewmodel1 by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaCorrutinasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen1(viewmodel1 = viewModel1vs1)
                }
            }
        }
    }
}
