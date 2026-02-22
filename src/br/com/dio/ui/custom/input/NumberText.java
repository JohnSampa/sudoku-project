package br.com.dio.ui.custom.input;

import br.com.dio.model.Space;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Dimension;
import java.awt.Font;

import static java.awt.Font.PLAIN;


public class NumberText extends JTextField {

    private final Space space;

    public NumberText(Space space) {
        this.space = space;
        Dimension dimension = new Dimension(50, 50);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.setFont(new Font("Arial", PLAIN, 12));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!this.space.isFixed());
        if (this.space.isFixed()) {
            this.setText(space.getActual().toString());
        }
        this.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeSpaces();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeSpaces();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changeSpaces();
            }

            private void changeSpaces() {
                if (getText().isEmpty()) {
                    space.clearSpace();
                    return;
                }
                space.setActual(Integer.parseInt(getText()));
            }
        });
    }
}
