package mkb.tasks1.task3

fun main() {
    val car = PassengerCar("Ford model T", 1908, 10.0)
    car.makeAction(Car.Action.ENGINE)
    car.makeAction(Car.Action.ENGINE)
    car.makeAction(Car.Action.WINDOW)
    car.makeAction(Car.Action.WINDOW)
    car.makeAction(Car.Action.TRUNK_LOAD)
    car.makeAction(Car.Action.TRUNK_UNLOAD)
    car.makeAction(Car.Action.TRUNK_UNLOAD)

    val truck = Truck("ZIL-130", 1962, 6000.0)

}