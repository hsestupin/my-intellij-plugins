package io.github.hsestupin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

public class GotoBazelBuildAction: AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        gotoParentFile(event) {
            name -> "BUILD.bazel" == name || "BUILD" == name
        }
    }

}
