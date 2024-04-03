package br.com.fiap.imcapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.imcapp.R

@Composable
fun Forms(
    peso: String,
    altura: String,
    onPesoChange: (String) -> Unit,
    onAlturaChange: (String) -> Unit,
    onCalculate: () -> Unit,
    onClear: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-24).dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xfff9f6f6)),
            elevation = CardDefaults.cardElevation(4.dp),
        ) {
            Column(
                modifier = Modifier
                    .height(400.dp)
                    .padding(
                        vertical = 16.dp, horizontal = 32.dp,
                    ),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Seus dados",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.vermelho_fiap),
                    textAlign = TextAlign.Center
                )
                LabeledOutlinedTextField(
                    labelText = "Seu peso",
                    value = peso,
                    onValueChange = onPesoChange,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = "Seu peso em Kg."
                )
                LabeledOutlinedTextField(
                    labelText = "Sua altura",
                    value = altura,
                    onValueChange = onAlturaChange,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = "Sua altura em cm."
                )

                // -- Botão Calcular
                Button(
                    onClick = onCalculate,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.vermelho_fiap))
                ) {
                    Text(
                        text = "CALCULAR",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
                // -- Botão Limpar dados
                OutlinedButton(
                    onClick = onClear,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(width = 1.dp, colorResource(id = R.color.vermelho_fiap)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(
                        text = "Limpar dados",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.vermelho_fiap),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
