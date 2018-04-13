package demo.neo4j.domain

import org.neo4j.ogm.annotation.GraphId
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
data class Skill(

        @GraphId
        var id: Long? = null,

        var name: String? = null,

        var level: Int? = null,

        @Relationship(type = "includes", direction = Relationship.UNDIRECTED)
        var children: MutableSet<Skill> = hashSetOf()
)
