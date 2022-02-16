import kotlin.properties.Delegates

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
    LEFT, RIGHT,NONE;
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
//internal var cluthBar = ClutchState.NORMAL
//internal var horns = HornState.RELEASED
internal var indigat = Indigator.NONE
class Bike {
    var key = keyHolder
    var clutch = ClutchState.NORMAL
    var brake = Brake.RELEASED
    var horn = HornState.RELEASED
    var indigator = indigat
    lateinit var start:IgnitionState
    var headLight = HeadlightState.LIGHTOFF
    private var speed = 0
    private var gear = 0
    init {
        println("OK cool")
        var s:List<String> = readLine()!!.split(" ".toRegex())
        if (s.contains("start")){
            start = IgnitionState.IGNITION
            println("hi bob")
        }
        else
            Return()
    }
    fun gearChange(){

    }
    fun Return(){
        return
    }
}
fun main() {
    var k:List<String> = readLine()!!.split(" ".toRegex())
    if (k.contains("put")&&k.contains("key")){
        keyHolder = KeyState.ACCESSORYMODE
        Bike()
    }
    /*var temp = false
    for (i in k){
        if (i.lowercase()=="put"|| temp){
            temp = true
            if (i.lowercase()=="key"){
                keyHolder = KeyState.ACCESSORYMODE
                val s = Bike()
            }
        }
    }*/
}
