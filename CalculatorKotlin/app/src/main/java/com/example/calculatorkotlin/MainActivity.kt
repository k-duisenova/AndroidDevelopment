package com.example.calculatorkotlin

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import kotlin.math.*


class MainActivity : FragmentActivity() {

    private var text: TextView? = null
    private var process: String? = ""
    private var textDisplay: String? = null
    private var longClicked = false
    private var valueOne = 0.0
    private var valueTwo = 0.0
    private var res = 0.0
    private var operation = 0.toChar()
    private var isOperationClicked = false
    private var isResultCalculated = false
    private var isCleared = false
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        valueOne = savedInstanceState.getDouble("valueOne")
        valueTwo = savedInstanceState.getDouble("valueTwo")
        res = savedInstanceState.getDouble("res")
        longClicked = savedInstanceState.getBoolean("longClicked")
        process = savedInstanceState.getString("process")
        operation = savedInstanceState.getChar("operation")
        isOperationClicked = savedInstanceState.getBoolean("isOperationClicked")
        isResultCalculated = savedInstanceState.getBoolean("isResultCalculated")
        isCleared = savedInstanceState.getBoolean("isCleared")
        textDisplay = savedInstanceState.getString("text")
        text!!.text = textDisplay
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("valueOne", valueOne)
        outState.putDouble("valueTwo", valueTwo)
        outState.putDouble("res", res)
        outState.putBoolean("longClicked", longClicked)
        outState.putString("process", process)
        outState.putChar("operation", operation)
        outState.putBoolean("isOperationClicked", isOperationClicked)
        outState.putBoolean("isResultCalculated", isResultCalculated)
        outState.putBoolean("isCleared", isCleared)
        outState.putString("text", text!!.text.toString())
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonPlus: Button = findViewById(R.id.plus_button)
        val buttonMinus: Button = findViewById(R.id.minus_button)
        val buttonMulti: Button = findViewById(R.id.multiply_button)
        val buttonDel: Button = findViewById(R.id.del_button)
        val buttonDiv: Button = findViewById(R.id.divide_button)
        val buttonSqr: Button = findViewById(R.id.sqr_button)
        val buttonSqrt: Button = findViewById(R.id.sqrt_button)
        val buttonClr: Button = findViewById(R.id.clear_button)
        val buttonEquals: Button = findViewById(R.id.res_button)
        val buttonDot: Button = findViewById(R.id.dot_button)
        val buttonPercent: Button = findViewById(R.id.percent_button)
        val buttonFactorial: Button? = findViewById(R.id.factorial_button)
        val buttonPower: Button? = findViewById(R.id.power_button)
        val buttonRoot: Button? = findViewById(R.id.root_button)
        val buttonSin: Button? = findViewById(R.id.sin_button)
        val buttonCos: Button? = findViewById(R.id.cos_button)
        val buttonTan: Button? = findViewById(R.id.tan_button)
        val buttonLn: Button? = findViewById(R.id.ln_button)
        val buttonLog: Button? = findViewById(R.id.log_button)
        val buttonPi: Button? = findViewById(R.id.pi)
        text = findViewById(R.id.text_view)
        buttonClr.setOnClickListener {
            text?.text = ""
            isCleared = true
        }
        buttonDel.setOnClickListener {
            var txt = text?.text.toString()
            if (txt.isNotEmpty() && text?.text !== "0") {
                if (txt == "error") {
                    text?.text = ""
                } else {
                    txt = txt.substring(0, txt.length - 1)
                    text?.text = txt
                }
            }
            isCleared = false
        }
        buttonDel.setOnLongClickListener {
            text?.text = ""
            isCleared = true
            true.also { longClicked = it }
        }
        button0.setOnClickListener {
            if (isResultCalculated || text?.text === "error") {
                buttonClr.performClick()
                text?.append("0")
                isResultCalculated = false
            } else text?.append("0")
            isOperationClicked = false
            isCleared = false
        }
        button1.setOnClickListener {
            if (text?.text.toString() == "0") {
                text?.text = "1"
            } else if (isResultCalculated || text?.text === "error") {
                buttonClr.performClick()
                text?.append("1")
                isResultCalculated = false
            } else text?.append("1")
            isOperationClicked = false
            isCleared = false
        }
        button2.setOnClickListener {
            if (text?.text.toString() == "0") {
                text?.text = "2"
            } else if (isResultCalculated || text?.text === "error") {
                buttonClr.performClick()
                text?.append("2")
                isResultCalculated = false
            } else text?.append("2")
            isOperationClicked = false
            isCleared = false
        }
        button3.setOnClickListener {
            if (text?.text.toString() == "0") {
                text?.text = "3"
            } else if (isResultCalculated || text?.text === "error") {
                buttonClr.performClick()
                text?.append("3")
                isResultCalculated = false
            } else text?.append("3")
            isOperationClicked = false
            isCleared = false
        }
        button4.setOnClickListener {
            if (text?.text.toString() == "0") {
                text?.text = "4"
            } else if (isResultCalculated || text?.text === "error") {
                buttonClr.performClick()
                text?.append("4")
                isResultCalculated = false
            } else text?.append("4")
            isOperationClicked = false
            isCleared = false
        }
        button5.setOnClickListener {
            if (text?.text.toString() == "0") {
                text?.text = "5"
            } else if (isResultCalculated || text?.text === "error") {
                buttonClr.performClick()
                text?.append("5")
                isResultCalculated = false
            } else text?.append("5")
            isOperationClicked = false
            isCleared = false
        }
        button6.setOnClickListener {
            if (text?.text.toString() == "0") {
                text?.text = "6"
            } else if (isResultCalculated || text?.text === "error") {
                buttonClr.performClick()
                text?.append("6")
                isResultCalculated = false
            } else text?.append("6")
            isOperationClicked = false
            isCleared = false
        }
        button7.setOnClickListener {
            if (text?.text.toString() == "0") {
                text?.text = "7"
            } else if (isResultCalculated || text?.text === "error") {
                buttonClr.performClick()
                text?.append("7")
                isResultCalculated = false
            } else text?.append("7")
            isOperationClicked = false
            isCleared = false
        }
        button8.setOnClickListener {
            if (text?.text.toString() == "0") {
                text?.text = "8"
            } else if (isResultCalculated || text?.text === "error") {
                buttonClr.performClick()
                text?.append("8")
                isResultCalculated = false
            } else text?.append("8")
            isOperationClicked = false
            isCleared = false
        }
        button9.setOnClickListener {
            if (text?.text.toString() == "0") {
                text?.text = "9"
            } else if (isResultCalculated || text?.text === "error") {
                buttonClr.performClick()
                text?.append("9")
                isResultCalculated = false
            } else text?.append("9")
            isOperationClicked = false
            isCleared = false
        }
        buttonDot.setOnClickListener {
            val s = text?.text.toString()
            if (isResultCalculated || text?.text === "error") {
                buttonClr.performClick()
                text?.append("0.")
                isResultCalculated = false
            } else if (s.isEmpty()) {
                text?.append("0.")
            } else if (!s.contains(".")) {
                text?.append(".")
            }
            isCleared = false
        }
        buttonPlus.setOnClickListener(View.OnClickListener {
            if (text?.text === "error") {
                return@OnClickListener
            }
            if (text?.text == "") {
                return@OnClickListener
            }
            if (!isOperationClicked) {
                try {
                    operation = '+'
                    isOperationClicked = true
                    valueOne = text?.text.toString().toDouble()
                    text?.text = ""
                } catch (nfe: NumberFormatException) {
                    text?.text = "error"
                }
            } else {
                operation = '+'
            }
            if (isOperationClicked) {
                return@OnClickListener
            }
            isCleared = false
        })
        buttonMinus.setOnClickListener(View.OnClickListener {
            if (text?.text === "error") {
                return@OnClickListener
            }
            if (text?.text == "") {
                return@OnClickListener
            }
            if (!isOperationClicked) {
                operation = '-'
                try {
                    isOperationClicked = true
                    valueOne = text?.text.toString().toDouble()
                    text?.text = ""
                } catch (nfe: NumberFormatException) {
                    text?.text = "error"
                }
            } else {
                operation = '-'
            }
            if (isOperationClicked) {
                return@OnClickListener
            }
            isCleared = false
        })
        buttonMulti.setOnClickListener(View.OnClickListener {
            if (text?.text === "error") {
                return@OnClickListener
            }
            if (text?.text == "") {
                return@OnClickListener
            }
            if (!isOperationClicked) {
                operation = '*'
                try {
                    isOperationClicked = true
                    valueOne = text?.text.toString().toDouble()
                    text?.text = ""
                } catch (nfe: NumberFormatException) {
                    text?.text = "error"
                }
            } else {
                operation = '*'
            }
            if (isOperationClicked) {
                return@OnClickListener
            }
            isCleared = false
        })
        buttonDiv.setOnClickListener(View.OnClickListener {
            if (text?.text === "error") {
                return@OnClickListener
            }
            if (text?.text == "") {
                return@OnClickListener
            }
            if (!isOperationClicked) {
                operation = '/'
                try {
                    valueOne = text?.text.toString().toDouble()
                    isOperationClicked = true
                    text?.text = ""
                } catch (nfe: NumberFormatException) {
                    text?.text = "error"
                }
            } else {
                operation = '/'
            }
            if (isOperationClicked) {
                return@OnClickListener
            }
            isCleared = false
        })
        buttonSqr.setOnClickListener(View.OnClickListener {
            if (text?.text === "error") {
                return@OnClickListener
            }
            if (isOperationClicked) {
                return@OnClickListener
            }
            if (text?.text !== "") {
                try {
                    valueOne = text?.text.toString().toDouble()
                    res = valueOne * valueOne
                    process = res.toString()
                    text?.text = process
                } catch (nfe: NumberFormatException) {
                    text?.text = "error"
                }
                isResultCalculated = true
            }
            isCleared = false
        })
        buttonSqrt.setOnClickListener(View.OnClickListener {
            if (text?.text === "error") {
                return@OnClickListener
            }
            if (isOperationClicked) {
                return@OnClickListener
            }
            if (text?.text !== "") {
                try {
                    valueOne = text?.text.toString().toDouble()
                    res = sqrt(valueOne)
                    process = res.toString()
                    text?.text = process
                } catch (nfe: NumberFormatException) {
                    text?.text = "error"
                }
                isResultCalculated = true
            }
            isCleared = false
        })
        buttonPercent.setOnClickListener(View.OnClickListener {
            if (text?.text === "error") {
                return@OnClickListener
            }
            if (isOperationClicked) {
                return@OnClickListener
            }
            if (text?.text !== "") {
                try {
                    valueOne = text?.text.toString().toDouble()
                    res = valueOne / 100
                    process = res.toString()
                    text?.text = process
                } catch (nfe: NumberFormatException) {
                    text?.text = "error"
                }
                isResultCalculated = true
            }
            isCleared = false
        })
        buttonEquals.setOnClickListener(View.OnClickListener {
            if (isCleared) {
                return@OnClickListener
            }
            if (isOperationClicked && !isResultCalculated && text?.text === "") {
                return@OnClickListener
            }
            if (isResultCalculated) {
                return@OnClickListener
            }
            if (text?.text === "") {
                return@OnClickListener
            }
            if (text?.text == "error") {
                return@OnClickListener
            } else {
                valueTwo = text?.text.toString().toDouble()
                when (operation) {
                    '+' -> {
                        res = valueOne + valueTwo
                        process = res.toString()
                        text?.text = process
                    }
                    '-' -> {
                        res = valueOne - valueTwo
                        process = res.toString()
                        text?.text = process
                    }
                    '*' -> {
                        res = valueOne * valueTwo
                        process = res.toString()
                        text?.text = process
                    }
                    'p' -> {
                        res = valueOne.pow(valueTwo)
                        process = res.toString()
                        text?.text = process
                    }
                    '/' -> if (valueTwo != 0.0) {
                        res = valueOne / valueTwo
                        process = res.toString()
                        text?.text = process
                    } else {
                        text?.text = "error"
                    }
                    'r' -> if (valueTwo == 0.0) {
                        text?.text = "error"
                    } else {
                        res = valueOne.pow(1 / valueTwo)
                        process = res.toString()
                        text?.text = process
                    }
                }
                isResultCalculated = true
                isOperationClicked = false
            }
        })
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            buttonSin!!.setOnClickListener(View.OnClickListener {
                if (isOperationClicked) {
                    return@OnClickListener
                }
                if (text?.text !== "") {
                    try {
                        valueOne = text?.text.toString().toDouble()
                        res = sin(Math.toRadians(valueOne))
                        process = res.toString()
                        text?.text = process
                    } catch (nfe: java.lang.NumberFormatException) {
                        text?.text = "error"
                    }
                    isResultCalculated = true
                }
                isCleared = false
            })
            buttonCos!!.setOnClickListener(View.OnClickListener {
                if (isOperationClicked) {
                    return@OnClickListener
                }
                if (text?.text !== "") {
                    try {
                        valueOne = text?.text.toString().toDouble()
                        res = cos(Math.toRadians(valueOne))
                        process = res.toString()
                        text?.text = process
                    } catch (nfe: java.lang.NumberFormatException) {
                        text?.text = "error"
                    }
                    isResultCalculated = true
                }
                isCleared = false
            })
            buttonTan!!.setOnClickListener(View.OnClickListener {
                if (isOperationClicked) {
                    return@OnClickListener
                }
                if (text?.text !== "") {
                    try {
                        valueOne = text?.text.toString().toDouble()
                        res = tan(Math.toRadians(valueOne))
                        process = res.toString()
                        text?.text = process
                    } catch (nfe: java.lang.NumberFormatException) {
                        text?.text = "error"
                    }
                    isResultCalculated = true
                }
                isCleared = false
            })
            buttonFactorial!!.setOnClickListener(View.OnClickListener {
                if (isOperationClicked) {
                    return@OnClickListener
                }
                if (text?.text !== "") {
                    res = 1.0
                    try {
                        valueOne = text?.text.toString().toDouble()
                        if (valueOne < 0 || valueOne > 60) {
                            text?.text = "error"
                        } else if (valueOne == 0.0) {
                                res = 1.0
                        } else {
                            for (i in 1..valueOne.toInt()) {
                                    res *= i
                            }
                        }
                        process = res.toString()
                        text?.text = process
                    } catch (nfe: java.lang.NumberFormatException) {
                        text?.text = "error"
                    }
                    isResultCalculated = true
                }
                isCleared = false
            })
            buttonLn!!.setOnClickListener(View.OnClickListener {
                if (isOperationClicked) {
                    return@OnClickListener
                }
                if (text?.text !== "") {
                    try {
                        res = ln(valueOne)
                        process = res.toString()
                        text?.text = process
                    } catch (nfe: java.lang.NumberFormatException) {
                        text?.text = "error"
                    }
                    isResultCalculated = true
                }
                isCleared = false
            })
            buttonLog!!.setOnClickListener(View.OnClickListener {
                if (isOperationClicked) {
                    return@OnClickListener
                }
                if (text?.text !== "") {
                    try {
                        res = ln(valueOne)
                        process = res.toString()
                        text?.text = process
                    } catch (nfe: java.lang.NumberFormatException) {
                        text?.text = "error"
                    }
                    isResultCalculated = true
                }
                isCleared = false
            })
            buttonPi!!.setOnClickListener {
                when {
                    text?.text.toString() == "0" -> {
                        text?.text = Math.PI.toString()
                    }
                    isResultCalculated -> {
                        buttonClr.performClick()
                        text?.append(Math.PI.toString())
                        isResultCalculated = false
                    }
                    else -> text?.append(Math.PI.toString())
                }
                isOperationClicked = false
                isCleared = false
            }
            buttonPower!!.setOnClickListener(View.OnClickListener {
                if (text?.text == "") {
                    return@OnClickListener
                }
                if (!isOperationClicked) {
                    operation = 'p'
                    try {
                        isOperationClicked = true
                        valueOne = text?.text.toString().toDouble()
                        text?.text = ""
                    } catch (nfe: java.lang.NumberFormatException) {
                        text?.text = "error"
                    }
                } else {
                    operation = 'p'
                }
                if (isOperationClicked) {
                    return@OnClickListener
                }
                isCleared = false
            })
            buttonRoot!!.setOnClickListener(View.OnClickListener {
                if (text?.text == "") {
                    return@OnClickListener
                }
                if (!isOperationClicked) {
                    operation = 'r'
                    try {
                        isOperationClicked = true
                        valueOne = text?.text.toString().toDouble()
                        text?.text = ""
                    } catch (nfe: java.lang.NumberFormatException) {
                        text?.text = "error"
                    }
                } else {
                    operation = 'r'
                }
                if (isOperationClicked) {
                    return@OnClickListener
                }
                isCleared = false
            })
        }
    }
}
