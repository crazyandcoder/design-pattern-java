package kt

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
//        val a: Int = 10000
//        val boxedA: Int? = a
//        val anotherBoxedA: Int? = a
//        println(boxedA == anotherBoxedA)
//        println(boxedA === anotherBoxedA)

        val a: Int = 1
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        println (boxedA == anotherBoxedA)
        println (boxedA === anotherBoxedA)
    }
}