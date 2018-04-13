package demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @Autowired
    private lateinit var skillService: SkillService

    @GetMapping("/save")
    fun saveSkills() {
        skillService.saveSkills()
    }
}
