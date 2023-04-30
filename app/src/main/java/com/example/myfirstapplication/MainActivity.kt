package com.example.myfirstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpUi()
        }
    }
}

@Composable
fun SignUpUi() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(Color(0xFFA8DBFF), Color(0XFFF7FBFF))
                )
            )
    ) {

        Image(
            painter = painterResource(id = R.drawable.signup_page),
            contentDescription = "signUp"
        )

        Text(
            text = "Create Account",
            color = Color.Black,
            fontSize = 33.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 200.dp, start = 75.dp)
        )

        val firstName = remember { mutableStateOf("") }
        val lastName = remember { mutableStateOf("") }
        OutlinedTextField(
            value = firstName.value,
            onValueChange = { firstName.value = it },
            modifier = Modifier
                .background(Color.Transparent)
                .padding(90.dp, 300.dp),
            textStyle = TextStyle(Color.Black),
            label = {
                Text(text = "First Name", color = Color.Gray)
            },
            singleLine = true,
            placeholder = { Text(text = "type here...")},
            shape = RoundedCornerShape(20.dp)
        )
        OutlinedTextField(
            value = lastName.value,
            onValueChange = { lastName.value = it },
            modifier = Modifier
                .background(Color.Transparent)
                .padding(90.dp, 380.dp),
            textStyle = TextStyle(Color.Black),
            label = {
                Text(text = "Last Name", color = Color.Gray)
            },
            singleLine = true,
            placeholder = { Text(text = "type here...")},
            shape = RoundedCornerShape(20.dp)
        )

        val rememberMe = remember { mutableStateOf(false)}
        Row {
            Checkbox(
                checked = rememberMe.value ,
                onCheckedChange = {rememberMe.value = it},
                modifier = Modifier.padding(start = 110.dp, top = 480.dp),
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFFC9A7EB))
            )
            Text(
                text = "Remember me",
                modifier = Modifier.padding(top = 495.dp),
                color = Color.Gray
            )
        }

        Button(
            onClick = {},
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .padding(start = 100.dp, top = 600.dp)
                .height(50.dp)
                .width(200.dp)
                .border(0.75.dp, Color(0xFF19A7CE), RoundedCornerShape(50.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0XFF62CDFF),
                contentColor = Color.White
            )
        ) {
            Text(
                text ="Sign Up",
                fontWeight = FontWeight.SemiBold
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SignUpUi()
}