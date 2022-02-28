

enum class KeyState{
    ACCESSORYMODE,KEYOUT;
    companion object{
        fun KeySlot(obj:KeyState):Boolean {
            return obj.compareTo(ACCESSORYMODE)==0
        }
    }
}
enum class IgnitionState{
    IGNITION;
    companion object{
        fun Started(obj:IgnitionState):Boolean{
            return obj.compareTo(IGNITION)==0
        }
    }
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
        fun CState(obj:ClutchState):Boolean{
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
        fun LightState(obj:HeadlightState):String{
            return if(obj.compareTo(LIGHTON) == 0){
                LIGHTON.toString()
            } else
                LIGHTOFF.toString()
        }
    }
}

class Bike {
    var key = KeyState.KEYOUT
    var clutch:ClutchState = ClutchState.NORMAL
    var brake = {
            c:Brake -> if (Brake.BrakeUsed(c)){
        speed-=(speed/2)
    }
    }
    var horn = {
        d:HornState -> if (HornState.Horn(d) && KeyState.KeySlot(key) ){
            println("Horn pressed")
    }
        else
            println("Horn's left stay")
    }
    var fuel = 100
    var indigator = {
        i:Indigator -> println(Indigator.IndigatorState(i))
    }
    lateinit var start:IgnitionState
    var headLight = {
        h:HeadlightState -> println(HeadlightState.LightState(h))
    }
    private var speed = 0
    private var gear = 0
    private var speedLimit = 0
    init {
        if(KeyState.KeySlot(key)){
            var s:List<String> = readLine()!!.split(" ".toRegex())
            if (s.contains("start")){
                start = IgnitionState.IGNITION
            }
            else
                Return()
        }
        else
            Return()
    }
   fun gearUpDown(gr:Int){
        if (KeyState.KeySlot(key) && ClutchState.CState(clutch)){
            if (gr==1 && gear >= 0 && gear <=4){
                gear += 1
                engine(gear)
            }
            else if (gr==-1 && gear >= 0 && gear <=4){
                gear -=1
                engine(gear)
            }
            else
                return
        }
    }
    fun accelerator() {
        when (gear) {
            1 -> if (speedLimit<20){
                speed += 5
                speedometer()
            }
            2 -> if (speedLimit<35){
                speed += 5
                speedometer()
            }
            3 -> if (speedLimit<50){
                speed += 5
                speedometer()
            }
            4 -> if (speedLimit<90){
                speed += 5
                speedometer()
            }
            else -> return
        }
    }
    private fun engine(gear:Int){
        if(KeyState.KeySlot(key) && IgnitionState.Started(start)){
            when(gear){
                1 -> {
                    speedLimit = 20
                    fuel-=1
                    fuelgaugemeter()
                }
                2 -> {
                    speedLimit = 35
                    fuel-=2
                    fuelgaugemeter()
                }
                3 -> {
                    speedLimit = 50
                    fuel-=3
                    fuelgaugemeter()
                }
                4 ->{
                    speedLimit = 90
                    fuel-=4
                    fuelgaugemeter()
                }
            }
        }
    }

    private fun speedometer(){
        println(speed)
    }
    private fun fuelgaugemeter(){
        println(fuel)
    }
    private fun Return(){
        return
    }
}

fun main() {
    println("HIHIHIHIHIHI")
}

