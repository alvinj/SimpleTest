package com.alvinalexander.simpletest

package support {
    val AnsiRed   = "\u001B[31m"
    val AnsiGreen = "\u001B[32m"
    val AnsiYellow = "\u001B[33m"
    val AnsiReset = "\u001B[0m"
    def printRed(s: String)    = println(s"${AnsiRed}${s}${AnsiReset}")
    def printGreen(s: String)  = println(s"${AnsiGreen}${s}${AnsiReset}")
    def printYellow(s: String) = println(s"${AnsiYellow}${s}${AnsiReset}")
}

import support._

object SimpleTest:

    private def _isTrue(
        blockOfTestCode: => Boolean, 
        trueString: String,
        falseString: String
    ): Unit =
        if blockOfTestCode then
            printGreen(trueString)
        else
            printRed(falseString)
        end if

    def isTrue(blockOfTestCode: => Boolean, num: Int): Unit =
        _isTrue(
            blockOfTestCode,
            s"(true)  test $num",
            s"(false) test $num"
        )

    def isTrue(blockOfTestCode: => Boolean, desc: String): Unit =
        _isTrue(
            blockOfTestCode,
            s"(true)  $desc",
            s"(false) $desc"
        )

    private def _isFalse(
        blockOfTestCode: => Boolean, 
        trueString: String,
        falseString: String
    ): Unit =
        if blockOfTestCode == false then
            printGreen(trueString)
        else
            printRed(falseString)
        end if

    def isFalse(blockOfTestCode: => Boolean, num: Int): Unit =
        _isFalse(
            blockOfTestCode,
            s"(true)  test $num",
            s"(false) test $num"
        )

    def isFalse(blockOfTestCode: => Boolean, desc: String): Unit =
        _isFalse(
            blockOfTestCode,
            s"(true)  $desc",
            s"(false) $desc"
        )

    // require a description
    def isEq(expected: Any, received: Any, desc: String): Unit =
        if expected == received then
            printGreen(s"(true) $desc")
        else
            printRed(s"(false) EXPECTED: ($expected), RECEIVED: ($received), DESC: $desc")
        end if

    // don’t require a description
    def isEq(expected: Any, received: Any): Unit =
        if expected == received then
            printGreen(s"(true) EXPECTED: ($expected), RECEIVED: ($received)")
        else
            printRed(s"(false) EXPECTED: ($expected), RECEIVED: ($received)")
        end if

    // specify todo’s
    def todo(desc: String): Unit =
        printYellow(s"TODO:   $desc")


    /**
     * Let this object keep track of the test numbers for you.
     */
    private var testCount = 0
    def isTrue(blockOfTestCode: => Boolean): Unit =
        testCount += 1
        if blockOfTestCode then
            printGreen(s"(true)  test $testCount")
        else
            printRed(s"(false) test $testCount")
        end if
    def isFalse(blockOfTestCode: => Boolean): Unit =
        testCount += 1
        if blockOfTestCode == false then
            printGreen(s"(true)  test $testCount")
        else
            printRed(s"(false) test $testCount")
        end if

end SimpleTest





