package com.lancewu602;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.vcs.CheckinProjectPanel;
import com.intellij.openapi.vcs.CommitMessageI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author WuQinglong
 * @date 2025/1/13 17:35
 */
public class CommitDialog extends DialogWrapper {

    private final CommitPanel commitPanel;
    private final CommitMessageI commitMessageI;

    public CommitDialog(@Nullable Project project, @NotNull CommitMessageI commitMessageI) {
        super(project);
        setTitle("Git Commit Message");
        setOKButtonText("OK");
        setCancelButtonText("Cancel");

        CommitMessage commitMessage = parseExistingCommitMessage(commitMessageI);
        this.commitPanel = new CommitPanel(commitMessage);
        this.commitMessageI = commitMessageI;

        init();
    }

    @Override
    protected void doOKAction() {
        super.doOKAction();
        commitMessageI.setCommitMessage(commitPanel.getCommitMessage().toString());
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return commitPanel.getMainPanel();
    }

    private CommitMessage parseExistingCommitMessage(CommitMessageI commitMessageI) {
        if (commitMessageI instanceof CheckinProjectPanel) {
            String commitMessageString = ((CheckinProjectPanel) commitMessageI).getCommitMessage();
            return CommitMessage.parse(commitMessageString);
        }
        return null;
    }

}
