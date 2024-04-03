package br.com.fiap.imcapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CardResultado(statusImc: String, imc: Double) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 32.dp, vertical = 24.dp),
        colors = CardDefaults.cardColors(
            (if (statusImc.equals("Abaixo do peso") ||
                statusImc.equals("Obesidade Grau I") ||
                statusImc.equals("Obesidade Grau II") ||
                statusImc.equals("Obesidade Grau III")) {
                Color(0xFFCF1F1F)
            } else if (statusImc.equals("Levemente acima do peso")) {
                Color(0xFFE9A125)
            } else {
                Color(0xff329F6B)
            })
        ),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxSize()
        ) {
            Column() {
                Text(
                    text = "Resultado",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    text = statusImc,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Text(
                text = String.format("%.1f", imc),
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 36.sp,
                textAlign = TextAlign.End
            )
        }
    }
}