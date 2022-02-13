package na.severinchik.lesson4

class SampleAnalogStaticVaraible {

    companion object {
        val DEFAULT = SampleAnalogStaticVaraible()
        fun calculate() {}
    }
}

fun main() {
    SampleAnalogStaticVaraible.DEFAULT
    SampleAnalogStaticVaraible.calculate()
}

