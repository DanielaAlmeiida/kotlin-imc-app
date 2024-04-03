package br.com.fiap.imcapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import br.com.fiap.imcapp.service.calcularImc
import br.com.fiap.imcapp.service.obterStatusImc

@Composable
fun IMCScreen() {
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    val pesoFocusRequester = remember { FocusRequester() }
    var imc by remember { mutableStateOf(0.0) }
    var statusImc by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            HeaderIMC()
            Forms(
                peso = peso,
                altura = altura,
                onPesoChange = { peso = it },
                onAlturaChange = { altura = it },
                onCalculate = {
                    imc = calcularImc(
                        pesoUsuario = peso.toDouble(),
                        alturaUsuario = altura.toDouble()
                    )
                    statusImc = obterStatusImc(imcUsuario = imc)
                },
                onClear = {
                    peso = ""
                    altura = ""
                    pesoFocusRequester.requestFocus()
                }
            )
            CardResultado(statusImc = statusImc, imc = imc)
        }
    }
}
