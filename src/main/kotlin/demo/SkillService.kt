package demo

import demo.neo4j.domain.Skill
import demo.model.Node
import demo.neo4j.repository.SkillRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SkillService {

    @Autowired
    private lateinit var skillRepository: SkillRepository

    @Autowired
    private lateinit var nodeService: NodeService

    fun saveSkills() {
        skillRepository.deleteAll()
        val parentNode = nodeService.loadNodes()
        save1(parentNode)
    }

    private fun save1(parentNode: Node) {
        val parentItem = Skill(name = parentNode.name, level = parentNode.level)
        skillRepository.save(parentItem)

        save2(parentItem, parentNode)
    }

    private fun save2(parentSkill: Skill, parentNode: Node) {
        var i = 0
        for (childNode in parentNode.children) {
            if (++i < 5) {
                val childItem = Skill(name = childNode.name, level = childNode.level)
                parentSkill.children.add(childItem)

                skillRepository.save(childItem)
                skillRepository.save(parentSkill)

                save2(childItem, childNode)
            }
        }
    }
}
