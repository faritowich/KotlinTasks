package mkb.tasks1.task3

abstract class Car(
    val model: String,
    val year: Int,
    val totalTrunkVolume: Double,
) {
    private val amountToLoad = totalTrunkVolume / 5

    var engineLaunched: Boolean = false
        protected set
    var windowsOpened: Boolean = false
        protected set
    var filledTrunkVolume: Double = 0.0
        protected set

    enum class Action {
        ENGINE,
        WINDOW,
        TRUNK_LOAD,
        TRUNK_UNLOAD
    }

    fun makeAction(action: Action) {
        when (action) {
            Action.ENGINE -> {
                engineLaunched = !engineLaunched
                if (engineLaunched) println("Engine is launched!") else println("Engine turned off")
            }
            Action.WINDOW -> {
                windowsOpened = !windowsOpened
                if (windowsOpened) println("Window opened") else println("Window closed")
            }
            Action.TRUNK_LOAD -> {
                if (filledTrunkVolume + amountToLoad <= totalTrunkVolume) {
                    filledTrunkVolume += amountToLoad
                    println("Added: ${amountToLoad}. Filled trunk volume: ${filledTrunkVolume}, total volume: ${totalTrunkVolume}")
                } else {
                    println("Not enough space!")
                }
            }
            Action.TRUNK_UNLOAD -> {
                if (filledTrunkVolume - amountToLoad >= 0) {
                    filledTrunkVolume -= amountToLoad
                    println("Unloaded: ${amountToLoad}. Filled trunk volume: ${filledTrunkVolume}, total volume: ${totalTrunkVolume}")
                } else {
                    println("Trunk is empty")
                }
            }
        }
    }
}