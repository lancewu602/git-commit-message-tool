package com.lancewu602;

import com.intellij.ui.CollectionComboBoxModel;

import javax.swing.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author WuQinglong
 * @date 2025/1/13 17:42
 */
public class CommitPanel {
    private JPanel mainPanel;

    private JComboBox<String> typeOfChangeComboBox;
    private JTextField scopeOfThisChangeText;
    private JTextField shortDescriptionText;
    private JTextArea longDescriptionTextArea;
    private JTextArea breakChangeTextArea;
    private JTextField closedIssuesText;
    private JCheckBox skipCiCheckBox;

    public CommitPanel(CommitMessage commitMessage) {
        typeOfChangeComboBox.setModel(new CollectionComboBoxModel<>(
            Arrays.stream(ChangeType.values())
                .map(ChangeType::toString)
                .collect(Collectors.toList())
        ));

        if (commitMessage != null) {
            restoreValuesFromParsedCommitMessage(commitMessage);
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public CommitMessage getCommitMessage() {
        return new CommitMessage(
            getSelectedChangeType(),
            scopeOfThisChangeText.getText().trim(),
            shortDescriptionText.getText().trim(),
            longDescriptionTextArea.getText().trim(),
            breakChangeTextArea.getText().trim(),
            closedIssuesText.getText().trim(),
            true,
            skipCiCheckBox.isSelected()
        );
    }

    private ChangeType getSelectedChangeType() {
        int selectedIndex = typeOfChangeComboBox.getSelectedIndex();
        return ChangeType.values()[selectedIndex];
    }

    private void restoreValuesFromParsedCommitMessage(CommitMessage commitMessage) {
        if (commitMessage.getChangeType() != null) {
            typeOfChangeComboBox.setSelectedItem(commitMessage.getChangeType().toString());
        }
        scopeOfThisChangeText.setText(commitMessage.getChangeScope());
        shortDescriptionText.setText(commitMessage.getShortDescription());
        longDescriptionTextArea.setText(commitMessage.getLongDescription());
        breakChangeTextArea.setText(commitMessage.getBreakingChanges());
        closedIssuesText.setText(commitMessage.getClosedIssues());
        skipCiCheckBox.setSelected(commitMessage.isSkipCI());
    }

}
