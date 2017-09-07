package com.anahoret.effectiveandroidtesting.data.local

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

object RecipeFactory {

    private val ID_PREFIX = "id="
    private val TITLE_PREFIX = "title="

    fun getRecipeFromAsset(stream: InputStream): Recipe? {
        val bufferReader = BufferedReader(InputStreamReader(stream))

        var id = ""
        var title = ""
        val description = StringBuilder()

        try {
            var line: String? = bufferReader.readLine()
            while (line != null) {
                when {
                    line.startsWith(ID_PREFIX) -> {
                        id = line.substring(ID_PREFIX.length)
                        line = bufferReader.readLine()
                    }
                    line.startsWith(TITLE_PREFIX) -> {
                        title = line.substring(TITLE_PREFIX.length)
                        line = bufferReader.readLine()
                    }
                    line.isNotEmpty() -> {
                        description.append(line)
                        line = bufferReader.readLine()
                    }
                }
            }
        } catch (e: IOException) {
            return null
        }
        return Recipe(id, title, description.toString())
    }
}

data class Recipe(val id: String = "", val title: String = "", val description: String = "")
