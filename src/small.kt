internal var keyHolder = KeyState.KEYOUT
fun main() {
    var k:List<String> = readLine()!!.split(" ".toRegex())
    if (k.contains("put")&&k.contains("key")){
        keyHolder = KeyState.ACCESSORYMODE
        val d = Bike()
        d.start
        d.horn(HornState.PRESSED)
        d.brake(Brake.PRESSED)
    }
}