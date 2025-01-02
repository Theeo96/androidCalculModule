package com.example.calmoduletest1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calmoduletest1.ui.theme.CalModuleTest1Theme
import android.util.Log


class MainActivity : ComponentActivity() {
    private lateinit var calculatorView: CalculatorView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 계산기 뷰 초기화
        calculatorView = findViewById(R.id.calculatorView)

        // 계산기 결과를 로그로 확인하기 위한 테스트 코드
        calculatorView.setOnResultListener { result ->
            Log.d("Calculator", "계산 결과: $result")
        }
    }
}