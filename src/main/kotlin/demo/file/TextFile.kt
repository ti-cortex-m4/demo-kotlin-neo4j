package demo.file

import com.google.common.base.Splitter
import com.google.common.collect.Lists
import java.io.File

class TextFile(fileName: String) {

    private val file: File

    private val charset = Charsets.UTF_8

    init {
        this.file = File("src/main/resources/" + fileName)
    }

    fun load(): String {
        return file.readText(charset)
    }

    fun loadAsIterable(): Iterable<String> {
        return Splitter.on('\n').trimResults().omitEmptyStrings().split(load())
    }

    fun loadAsList(): MutableList<String> {
        return Lists.newArrayList(loadAsIterable())
    }

    fun save(value: String) {
        file.writeText(value, charset)
    }
}