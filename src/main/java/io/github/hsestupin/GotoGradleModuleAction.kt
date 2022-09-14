package io.github.hsestupin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys

public class GotoGradleModuleAction: AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        gotoParentFile(event) {
            name -> name.startsWith("build.gradle")
        }
    }
}
