package com.lancewu602;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.vcs.CommitMessageI;
import com.intellij.openapi.vcs.VcsDataKeys;
import com.intellij.openapi.vcs.ui.Refreshable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author WuQinglong
 * @date 2025/1/13 17:31
 */
public class CreateCommitAction extends AnAction implements DumbAware {

    @Override
    public void actionPerformed(@NotNull AnActionEvent actionEvent) {
        CommitMessageI commitMessageI = getCommitPanel(actionEvent);
        if (commitMessageI == null) {
            return;
        }

        CommitDialog dialog = new CommitDialog(actionEvent.getProject(), commitMessageI);
        dialog.show();
    }

    @Nullable
    private static CommitMessageI getCommitPanel(@Nullable AnActionEvent e) {
        if (e == null) {
            return null;
        }
        Refreshable data = Refreshable.PANEL_KEY.getData(e.getDataContext());
        if (data instanceof CommitMessageI) {
            return (CommitMessageI) data;
        }
        return VcsDataKeys.COMMIT_MESSAGE_CONTROL.getData(e.getDataContext());
    }

}
