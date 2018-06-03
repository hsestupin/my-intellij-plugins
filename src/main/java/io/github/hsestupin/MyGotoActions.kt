package io.github.hsestupin

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys

internal fun gotoParentFile(event: AnActionEvent, predicate: (String) -> Boolean) {
    val dataContext = event.getDataContext()
    val anchor = LangDataKeys.PSI_FILE.getData(dataContext)
    val startFromSameFile = predicate(anchor?.name ?: "")

    var dir = anchor?.parent
    if (startFromSameFile) {
        dir = dir?.parent
    }
    while (dir != null) {
        for (file in dir.files) {
            if (predicate(file.name)) {
                file.navigate(true)
                return
            }
        }
        dir = dir.parent
    }
}