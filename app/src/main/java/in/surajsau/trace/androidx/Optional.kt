package `in`.surajsau.trace.androidx

data class Optional<T>(val value: T? = null) {

    companion object {
        fun <T> of(value: T) = Optional(value = value)

        fun <T> empty() = Optional<T>()
    }
}
