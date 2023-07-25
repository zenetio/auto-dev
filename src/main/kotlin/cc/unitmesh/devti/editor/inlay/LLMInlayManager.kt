package cc.unitmesh.devti.editor.inlay

import cc.unitmesh.devti.editor.presentation.LLMInlayRenderer
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.util.concurrency.annotations.RequiresEdt

interface LLMInlayManager : Disposable {
    override fun dispose() {}

    @RequiresEdt
    fun isAvailable(editor: Editor): Boolean

    @RequiresEdt
    fun applyCompletion(project: Project, editor: Editor): Boolean

    @RequiresEdt
    fun collectInlays(editor: Editor, startOffset: Int, endOffset: Int): List<LLMInlayRenderer>

    @RequiresEdt
    fun disposeInlays(editor: Editor, disposeContext: InlayDisposeContext)

    fun editorModified(editor: Editor, changeOffset: Int)

    fun editorModified(editor: Editor)

    companion object {
        fun getInstance(): LLMInlayManager {
            return ApplicationManager.getApplication().getService(LLMInlayManager::class.java)
        }
    }
}