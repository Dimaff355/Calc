package com.dimaf.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimaf.calc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val commandsHelper = CommandsHelper()

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
            val buttomEquals = buttonEquals

            button_0.setOnClickListener {
                commandsHelper.onClickBut0()
            }
            button_1.setOnClickListener { tv.text = commandsHelper.onClickBut1() }
            button_2.setOnClickListener { tv.text = commandsHelper.onClickBut2() }
            button_3.setOnClickListener { tv.text = commandsHelper.onClickBut3() }
            button_4.setOnClickListener { tv.text = commandsHelper.onClickBut4() }
            button_5.setOnClickListener { tv.text = commandsHelper.onClickBut5() }
            button_6.setOnClickListener { tv.text = commandsHelper.onClickBut6() }
            button_7.setOnClickListener { tv.text = commandsHelper.onClickBut7() }
            button_8.setOnClickListener { tv.text = commandsHelper.onClickBut8() }
            button_9.setOnClickListener { tv.text = commandsHelper.onClickBut9() }
            buttonDelete.setOnClickListener { tv.text = commandsHelper.onClickDelete() }
            buttonReset.setOnClickListener { tv.text = commandsHelper.onClickReset() }
            buttonPlus.setOnClickListener { tv.text = commandsHelper.onClickPlus() }
            buttonEquals.setOnClickListener { tv.text = commandsHelper.onClickEquals() }

        }

    }





}

