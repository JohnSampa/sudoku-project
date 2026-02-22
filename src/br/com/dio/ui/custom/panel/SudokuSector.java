package br.com.dio.ui.custom.panel;

import br.com.dio.ui.custom.input.NumberText;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.util.List;

import static java.awt.Color.blue;

public class SudokuSector extends JPanel {

    public SudokuSector(final List<NumberText> textFilds) {
        Dimension dimension = new Dimension(170, 170);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setBorder(new LineBorder(blue,2,true));
        this.setVisible(true);
        textFilds.forEach(this::add);
    }

}
