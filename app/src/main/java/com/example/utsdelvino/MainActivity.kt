package com.example.utsdelvino

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.utsdelvino.models.MatKul
import com.example.utsdelvino.models.MatKulData
import com.example.utsdelvino.ui.theme.UTSDelvinoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTSDelvinoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MatKulList(matKul = MatKulData.matKul)
                }
            }
        }
    }
}

@Composable
fun MatKulList (
    matKul: List<MatKul>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = contentPadding
    ){
        itemsIndexed(matKul) {index, matKul ->
            MatKulItem(
                matKul = matKul,
                modifier = Modifier.padding(12.dp, vertical = 4.dp)
            )
        }
    }
}


@Composable
fun MatKulItem(
    matKul: MatKul,
    modifier: Modifier = Modifier
) {
    Card (
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 64.dp)
        ) {
            Box (
                modifier = Modifier.size(72.dp)
            ) {
                Image(
                    painter = painterResource(matKul.imageRes),
                    contentDescription = null,
                )
            }
            Spacer(Modifier.width(12.dp))
            Column (modifier = Modifier.weight(1f)) {
                Text (
                    text = stringResource(matKul.nameRes),
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(0.dp, 4.dp)
                )
                Text (
                    text = stringResource(matKul.sksRes),
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(0.dp, 4.dp)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MatKulItemPreview() {
//    UTSDelvinoTheme {
//        MatKulItem("Android")
//    }
//}

@Preview("List")
@Composable
fun MatKulPreview(){
    MatKulList(matKul = MatKulData.matKul)
}