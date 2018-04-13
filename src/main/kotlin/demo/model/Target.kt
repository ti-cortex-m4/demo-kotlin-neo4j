package demo.model

class Target(val id: String, val name: String) : Comparable<Target> {

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null || javaClass != other.javaClass)
            return false

        val that = other as Target?
        return name == that!!.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun compareTo(other: Target): Int {
        return this.name.compareTo(other.name)
    }
}
