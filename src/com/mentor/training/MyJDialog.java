package com.mentor.training;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.Rectangle;
import java.util.EventObject;

public class MyJDialog extends JDialog {

    public MyJDialog() {
        JDialog dialog = new JDialog();
        Rectangle r = new Rectangle(600, 600);
        dialog.setBounds(r);
        JTable table = createAndGetTable();
        dialog.add(table);
        pack();
    }

    public JTable createAndGetTable() {
        DefaultTableModel model = getTableModel(4, 4);
        JTable table = new JTable(model);
        table.setCellEditor(getCellEditor());
        return table;
    }


    private DefaultTableModel getTableModel(int x, int y) {

        Object[][] output = new Object[x][y];
        for (int i = 0; i < y; i++) {
            output[i] = getVectorData(x);
        }
        String[] headers = {"1", "2", "3", "4"};
        return new DefaultTableModel(output, headers);
    }

    private Object[] getVectorData(int x) {
        Object[] output = new Object[x];
        for (int i = 0; i < x; i++) {
            output[i] = i * 10;
        }
        return output;
    }

    private TableCellEditor getCellEditor() {
        return new TableCellEditor() {
            @Override
            public Object getCellEditorValue() {
                return null;
            }

            @Override
            public boolean isCellEditable(EventObject anEvent) {
                return true;
            }

            @Override
            public boolean shouldSelectCell(EventObject anEvent) {
                return true;
            }

            @Override
            public boolean stopCellEditing() {
                return false;
            }

            @Override
            public void cancelCellEditing() {

            }

            @Override
            public void addCellEditorListener(CellEditorListener l) {

            }

            @Override
            public void removeCellEditorListener(CellEditorListener l) {

            }

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JTextField textField = new JTextField();
                textField.setText("sampleText");
                return textField;
            }
        };
    }
}
