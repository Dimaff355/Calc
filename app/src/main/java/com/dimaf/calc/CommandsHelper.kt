package com.dimaf.calc

import android.content.Context
import android.util.Log
import android.widget.Toast
import java.math.BigDecimal

class CommandsHelper {

    // отвечает только за текст в табло
    var text = "0"
    // промежуточный результат (или конечный, по ситуации)
    var result : BigDecimal = BigDecimal(0)
    // здесь память на посл число
    var tempNumber2 : BigDecimal = BigDecimal(0)

    var tempOperation = Consts.DEFAULT_OPERATION

    fun onClickButNumber (command: Int) : String  {
        return tvText(command)
    }

    fun onClickDelete() : String {
        return tvText(Consts.DELETE)
    }

    fun onClickReset() : String {
        tempOperation = Consts.DEFAULT_OPERATION
        result = BigDecimal(0)
        return tvText(Consts.RESET)
    }



    fun onClickOperation(operation: Int, context : Context) : String {
        if (tempOperation == Consts.DEFAULT_OPERATION) {
            tempOperation = operation
            result = text.toBigDecimal()
            text = "0"
            return result.toString()
        }
        tempNumber2 = text.toBigDecimal()
        calculate(result, tempNumber2, tempOperation, context)
        tempOperation = operation
        text = "0"
        return result.toString()
    }

    // для "равно"
    fun onClickEquals(context: Context) : String {
        result = calculate(result, text.toBigDecimal(), tempOperation, context)
        return result.toString()
    }


    fun tvText(command : Int) : String {
        when (command) {
            1,2,3,4,5,6,7,8,9,0 -> text+=command
            Consts.DELETE -> text = text.dropLast(1)
            Consts.RESET -> {
                text = "0"
                tempOperation = Consts.DEFAULT_OPERATION
            }
            Consts.DOT -> text+="."
        }
        // это потом надо убрать, типа чтоб не было "0" в начеле перед числом
        if (text.count() > 1 && text[0] == '0') {
            text = text.drop(1)
        }
        return text
    }

    fun calculate (tempNumber : BigDecimal, currentNumber : BigDecimal, operation : Int, context : Context) : BigDecimal {
        if (tempOperation != Consts.DEFAULT_OPERATION) {
            return when (operation) {
                Consts.PLUS ->  tempNumber + currentNumber
                Consts.MINUS -> tempNumber - currentNumber
                Consts.DIVIDE -> if (currentNumber != BigDecimal(0)) {
                    return tempNumber / currentNumber
                } else {
                    Toast.makeText(context, "На ноль делить нельзя!", Toast.LENGTH_LONG).show()
                    tvText(Consts.RESET)
                    return BigDecimal(0)
                }
                Consts.MULTIPLY -> tempNumber * currentNumber
                else -> BigDecimal(0)
            }
        } else {return  BigDecimal(0)}
    }



}