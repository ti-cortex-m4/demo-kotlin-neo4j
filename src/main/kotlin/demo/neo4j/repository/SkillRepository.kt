package demo.neo4j.repository

import demo.neo4j.domain.Skill
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface SkillRepository : Neo4jRepository<Skill, Long>
