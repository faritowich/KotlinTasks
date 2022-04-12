package mkb.tasks1.task4

abstract class Car(
    val model: String,
    val enginePower: Int,
) {
    var engineLaunched: Boolean = false
        protected set
    var windowOpened: Boolean = false
        protected set

    enum class Action {
        ENGINE,
        WINDOW,
        TRAILER_LOAD,
        TRAILER_UNLOAD,
        INCREASE_SPEED,
        SLOW_DOWN
    }

    abstract fun makeAction(action: Action)
}