package mkb.tasks1.task5

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mkb.tasks1.task4.Car
import mkb.tasks1.task4.SportsCar
import mkb.tasks1.task4.Truck

fun main() {
    val truck1 = Truck("Volvo truck", 400, 5.0)
    val truck2 = Truck("Mercedes truck", 450, 7.0)
    val truck3 = Truck("BelAZ truck", 500, 10.0)
    val sportsCar1 = SportsCar("Ferrari", 250, 250)
    val sportsCar2 = SportsCar("Lamborghini", 330, 300)
    val sportsCar3 = SportsCar("Porsche", 310, 270)
    val sportsCar4 = SportsCar("Maserati", 320, 230)

    val cars = listOf(sportsCar4, truck1, truck3, sportsCar1, sportsCar2, truck2, sportsCar3)

    val sportCars = filterByType(cars, SportsCar::class.java)
    val sportCarsSorted = sortByEnginePower(sportCars)
    val powerfulSportCars = filterByEnginePower(sportCarsSorted, 300)

    runBlocking {
        printCarsWithDelay(powerfulSportCars)
    }
}

val Car.parameters: String
    get() = "Model: ${model}, engine power: ${enginePower}"

fun sortByEnginePower(cars: List<Car>) = cars.sortedBy { it.enginePower }
fun filterByEnginePower(cars: List<Car>, minEnginePower: Int) = cars.filter { it.enginePower >= minEnginePower }
fun <T> filterByType(cars: List<Car>, filterBy: Class<T>) = cars.filterIsInstance<T>(filterBy)

suspend fun printCarsWithDelay(cars: List<Car>) {
    coroutineScope{
        launch {
            for (car in cars) {
                delay(1000)
                println(car.parameters)
            }
        }
    }
}