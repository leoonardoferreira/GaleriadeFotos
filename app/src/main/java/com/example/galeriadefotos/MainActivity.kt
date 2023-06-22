package com.example.galeriadefotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.galeria.dados.ListaMolduras
import com.example.galeriadefotos.model.IdImagemDescricao
import com.example.galeriadefotos.ui.theme.GaleriaDeFotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleriaDeFotosTheme {
                AppGaleriaDeFotos()
            }
        }
    }
}

@Composable
fun AppGaleriaDeFotos() {
    Surface(
        Modifier.fillMaxSize(),
        color = Color(255, 253, 240)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(ListaMolduras().carregarListaMolduras()){
                    molduraImagemDescricao ->
                MolduraImagemDescricao(idImagemDescricao = molduraImagemDescricao)
            }
        }
    }
}

@Composable
fun MolduraImagemDescricao(
    idImagemDescricao: IdImagemDescricao
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(252, 252, 252))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),

        ) {
            Image(
                painter = painterResource(id = idImagemDescricao.idImagem),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = stringResource(id = idImagemDescricao.idDescricao),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp),
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun PreviewMoldura() {
    MolduraImagemDescricao(
        idImagemDescricao = IdImagemDescricao(
            R.drawable.imagem1,
            R.string.descricao_imagem1
        )
    )
}