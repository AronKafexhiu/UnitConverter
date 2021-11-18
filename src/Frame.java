import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    private JPanel panel;
    private JPanel categoryPanel;
    private JPanel mainPanel;
    private JComboBox comboBox;
    private JComboBox comboBox1;
    private JComboBox comboBoxCategory;
    private String[] categories = {"Mass","Length","Area","Volume","Volume(l)"};
    private String[] length = {"mm","cm","dm","m","dam","hm","km"};
    private String[] mass = {"mg","cg","dg","g","dam","hm","kg"};
    private String[] area = {"mm2","cm2","dm2","m2","dam2","hm2","km2"};
    private String[] volume = {"mm3","cm3","dm3","m3","dam3","hm3","km3"};
    private String[] volume2 = {"ml","cl","cl","l","dal","hl","kl"};
    private JTextField inputField, outputField;
    private int lengthUnitDiff = 10, massUnitDiff = 10, areaUnitDiff = 100, volumeUnitDiff = 1000, volume2UnitDiff = 10;

    public Frame() {
        setProperties();
        init();
        setUI();
    }
    public void setProperties() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Unit Converter");
        setLocationRelativeTo(null);
        setSize(500,500);
    }
    public void init() {
        panel = new JPanel(new GridLayout(2,2));
        categoryPanel = new JPanel(new GridLayout(1,1));
        mainPanel = new JPanel(new GridLayout(2,1));
        comboBoxCategory = new JComboBox(categories);
        comboBoxCategory.addActionListener(this);
        comboBox = new JComboBox(mass);
        comboBox1 = new JComboBox(mass);
        inputField = new JTextField(10);
        inputField.addActionListener(this);
        outputField = new JTextField(10);
        outputField.setEditable(false);
    }
    public void setUI() {
        categoryPanel.add(comboBoxCategory);
        panel.add(comboBox);
        panel.add(inputField);
        panel.add(comboBox1);
        panel.add(outputField);
        mainPanel.add(categoryPanel);
        mainPanel.add(panel);
        add(mainPanel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == comboBoxCategory) {
            if(comboBoxCategory.getSelectedItem().equals("Length")) {
                comboBox.setModel(new JComboBox<>(length).getModel());
                comboBox1.setModel(new JComboBox<>(length).getModel());
            }
            if(comboBoxCategory.getSelectedItem().equals("Mass")) {
                comboBox.setModel(new JComboBox<>(mass).getModel());
                comboBox1.setModel(new JComboBox<>(mass).getModel());
            }
            if(comboBoxCategory.getSelectedItem().equals("Area")) {
                comboBox.setModel(new JComboBox<>(area).getModel());
                comboBox1.setModel(new JComboBox<>(area).getModel());
            }
            if(comboBoxCategory.getSelectedItem().equals("Volume")) {
                comboBox.setModel(new JComboBox<>(volume).getModel());
                comboBox1.setModel(new JComboBox<>(volume).getModel());
            }
            if(comboBoxCategory.getSelectedItem().equals("Volume(l)")) {
                comboBox.setModel(new JComboBox<>(volume2).getModel());
                comboBox1.setModel(new JComboBox<>(volume2).getModel());
            }
        }
        if(e.getSource() == inputField) {
            outputField.setText("");
            if(comboBoxCategory.getSelectedItem().equals("Length")) {
                if(comboBox.getSelectedIndex() < comboBox1.getSelectedIndex()) {
                    int valueToMultiply = 1;
                    for(int i = 0;i < (comboBox1.getSelectedIndex() - comboBox.getSelectedIndex());i++) {
                        valueToMultiply *= lengthUnitDiff;
                    }
                    outputField.setText(Double.toString(Double.parseDouble(inputField.getText()) / valueToMultiply));
                } else if(comboBox.getSelectedIndex() > comboBox1.getSelectedIndex()) {
                    int valueToMultiply = 1;
                    for(int i = 0;i < (comboBox.getSelectedIndex() - comboBox1.getSelectedIndex());i++) {
                        valueToMultiply *= lengthUnitDiff;
                    }
                    outputField.setText(Double.toString(Double.parseDouble(inputField.getText()) * valueToMultiply));
                } else {
                    outputField.setText(inputField.getText());
                }
            }
            if(comboBoxCategory.getSelectedItem().equals("Mass")) {
                if(comboBox.getSelectedIndex() < comboBox1.getSelectedIndex()) {
                    int valueToMultiply = 1;
                    for(int i = 0;i < (comboBox1.getSelectedIndex() - comboBox.getSelectedIndex());i++) {
                        valueToMultiply *= massUnitDiff;
                    }
                    outputField.setText(Double.toString(Double.parseDouble(inputField.getText()) / valueToMultiply));
                } else if(comboBox.getSelectedIndex() > comboBox1.getSelectedIndex()) {
                    int valueToMultiply = 1;
                    for(int i = 0;i < (comboBox.getSelectedIndex() - comboBox1.getSelectedIndex());i++) {
                        valueToMultiply *= massUnitDiff;
                    }
                    outputField.setText(Double.toString(Double.parseDouble(inputField.getText()) * valueToMultiply));
                } else {
                    outputField.setText(inputField.getText());
                }
            }
            if(comboBoxCategory.getSelectedItem().equals("Area")) {
                if(comboBox.getSelectedIndex() < comboBox1.getSelectedIndex()) {
                    int valueToMultiply = 1;
                    for(int i = 0;i < (comboBox1.getSelectedIndex() - comboBox.getSelectedIndex());i++) {
                        valueToMultiply *= areaUnitDiff;
                    }
                    outputField.setText(Double.toString(Double.parseDouble(inputField.getText()) / valueToMultiply));
                } else if(comboBox.getSelectedIndex() > comboBox1.getSelectedIndex()) {
                    int valueToMultiply = 1;
                    for(int i = 0;i < (comboBox.getSelectedIndex() - comboBox1.getSelectedIndex());i++) {
                        valueToMultiply *= areaUnitDiff;
                    }
                    outputField.setText(Double.toString(Double.parseDouble(inputField.getText()) * valueToMultiply));
                } else {
                    outputField.setText(inputField.getText());
                }
            }
            if(comboBoxCategory.getSelectedItem().equals("Volume")) {
                if(comboBox.getSelectedIndex() < comboBox1.getSelectedIndex()) {
                    int valueToMultiply = 1;
                    for(int i = 0;i < (comboBox1.getSelectedIndex() - comboBox.getSelectedIndex());i++) {
                        valueToMultiply *= volumeUnitDiff;
                    }
                    outputField.setText(Double.toString(Double.parseDouble(inputField.getText()) / valueToMultiply));
                } else if(comboBox.getSelectedIndex() > comboBox1.getSelectedIndex()) {
                    int valueToMultiply = 1;
                    for(int i = 0;i < (comboBox.getSelectedIndex() - comboBox1.getSelectedIndex());i++) {
                        valueToMultiply *= volumeUnitDiff;
                    }
                    outputField.setText(Double.toString(Double.parseDouble(inputField.getText()) * valueToMultiply));
                } else {
                    outputField.setText(inputField.getText());
                }
            }
            if(comboBoxCategory.getSelectedItem().equals("Volume(l)")) {
                if(comboBox.getSelectedIndex() < comboBox1.getSelectedIndex()) {
                    int valueToMultiply = 1;
                    for(int i = 0;i < (comboBox1.getSelectedIndex() - comboBox.getSelectedIndex());i++) {
                        valueToMultiply *= volume2UnitDiff;
                    }
                    outputField.setText(Double.toString(Double.parseDouble(inputField.getText()) / valueToMultiply));
                } else if(comboBox.getSelectedIndex() > comboBox1.getSelectedIndex()) {
                    int valueToMultiply = 1;
                    for(int i = 0;i < (comboBox.getSelectedIndex() - comboBox1.getSelectedIndex());i++) {
                        valueToMultiply *= volume2UnitDiff;
                    }
                    outputField.setText(Double.toString(Double.parseDouble(inputField.getText()) * valueToMultiply));
                } else {
                    outputField.setText(inputField.getText());
                }
            }
        }
    }
}
