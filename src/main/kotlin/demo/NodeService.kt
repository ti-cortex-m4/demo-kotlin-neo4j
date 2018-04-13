package demo

import com.google.common.base.Splitter
import com.google.common.collect.Lists
import demo.file.TextFile
import demo.json.TargetsListFile
import demo.model.Node
import demo.model.Target
import org.springframework.stereotype.Service

@Service
class NodeService {

    fun loadNodes(): Node {
        val targetsList = TargetsListFile("reader/skills.json").load()
        val targetNames = targetsList.targets!!.map(Target::name)

        val skippedFragments = TextFile("reader/skipped_fragments.txt").loadAsList()

        val parentNode = Node(0, "")
        for (targetName in targetNames) {
            if (!skippedFragments.any { targetName.contains(it) }) {
                var parentNodeLocal = parentNode
                val childrenNames = Lists.reverse(Lists.newArrayList(Splitter.on("<=").trimResults().split(targetName)))
                for (childName in childrenNames) {
                    parentNodeLocal = parentNodeLocal.addChildNode(childName)
                }
            }
        }

        return parentNode
    }
}
