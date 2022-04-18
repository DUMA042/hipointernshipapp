package com.example.hipointernapp.Uilayer.UiScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.hipointernapp.ui.theme.LittleBlack


@Composable
fun HomeScreen(names: List<String> = List(35) { "$it" }){

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card( backgroundColor =  LittleBlack,elevation = 7.dp, modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp), shape = RoundedCornerShape(8.dp)
        ) {

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Summer Internship",fontWeight = FontWeight.Bold, color = Color.LightGray,textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(150.dp)
                        .align(alignment = Alignment.CenterHorizontally))
                Text("Start Date: ",color = Color.LightGray)
                Text("End Date:",color = Color.LightGray)
                Text("Last Application Date:",color = Color.LightGray)

            }

   }
        Spacer(modifier = Modifier.padding(top=10.dp))
        Text("Positions:",color = Color.Black,fontWeight = FontWeight.Bold)
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = names) { name ->
                InternshipPositions("er",23)
            }
        }
    }

}

@Composable
fun InternshipPositions(name:String,position:Int){
    Column() {
        Text("Position Name: ",color = Color.DarkGray)
        Text("Position ID:",color = Color.DarkGray)
        Divider(color = Color.Black, modifier = Modifier
            .fillMaxWidth()
            .width(1.dp))
    }
    Spacer(modifier = Modifier.padding(top=5.dp))


}