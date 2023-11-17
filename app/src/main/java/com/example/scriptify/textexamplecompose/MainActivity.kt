package com.example.scriptify.textexamplecompose

import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scriptify.textexamplecompose.ui.theme.TextExampleComposeTheme
public var fonts = FontFamily(Font( R.font.bebasneue_regular))
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        val repo : UserRepo = UserRepo()
        setContent {
            Box(modifier = Modifier.fillMaxSize()){

                scaffold()
                Login(repo.users)
            }


        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun scaffold(){
    Scaffold(bottomBar = { BottomAppBar(
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        Text("Bottom app bar")
    }}) {padding->

        Text(text = "Hello", modifier = Modifier.padding(padding))

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun Login(
    listOfUsers:List<User>
){
    var inputName by remember {
        mutableStateOf("")
    }
    var inputPassword by remember {
        mutableStateOf("")
    }
    var name: String by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xff101010))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .background(Color(0xff101010))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xff101010))
                    .padding(24.dp), contentAlignment = Alignment.Center
            ) {
                Text(
                    "Jetpack Compose",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fonts,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic
                )

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray, shape = RoundedCornerShape(24.dp)),
                contentAlignment = Alignment.TopCenter
            ) {
                TextField(value = inputName, onValueChange = { inputName = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth())
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 24.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                TextField(value = inputPassword, onValueChange = { inputPassword = it },
                    label = { Text("Password") },
                    singleLine = true,
                    visualTransformation =  PasswordVisualTransformation(),
                    keyboardOptions =KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth())
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 24.dp),
                contentAlignment = Alignment.TopCenter
            ) {
               Button(onClick = {
                                for(user in listOfUsers){
                                    if(user.name == inputName && user.password == inputPassword){
                                        name = inputName
                                        password = inputPassword
                                        return@Button
                                    }else{
                                        name = "Krivi"
                                        password = "Podaci"
                                    }
                                }
                                },
                   modifier = Modifier.fillMaxWidth(0.5f),
                   ) {
                    Text(text = "Send Data")
               }

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 24.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(text = name, color = Color.White)

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 24.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(text = password, color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun preview(){
    Login(listOfUsers = listOf())
}



