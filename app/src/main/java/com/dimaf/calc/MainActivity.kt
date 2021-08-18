package com.dimaf.calc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.dimaf.calc.databinding.ActivityMainBinding

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

            button_0.setOnClickListener { tv.text = commandsHelper.onClickButNumber(0, it) }


            button_1.setOnClickListener { tv.text = commandsHelper.onClickButNumber(1, it) }
            button_2.setOnClickListener { tv.text = commandsHelper.onClickButNumber(2, it) }
            button_3.setOnClickListener { tv.text = commandsHelper.onClickButNumber(3, it) }
            button_4.setOnClickListener { tv.text = commandsHelper.onClickButNumber(4, it) }
            button_5.setOnClickListener { tv.text = commandsHelper.onClickButNumber(5, it) }
            button_6.setOnClickListener { tv.text = commandsHelper.onClickButNumber(6, it) }
            button_7.setOnClickListener { tv.text = commandsHelper.onClickButNumber(7, it) }
            button_8.setOnClickListener { tv.text = commandsHelper.onClickButNumber(8, it) }
            button_9.setOnClickListener { tv.text = commandsHelper.onClickButNumber(9, it) }
            buttonDot.setOnClickListener { tv.text = commandsHelper.onClickButNumber(Consts.DOT, it) }
            buttonDelete.setOnClickListener { tv.text = commandsHelper.onClickDelete() }
            buttonReset.setOnClickListener { tv.text = commandsHelper.onClickReset() }
            buttonPlus.setOnClickListener { tv.text = commandsHelper.onClickOperation(Consts.PLUS, it) }
            buttonEquals.setOnClickListener { tv.text = commandsHelper.onClickEquals(it) }
            buttonMinus.setOnClickListener { tv.text = commandsHelper.onClickOperation(Consts.MINUS, it ) }
            buttonDivide.setOnClickListener { tv.text = commandsHelper.onClickOperation(Consts.DIVIDE, it) }
            buttonMultiply.setOnClickListener { tv.text = commandsHelper.onClickOperation(Consts.MULTIPLY, it) }
            //buttonPercent.setOnClickListener { tv.text = commandsHelper.onClickOperation(Consts.PERCENT) }

        }

    }





}

