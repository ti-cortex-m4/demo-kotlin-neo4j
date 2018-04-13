package demo.model

import com.google.common.collect.Maps

class Node(val level: Int, val name: String) {

    val childrenByName: MutableMap<String, Node>

    init {
        this.childrenByName = Maps.newTreeMap<String, Node>()
    }

    val children: Collection<Node>
        get() = childrenByName.values

    fun addChildNode(name: String): Node {
        if (childrenByName[name] == null) {
            childrenByName.put(name, Node(level + 1, name))
        }
        return childrenByName[name]!!
    }
}
