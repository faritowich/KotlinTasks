package mkb.tasks1.task4

class SportsCar(
    model: String,
    enginePower: Int,
    val maxSpeed: Int,
) : Car(
    model,
    enginePower
) {
    private val speedToAdd by lazy {
        maxSpeed / 5
    }

    var currentSpeed: Int = 0
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
            Action.INCREASE_SPEED -> {
                if (currentSpeed + speedToAdd <= maxSpeed) {
                    currentSpeed += speedToAdd
                    println("Added speed: ${speedToAdd}. Current speed: ${currentSpeed}, max speed: ${maxSpeed}.")
                } else {
                    println("Slow down! You move on maximum speed!")
                }
            }
            Action.SLOW_DOWN -> {
                if (currentSpeed - speedToAdd >= 0) {
                    currentSpeed -= speedToAdd
                    println("Decreased speed: ${speedToAdd}. Current speed: ${currentSpeed}, max speed: ${maxSpeed}.")
                } else {
                    println("You're not moving.")
                }
            }
            Action.TRAILER_UNLOAD, Action.TRAILER_LOAD -> {
                println("Sports cars are not designed to carry cargo.")
            }
        }
    }
}