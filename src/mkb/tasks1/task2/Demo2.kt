package mkb.tasks1

fun main() {
    println(isEven(-11))
    println(dividesByThree(-12))

    val arr = createArray(100)
    for (i in arr) {
        print("$i ")
    }

    println()
    val filteredArr = deleteEvenAndDividableByThree(arr)
    for (i in filteredArr) {
        print("$i ")
    }
}

//Написать функцию, которая определяет, четное число или нет.
fun isEven(num: Int) = num % 2 == 0

//Написать функцию, которая определяет, делится ли число без остатка на 3.
fun dividesByThree(num: Int) = num % 3 == 0

//Создать возрастающий массив из 100 чисел.
fun createArray(numAmount: Int): IntArray {
    val array = if (numAmount >= 0) IntArray(numAmount) else IntArray(0)
    for (i in array.indices) {
        array[i] = i
    }
    return array
}

//Удалить из этого массива все четные числа и все числа, которые не делятся на 3.
fun deleteEvenAndDividableByThree(array: IntArray): IntArray {
    return array.filter { !isEven(it) && !dividesByThree(it) }.toIntArray()
}
