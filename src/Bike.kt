
enum class KeyState{
    ACCESSORYMODE,KEYOUT;
    companion object{
        fun KeySlot(obj:KeyState):Boolean {
            return obj.compareTo(ACCESSORYMODE)==0
        }
    }
}
enum class IgnitionState{
    IGNITION
}
enum class Brake{
    PRESSED, RELEASED;
    companion object{
        fun BrakeUsed(obj:Brake):Boolean{
            return obj.compareTo(PRESSED) == 0
        }
    }
}
enum class ClutchState{
    NEUTRAL, NORMAL;
    companion object{
        fun ClutchState(obj:ClutchState):Boolean{
            return obj.compareTo(NEUTRAL) == 0
        }
    }
}
enum class Indigator{
    LEFT, RIGHT;
    companion object{
        fun IndigatorState(obj:Indigator):String{
            return if (obj.compareTo(LEFT) == 0){
                LEFT.toString()
            } else if (obj.compareTo(RIGHT)==0){
                RIGHT.toString()
            } else
                "NONE"
        }
    }
}
enum class HornState{
    PRESSED,RELEASED;
    companion object{
        fun Horn(obj:HornState):Boolean{
            return obj.compareTo(PRESSED) == 0
        }
    }
}
enum class HeadlightState{
    LIGHTON,LIGHTOFF;
    companion object{
        fun ClutchState(obj:HeadlightState):Boolean{
            return obj.compareTo(LIGHTON) == 0
        }
    }
}
internal var keyHolder = KeyState.KEYOUT
class Bike {
    var key = keyHolder
    init {
        if (KeyState.KeySlot(key)){
            println("Bike is now turned on")
        }
    }
    private fun engine(){

    }
}
fun main() {
    var k:List<String> = readLine()!!.split(" ".toRegex())
    var temp = false
    val s = Bike()
    for (i in k){
        if (i.lowercase()=="put"|| temp){
            temp = true
            if (i.lowercase()=="key"){
                keyHolder = KeyState.ACCESSORYMODE
            }
        }
    }
}
