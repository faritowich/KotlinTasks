package mkb.tasks1.task4

class Truck(
    model: String,
    enginePower: Int,
    val loadCapacityTons: Double,
) : Car(
    model,
    enginePower
) {
    private val cargoToLoadTons by lazy {
        loadCapacityTons / 5
    }

    var filledTrailerTons: Double = 0.0
        private set

    override fun makeAction(action: Action) {
        when (action) {
            Action.ENGINE -> {
                engineLaunched = !engineLaunched
                if (engineLaunched) println("Engine is launched!") else println("Engine turned off.")
            }
            Action.WINDOW -> {
                windowOpened = !windowOpened
                if (windowOpened) println("Window opened.") else println("Window closed.")
            }
            Action.TRAILER_LOAD -> {
                if (filledTrailerTons + cargoToLoadTons <= loadCapacityTons) {
                    filledTrailerTons += cargoToLoadTons
                    println("Added: ${cargoToLoadTons} tons. Now the cargo weighs: ${filledTrailerTons}, total capacity: ${loadCapacityTons}.")
                } else {
                    println("Overloading!")
                }
            }
            Action.TRAILER_UNLOAD -> {
                if (filledTrailerTons - cargoToLoadTons >= 0) {
                    filledTrailerTons -= cargoToLoadTons
                    println("Unloaded: ${cargoToLoadTons} tons. Now the cargo weighs: ${filledTrailerTons}, total capacity: ${loadCapacityTons}.")
                } else {
                    println("Trailer is empty.")
                }
            }
            Action.INCREASE_SPEED, Action.SLOW_DOWN -> {
                println("The speed of our truck is constant.")
            }
        }
    }
}