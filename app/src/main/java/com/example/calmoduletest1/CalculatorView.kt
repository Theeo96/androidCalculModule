package com.example.calmoduletest1

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

class CalculatorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val calculatorLogic = CalculatorLogic()
    private lateinit var display: EditText
    private var onResultListener: ((String) -> Unit)? = null


    init {
        inflate(context, R.layout.calculator_layout, this)
        initializeViews()
        setupListeners()
    }

    private fun initializeViews() {
        display = findViewById(R.id.display)
    }


    fun setOnResultListener(listener: (String) -> Unit) {
        onResultListener = listener
    }

    private fun setupListeners() {
        // 숫자 버튼
        for (i in 0..9) {
            findViewById<Button>(resources.getIdentifier("btn$i", "id", context.packageName))
                .setOnClickListener {
                    display.setText(calculatorLogic.inputNumber(i.toString()))
                }
        }

        // 연산자 버튼
        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            display.setText(calculatorLogic.inputOperation("+"))
        }
        findViewById<Button>(R.id.btnMinus).setOnClickListener {
            display.setText(calculatorLogic.inputOperation("-"))
        }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener {
            display.setText(calculatorLogic.inputOperation("*"))
        }
        findViewById<Button>(R.id.btnDivide).setOnClickListener {
            display.setText(calculatorLogic.inputOperation("/"))
        }

        // 소수점 버튼
        findViewById<Button>(R.id.btnDot).setOnClickListener {
            display.setText(calculatorLogic.inputDecimal())
        }

        // 초기화 버튼
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            display.setText(calculatorLogic.clear())
        }

        // 결과 버튼
        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            val result = calculatorLogic.calculate()
            display.setText(result)
            onResultListener?.invoke(result)
        }
    }
}