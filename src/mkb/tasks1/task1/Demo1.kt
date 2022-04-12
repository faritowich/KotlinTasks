package mkb.tasks1

import java.lang.Exception
import java.lang.NumberFormatException
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val triangle1 = RightTriangle(3.0, 4.0)
    println("Hypotenuse: ${triangle1.calculateHypotenuse()}")
    println("Perimeter: ${triangle1.calculatePerimeter()}")
    println("Area: ${triangle1.calculateArea()}")

    val deposit1 = Deposit(100000.0, 3.0)
    println("Deposit in 5 years: ${deposit1.calculateDepositAmount(5)}")
}

//Даны катеты прямоугольного треугольника. Найти площадь, периметр и гипотенузу треугольника.
class RightTriangle(private val leg1: Double, private val leg2: Double) {

    private fun checkInput(): Boolean {
        return if (leg1 >= 0.0 && leg2 >= 0.0) true else throw Exception("Legs cannot be negative")
    }

    fun calculateHypotenuse(): Double {
        checkInput()
        return sqrt(leg1.pow(2) + leg2.pow(2))
    }

    fun calculatePerimeter(): Double {
        checkInput()
        return leg1 + leg2 + calculateHypotenuse()
    }

    fun calculateArea(): Double {
        checkInput()
        return (leg1 * leg2) / 2
    }
}

//Пользователь вводит сумму вклада в банк и годовой процент. Найти сумму вклада через 5 лет.

class Deposit(private var sum: Double, private var annualPercent: Double) {
    fun calculateDepositAmount(years: Int): Double {
        return if (sum >= 0.0 && annualPercent >= 0.0 && years >= 0) {
            sum + (sum * (annualPercent / 100)) * years
        } else throw Exception("Sum and annual percent cannot be negative")
    }
}