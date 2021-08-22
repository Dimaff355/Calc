package com.dimaf.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.dimaf.calc.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val commandsHelper = CommandsHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            val button_1 = button1
            val button_2 = button2
            val button_3 = button3
            val button_4 = button4
            val button_5 = button5
            val button_6 = button6
            val button_7 = button7
            val button_8 = button8
            val button_9 = button9
            val button_0 = button0
            val buttonDelete = buttonDelete
            val buttonReset = buttonReset
            val buttonPlus = buttonPlus
            val buttonEquals = buttonEquals
            val buttonMinus = buttonMinus
            val buttonDivide = buttonDivide
            val buttonMultiply = buttonMultiply
            val buttonDot = buttonDot
            val buttonPercent = buttonPercent

            button_0.setOnClickListener { tv.text = commandsHelper.onClickButNumber(0) }
            button_1.setOnClickListener { tv.text = commandsHelper.onClickButNumber(1) }
            button_2.setOnClickListener { tv.text = commandsHelper.onClickButNumber(2) }
            button_3.setOnClickListener { tv.text = commandsHelper.onClickButNumber(3) }
            button_4.setOnClickListener { tv.text = commandsHelper.onClickButNumber(4) }
            button_5.setOnClickListener { tv.text = commandsHelper.onClickButNumber(5) }
            button_6.setOnClickListener { tv.text = commandsHelper.onClickButNumber(6) }
            button_7.setOnClickListener { tv.text = commandsHelper.onClickButNumber(7) }
            button_8.setOnClickListener { tv.text = commandsHelper.onClickButNumber(8) }
            button_9.setOnClickListener { tv.text = commandsHelper.onClickButNumber(9) }
            buttonDot.setOnClickListener { tv.text = commandsHelper.onClickButNumber(Consts.DOT) }
            buttonDelete.setOnClickListener { tv.text = commandsHelper.onClickDelete() }
            buttonDelete.setOnLongClickListener {
                tv.text = ""
                commandsHelper.text = "0"
                return@setOnLongClickListener true
            }
            buttonReset.setOnClickListener { tv.text = commandsHelper.onClickReset() }
            buttonPlus.setOnClickListener { tv.text = commandsHelper.onClickOperation(Consts.PLUS) }
            buttonEquals.setOnClickListener { tv.text = commandsHelper.onClickEquals() }
            buttonMinus.setOnClickListener { tv.text = commandsHelper.onClickOperation(Consts.MINUS ) }
            buttonDivide.setOnClickListener { tv.text = commandsHelper.onClickOperation(Consts.DIVIDE) }
            buttonMultiply.setOnClickListener { tv.text = commandsHelper.onClickOperation(Consts.MULTIPLY) }
            buttonPercent.setOnClickListener { tv.text = commandsHelper.percent() }

            tv.doAfterTextChanged {
                scrollView.smoothScrollTo(0, 100000)
            }

        }

    }





}

