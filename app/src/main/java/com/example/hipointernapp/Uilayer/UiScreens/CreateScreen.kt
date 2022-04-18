@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.hipointernapp.Uilayer.UiScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hipointernapp.Domain.UserInfoInput

import com.example.hipointernapp.ui.theme.HipoInternAppTheme
import com.example.hipointernapp.ui.theme.LittleBlack


@Composable
fun CreateapplicationScreen(){
    var applicationStatus by rememberSaveable { mutableStateOf(false) }

  if(applicationStatus){
      applicationResultScreen(onBack = {applicationStatus=false})
  }
    else{
      applicationInputScreen(onSubmit = {applicationStatus=true})
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun applicationInputScreen(onSubmit:()->Unit){
    var userInput : UserInfoInput
    var Nametext by remember { mutableStateOf("") }
    var Emailtext by remember { mutableStateOf("") }
    var Notetext by remember { mutableStateOf("") }
    var Cvtext by remember { mutableStateOf("") }
    val keyboardController =  LocalSoftwareKeyboardController.current

    val (focusEmail,focusNote,focusCv) = remember { FocusRequester.createRefs()}

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = Nametext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally),
            onValueChange = { Nametext = it },
            label = { Text("NAME:", color = LittleBlack,fontSize=20.sp) },
            placeholder={ Text("Bob") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {focusEmail.requestFocus()}),
            maxLines= 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor= Color.Magenta,focusedBorderColor= LittleBlack)
        )
        OutlinedTextField(
            value = Emailtext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusEmail),
            onValueChange = { Emailtext = it },
            label = { Text("EMAIL:", color = LittleBlack,fontSize=20.sp) },
            placeholder={ Text("Bob@gmail.com") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email,imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {focusNote.requestFocus()}),
            maxLines= 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor= Color.Magenta,focusedBorderColor= LittleBlack)
        )
        OutlinedTextField(
            value = Notetext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusNote),
            onValueChange = { Notetext = it },
            label = { Text("NOTE:", color = LittleBlack,fontSize=20.sp) },
            placeholder={ Text("Reason for application") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {focusCv.requestFocus()}),
            maxLines= 4,
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor= Color.Magenta,focusedBorderColor= LittleBlack)
        )
        OutlinedTextField(
            value = Cvtext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusCv),
            onValueChange = { Cvtext = it },
            label = { Text("CV:", color = LittleBlack,fontSize=20.sp) },
            placeholder={ Text("Your Cv in base64(PDF)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions (onDone = {keyboardController?.hide()}),
            maxLines= 4,
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor= Color.Magenta,focusedBorderColor= LittleBlack)
        )

        Spacer(modifier = Modifier.padding(top=10.dp))
        Button(
            onClick = onSubmit ,
            // Uses ButtonDefaults.ContentPadding by default
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ){
            Text("SUBMIT")
        }



    }



}




@Composable
fun applicationResultScreen(onBack:()->Unit){
Column() {
    Card( backgroundColor =  LittleBlack,elevation = 7.dp, modifier = Modifier
        .fillMaxWidth()
        .padding(2.dp), shape = RoundedCornerShape(8.dp)
    ){
        Column(modifier = Modifier.fillMaxWidth()) {
            Text("Name:",color = Color.LightGray)
            Text("Email:",color = Color.LightGray)
            Text("Position",color = Color.LightGray)
            Text("Id",color = Color.LightGray)
            Text("Start Date: ",color = Color.LightGray)
            Text("End Date:",color = Color.LightGray)

        }

    }
    Spacer(modifier = Modifier.padding(top=10.dp))
    Button(
        onClick = onBack,
        // Uses ButtonDefaults.ContentPadding by default
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
    ){
        Text("BACK")
    }
}




}
@Preview(showBackground = true, widthDp = 250, heightDp = 500)
@Composable
fun CreateInternresult(){
    applicationResultScreen ({})
}
@Preview(showBackground = true, widthDp = 250, heightDp = 500)
@Composable
fun CreatePreview() {
    HipoInternAppTheme {
        applicationInputScreen({})
    }
}
