package com.example.heartratelimits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.heartratelimits.ui.theme.HeartRateLimitsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeartRateLimitsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    HeartRateLimits(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
}


@Preview(showBackground = true)
@Composable
fun  HeartRateLimitsPreview() {
    HeartRateLimitsTheme {
        HeartRateLimits()
    }
}
@Composable
fun HeartRateLimits( modifier: Modifier = Modifier) {
    var age by remember { mutableStateOf("") }
    val ageNumber = age.toIntOrNull() ?: 0
    val lowerLimit = (220 - ageNumber) * 0.65
    val upperLimit = (220 - ageNumber) * 0.85
    Column(modifier = modifier) {
        Text(stringResource(R.string.age))
        TextField(
            value = age,
            onValueChange = { age = it }
        )
        Text(stringResource(R.string.heart_rate_limits))
        if (ageNumber > 0) {
            Text("${String.format("%.2f", lowerLimit)} - ${String.format("%.2f", upperLimit)}")
        }
    }
}
}