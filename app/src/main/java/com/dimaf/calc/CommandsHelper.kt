package com.dimaf.calc

import android.util.Log

class CommandsHelper {

    // отвечает только за текст в табло
    var text = "0"
    // промежуточный результат (или конечный, по ситуации)
    var result : Long = 0
    // здесь память на 2 посл числа (tempNumber1 - самое первое, tempNumber2 - после него)
    var tempNumber1 : Long = 0
    var tempNumber2 : Long = 0

    var tempOperation = Consts.DEFAULT_OPERATION

    fun onClickButNumber (command: Int) : String  {
        return tvText(command)
    }

    fun onClickDelete() : String {
        return tvText(Consts.DELETE)
    }

    fun onClickReset() : String {
        tempOperation = Consts.DEFAULT_OPERATION
        result = 0
        return tvText(Consts.RESET)
    }



    fun onClickOperation(operation: Int) : String {
        if (tempOperation == Consts.DEFAULT_OPERATION) {
            tempOperation = operation
            result = text.toLong()
            text = "0"
            return result.toString()
        }
        tempNumber2 = text.toLong()
        calculate(result, tempNumber2, tempOperation)
        tempOperation = operation
        text = "0"
        return result.toString()
    }

    // для "равно"
    fun onClickEquals() : String {
        result = calculate(result, text.toLong(), tempOperation)
        return result.toString()
    }


    fun tvText(command : Int) : String {
        when (command) {
            1,2,3,4,5,6,7,8,9,0 -> text+=command
            Consts.DELETE -> text = text.dropLast(1)
            Consts.RESET -> text = "0"
        }
        // это потом надо убрать, типа чтоб не было "0" в начеле перед числом
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