package com.dimaf.calc

import android.util.Log

class CommandsHelper {

    var text = "0"
    var result : Long = 0
    var tempNumber : Long = 0
    var tempOperation = Consts.DEFAULT_OPERATION

    fun onClickBut0() : String {
        if (text == "0") {
            return text
        }
        return tvText(0)
    }
    fun onClickBut1() : String  {
        return tvText(1)
    }
    fun onClickBut2() : String {
        return tvText(2)
    }
    fun onClickBut3(): String  {
        return tvText(3)
    }
    fun onClickBut4() : String {
        return tvText(4)
    }
    fun onClickBut5() : String {
        return tvText(5)
    }
    fun onClickBut6() : String {
        return tvText(6)
    }
    fun onClickBut7(): String  {
        return tvText(7)
    }
    fun onClickBut8(): String  {
        return tvText(8)
    }
    fun onClickBut9(): String  {
        return tvText(9)
    }
    fun onClickDelete() : String {
        return tvText(Consts.DELETE)
    }

    fun onClickReset() : String {
        tempOperation = Consts.DEFAULT_OPERATION
        result = 0
        return tvText(Consts.RESET)
    }

    fun onClickPlus(): String {
        when (tempOperation) {
            Consts.DEFAULT_OPERATION -> result = text.toLong()
            Consts.AFTER_EQUALS -> {
                tempOperation = Consts.PLUS
            }
            else -> {
                result = calculate(result, text.toLong(), tempOperation)
            }
        }
        tempNumber = text.toLong()
        tempOperation = Consts.PLUS
        text = "0"
        return result.toString()
    }

    // для "равно"
    fun onClickEquals() : String {
        result = calculate(result, text.toLong(), tempOperation)
        tempOperation = Consts.AFTER_EQUALS
        return result.toString()
    }


    fun tvText(command : Int) : String {
        when (command) {
            1,2,3,4,5,6,7,8,9,0 -> text+=command
            Consts.DELETE -> text = text.dropLast(1)
            Consts.RESET -> text = "0"
        }
        if (text.count() > 1 && text[0] == '0') {
            text = text.drop(1)
        }
        return text
    }

    fun calculate (tempNumber : Long, currentNumber : Long, operation : Int) : Long {
        if (tempOperation != Consts.DEFAULT_OPERATION) {
            return when (operation) {
                Consts.PLUS -> tempNumber + currentNumber
                Consts.MINUS -> tempNumber - currentNumber
                Consts.DIVIDE -> tempNumber / currentNumber
                Consts.MULTIPLY -> tempNumber * currentNumber
                else -> 0L
            }
        } else {return  0}
    }



}