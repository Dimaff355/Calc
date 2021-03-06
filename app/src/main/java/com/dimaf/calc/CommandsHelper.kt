package com.dimaf.calc

import android.widget.Toast
import java.math.BigDecimal
import java.math.RoundingMode

class CommandsHelper (act : MainActivity) {
    val act = act

    // отвечает только за текст в табло
    var text = "0"
    // промежуточный результат (или конечный, по ситуации)
    var result : BigDecimal = BigDecimal(0)
    // здесь память на посл число
    var tempNumber : BigDecimal = BigDecimal(0)

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



    fun onClickOperation(operation: Int) : String {
        if (isNoValue()) return "0"
        if (tempOperation == Consts.DEFAULT_OPERATION) {
            tempOperation = operation
            result = text.toBigDecimal()
            text = "0"
            return result.toString()
        }
        tempNumber = text.toBigDecimal()
        calculate(result, tempNumber, tempOperation)
        tempOperation = operation
        text = "0"
        return result.toString()
    }

    // для "равно"
    fun onClickEquals() : String {
        if (isNoValue()) return "0"
        if (tempOperation == Consts.DEFAULT_OPERATION) {
            return text
        }
        result = calculate(result, text.toBigDecimal(), tempOperation)
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

    fun calculate (numberLast : BigDecimal, currentNum : BigDecimal, operation : Int) : BigDecimal {
        if (tempOperation != Consts.DEFAULT_OPERATION) {
            return when (operation) {
                Consts.PLUS -> numberLast + currentNum
                Consts.MINUS -> numberLast - currentNum
                Consts.DIVIDE -> try {
                    return numberLast.divide(currentNum, 10, RoundingMode.HALF_UP).stripTrailingZeros()
                } catch (e : ArithmeticException) {
                    Toast.makeText(act, "На ноль делить нельзя!", Toast.LENGTH_LONG).show()
                    tvText(Consts.RESET)
                    return BigDecimal(0)
                }
                Consts.MULTIPLY -> numberLast * currentNum
                else -> BigDecimal(0)
            }
        } else {return  BigDecimal(0)}
    }



    fun percent() : String{
        if (isNoValue()) return "0"

        if (tempOperation == Consts.DEFAULT_OPERATION) {
            return "0"
        }
        tempNumber = text.toBigDecimal()
        val percentValue = ((result.divide(BigDecimal(100), 10, RoundingMode.HALF_UP)  ) * tempNumber)
            .stripTrailingZeros()
        tempNumber = percentValue
        text = tempNumber.toString()
        return tempNumber.toString()
    }

    fun isNoValue() : Boolean {
        return text == "" || text.startsWith('.')
    }






}