package com.dimaf.calc

import android.util.Log

class CommandsHelper {

    var text = ""

    fun onClickBut0() : String {
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
        return tvText(100)
    }

    fun onClickReset() : String {
        return tvText(101)
    }

    fun tvText(command : Int) : String {
        when (command) {
            1,2,3,4,5,6,7,8,9,0 -> text+=command
            100 -> text = text.dropLast(1)
            101 -> text = ""
        }
        return text
    }



}