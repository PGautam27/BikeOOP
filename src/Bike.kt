
sealed class DiscreteBikeStates{
    enum class KeyState{
        KEYIN,KEYOUT;
        companion object{
            fun KeySlot(obj:KeyState):Boolean {
                return obj.compareTo(KEYIN)==0
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
    enum class
}
class Bike {

}
fun main() {
}