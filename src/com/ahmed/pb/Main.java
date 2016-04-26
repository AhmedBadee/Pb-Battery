package com.ahmed.pb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static int i;
    public static int j;
    public static int k;

    public static double BAF = 0.85;
    public static double DF = 0.9;
    public static double Kt = 1;

    public static double i1_value = 0;
    public static double i2_value = 0;

    public static double hh1_value = 0;
    public static double mm1_value = 0;
    public static double hh2_value = 0;
    public static double mm2_value = 0;

    public static double vNormal_value = 0;
    public static double tolerance_value = 0;

    public static double vMin;
    public static double vMax;
    public static double capacityOffBattery;
    public static double iAverage;
    public static double noOffCells;
    public static double maxVoltage;
    public static double voltageDrop;
    public static double noOffDiodes;
    public static double iBattery;
    public static double eod;

    public static double totalTime;


    public static Font font = new Font("Serif", Font.PLAIN, 30);

    //Input Components
    public static JFrame window;
    public static JFrame window2;

    public static JLabel load1;
    public static JLabel load2;

    public static JLabel i1;
    public static JLabel i2;

    public static JTextField i1_textfield;
    public static JTextField i2_textfield;

    public static JLabel t1;
    public static JLabel t2;

    public static JTextField hh1_textfield;
    public static JTextField hh2_textfield;

    public static JTextField mm1_textfield;
    public static JTextField mm2_textfield;

    public static JLabel colon1;
    public static JLabel colon2;

    public static JLabel vNormal;
    public static JLabel tolerance;

    public static JTextField vNormal_TextField;
    public static JTextField tolerance_TextField;

    public static JLabel percentage;

    public static JLabel eodLabel;

    public static JTextField eod_TextField;

    public static JButton calculate;

    //Output components
    public static JLabel capacityOfBatteryLabel;
    public static JTextField capacapacityOfBatteryTextField;

    public static JLabel iAverageLabel;
    public static JTextField iAverageTextField;

    public static JLabel noOfCellsLabel;
    public static JTextField noOfCellsTextField;

    public static JLabel noOfDiodesLabel;
    public static JTextField noOfDiodesTextField;

    public static JLabel iBatteryLabel;
    public static JTextField iBatteryTextField;

    public static JLabel batteryTypeLabel;
    public static JTextField batteryTypeTextField;



    public static double[][] pb_table = {
            { 1, 360, 428.3, 520, 674.5, 830, 920.9, 1142, 1470, 1695, 2415, 3085},
            { 5, 290.4, 374, 435.6, 580.8, 726, 871.2, 967.7, 1210, 1450, 1815, 2419},
            { 15, 246, 315, 369, 492, 615, 738, 821.1, 1026, 1231, 1540, 2053},
            { 30, 171, 231, 256.5, 342, 427, 512.9, 612.1, 765.1, 917.2, 1148, 1530},
            { 1, 114, 150, 171, 228, 285, 342, 441, 551.2, 660.8, 826.8, 1103},
            { 2, 70.8, 92.7, 106.2, 141.5, 176.9, 212.3, 291.9, 364.9, 437.8, 547.3, 729.7},
            { 3, 52.5, 68.7, 78.7, 105, 131.2, 157.5, 215.3, 369.2, 323, 403.7, 538.3},
            { 5, 36.5, 47.2, 54.7, 72.9, 91.2, 109.4, 146.7, 182.5, 220.1, 272.4, 363.2},
            { 6, 32.1, 41.4, 48.1, 64.1, 80.2, 96.2, 126.9, 157.8, 190.7, 253.5, 314.1},
            { 8, 25, 32.5, 38, 50, 63, 75, 100, 125, 150, 188, 250},
            { 10, 21.3, 27.5, 31.9, 42.6, 53.2, 63.8, 83.2, 103.5, 125.1, 154.5, 205.9},
            { 24, 9.8, 12.7, 14.7, 19.6, 24.4, 29.3, 38.7, 48.1, 58.1, 71.7, 59.7},
            { 48, 5.1, 6.3, 7.6, 10.1, 12.6, 15.2, 20.6, 25.7, 31, 38.3, 51},
            { 100, 2.7, 3.3, 4, 5.3, 6.7, 8, 11.2, 14, 16.9, 20.8, 27.8}
    };


    public static String[] cells = { "cellType", "GEL-200", "GEL-250", "GEL-300", "GEL-400", "GEL-500", "GEL-600", "GEL-800", "GEL-1000", "GEL-1200", "GEL-1500", "GEL-2000"};


    public static void main(String[] args) {


        //Input Screen
        window = new JFrame("Battery Design");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(Frame.MAXIMIZED_BOTH);
        window.setLayout(null);

        //Loads Labels
        load1 = new JLabel("Load 1");
        load1.setLocation( 100, 100);
        load1.setSize( 100, 100);
        load1.setFont(font);
        window.add(load1);

        load2 = new JLabel("Load 2");
        load2.setLocation( 100, 250);
        load2.setSize( 100, 100);
        load2.setFont(font);
        window.add(load2);

        //Current(I) Labels
        i1 = new JLabel("I 1");
        i1.setLocation( 300, 100);
        i1.setSize( 50, 100);
        i1.setFont(font);
        window.add(i1);

        i2 = new JLabel("I 2");
        i2.setLocation( 300, 250);
        i2.setSize( 50, 100);
        i2.setFont(font);
        window.add(i2);

        //Current(I) TextBoxes
        i1_textfield = new JTextField();
        i1_textfield.setLocation( 400, 125);
        i1_textfield.setSize( 70, 50);
        i1_textfield.setFont(font);
        window.add(i1_textfield);

        i2_textfield = new JTextField();
        i2_textfield.setLocation( 400, 275);
        i2_textfield.setSize( 70, 50);
        i2_textfield.setFont(font);
        window.add(i2_textfield);

        //Time Labels
        t1 = new JLabel("t 1");
        t1.setLocation( 600, 100);
        t1.setSize( 50, 100);
        t1.setFont(font);
        window.getContentPane().add(t1);

        t2 = new JLabel("t 2");
        t2.setLocation( 600, 250);
        t2.setSize( 50, 100);
        t2.setFont(font);
        window.add(t2);


        //Time Hours TextBoxes
        hh1_textfield = new JTextField();
        hh1_textfield.setLocation( 700, 125);
        hh1_textfield.setSize( 70, 50);
        hh1_textfield.setFont(font);
        window.add(hh1_textfield);

        hh2_textfield = new JTextField();
        hh2_textfield.setLocation( 700, 275);
        hh2_textfield.setSize( 70, 50);
        hh2_textfield.setFont(font);
        window.add(hh2_textfield);

        //Time colon labels
        colon1 = new JLabel(" : ");
        colon1.setLocation( 800, 125);
        colon1.setSize( 30, 50);
        colon1.setFont(font);
        window.add(colon1);

        colon2 = new JLabel(" : ");
        colon2.setLocation( 800, 275);
        colon2.setSize( 30, 50);
        colon2.setFont(font);
        window.add(colon2);

        //Time Mins TextBoxes
        mm1_textfield = new JTextField();
        mm1_textfield.setLocation( 860, 125);
        mm1_textfield.setSize( 70, 50);
        mm1_textfield.setFont(font);
        window.add(mm1_textfield);

        mm2_textfield = new JTextField();
        mm2_textfield.setLocation( 860, 275);
        mm2_textfield.setSize( 70, 50);
        mm2_textfield.setFont(font);
        window.add(mm2_textfield);

        //V normal label and textBox
        vNormal = new JLabel("V normal");
        vNormal.setLocation( 100, 500);
        vNormal.setSize( 200, 100);
        vNormal.setFont(font);
        window.add(vNormal);

        vNormal_TextField = new JTextField();
        vNormal_TextField.setLocation( 350, 525);
        vNormal_TextField.setSize( 150, 50);
        vNormal_TextField.setFont(font);
        window.add(vNormal_TextField);

        //Tolerance label and textBox
        tolerance = new JLabel("Tolerance");
        tolerance.setLocation( 600, 500);
        tolerance.setSize( 200, 100);
        tolerance.setFont(font);
        window.add(tolerance);

        tolerance_TextField = new JTextField();
        tolerance_TextField.setLocation( 850, 525);
        tolerance_TextField.setSize( 150, 50);
        tolerance_TextField.setFont(font);
        window.add(tolerance_TextField);

        percentage = new JLabel("%");
        percentage.setLocation( 1050, 525);
        percentage.setSize( 50, 50);
        percentage.setFont(font);
        window.add(percentage);

        //EOD
        eodLabel = new JLabel("E.O.D");
        eodLabel.setLocation( 100, 700);
        eodLabel.setSize( 200, 100);
        eodLabel.setFont(font);
        window.add(eodLabel);

        eod_TextField = new JTextField();
        eod_TextField.setLocation( 350, 725);
        eod_TextField.setSize( 150, 50);
        eod_TextField.setFont(font);
        window.add(eod_TextField);

        //Calculate Button
        calculate = new JButton("Calculate");
        calculate.setLocation( 400, 900);
        calculate.setSize( 300, 80);
        calculate.setFont(font);
        window.add(calculate);


        window.setVisible(true);

        //Output Screen
        window2 = new JFrame("Battery Design");
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.setExtendedState(Frame.MAXIMIZED_BOTH);
        window2.setLayout(null);

        //Capacity of Battery
        capacityOfBatteryLabel = new JLabel("Capacity Ah");
        capacityOfBatteryLabel.setLocation( 100, 100);
        capacityOfBatteryLabel.setSize( 200, 100);
        capacityOfBatteryLabel.setFont(font);
        window2.add(capacityOfBatteryLabel);

        capacapacityOfBatteryTextField = new JTextField();
        capacapacityOfBatteryTextField.setLocation( 350, 125);
        capacapacityOfBatteryTextField.setSize( 200, 50);
        capacapacityOfBatteryTextField.setFont(font);
        window2.add(capacapacityOfBatteryTextField);

        //I average
        iAverageLabel = new JLabel("Iavg");
        iAverageLabel.setLocation( 650, 100);
        iAverageLabel.setSize( 200, 100);
        iAverageLabel.setFont(font);
        window2.add(iAverageLabel);

        iAverageTextField = new JTextField();
        iAverageTextField.setLocation( 900, 125);
        iAverageTextField.setSize( 200, 50);
        iAverageTextField.setFont(font);
        window2.add(iAverageTextField);

        //No of Cells
        noOfCellsLabel = new JLabel("No of cells");
        noOfCellsLabel.setLocation( 100, 300);
        noOfCellsLabel.setSize( 200, 100);
        noOfCellsLabel.setFont(font);
        window2.add(noOfCellsLabel);

        noOfCellsTextField = new JTextField();
        noOfCellsTextField.setLocation( 350, 325);
        noOfCellsTextField.setSize( 200, 50);
        noOfCellsTextField.setFont(font);
        window2.add(noOfCellsTextField);

        //No of Diodes
        noOfDiodesLabel = new JLabel("No of Diodes");
        noOfDiodesLabel.setLocation( 650, 300);
        noOfDiodesLabel.setSize( 200, 100);
        noOfDiodesLabel.setFont(font);
        window2.add(noOfDiodesLabel);

        noOfDiodesTextField = new JTextField();
        noOfDiodesTextField.setLocation( 900, 325);
        noOfDiodesTextField.setSize( 200, 50);
        noOfDiodesTextField.setFont(font);
        window2.add(noOfDiodesTextField);

        //I Battery
        iBatteryLabel = new JLabel("I Battery");
        iBatteryLabel.setLocation( 100, 500);
        iBatteryLabel.setSize( 200, 100);
        iBatteryLabel.setFont(font);
        window2.add(iBatteryLabel);

        iBatteryTextField = new JTextField();
        iBatteryTextField.setLocation( 350, 525);
        iBatteryTextField.setSize( 200, 50);
        iBatteryTextField.setFont(font);
        window2.add(iBatteryTextField);

        //Battery Type
        batteryTypeLabel = new JLabel("Battery Type");
        batteryTypeLabel.setLocation( 650, 500);
        batteryTypeLabel.setSize( 200, 100);
        batteryTypeLabel.setFont(font);
        window2.add(batteryTypeLabel);

        batteryTypeTextField = new JTextField();
        batteryTypeTextField.setLocation( 900, 525);
        batteryTypeTextField.setSize( 250, 50);
        batteryTypeTextField.setFont(font);
        window2.add(batteryTypeTextField);


        //Calculate action
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i1_value = Double.parseDouble(i1_textfield.getText());
                i2_value = Double.parseDouble(i2_textfield.getText());

                hh1_value = Double.parseDouble(hh1_textfield.getText());
                mm1_value = Double.parseDouble(mm1_textfield.getText());

                hh2_value = Double.parseDouble(hh2_textfield.getText());
                mm2_value = Double.parseDouble(mm2_textfield.getText());

                vNormal_value = Double.parseDouble(vNormal_TextField.getText());
                tolerance_value = Double.parseDouble(tolerance_TextField.getText());

                eod = Double.parseDouble(eod_TextField.getText());

                calculations();

                tableSearch();

                results();

                window.setVisible(false);
                window2.setVisible(true);

            }
        });

    }

    public static void calculations() {
        vMin = ((1 - tolerance_value/100) * vNormal_value);
        vMax = ((1 + tolerance_value/100) * vNormal_value);

        capacityOffBattery = (i1_value * ((hh1_value*60 + mm1_value) / 60)) + (i2_value * ((hh2_value*60 + mm2_value) / 60));

        iAverage = (capacityOffBattery / (hh1_value + hh2_value + ((mm1_value + mm2_value) / 60)));

        noOffCells = vMin / eod;
        noOffCells = Math.ceil(noOffCells);

        maxVoltage = noOffCells * 2.35;

        voltageDrop = maxVoltage - vMax;

        noOffDiodes = voltageDrop / 0.7;
        noOffDiodes = Math.floor(noOffDiodes);

        iBattery = iAverage / (BAF * DF * Kt);
    }

    public static void tableSearch() {
        totalTime = (hh1_value + hh2_value + ((mm1_value + mm2_value) / 60));

        for (i = 4; i < 14; i++) {
            if (totalTime <= pb_table[0][i]) {
                for (j = 2; j < 12; j++) {
                    if (iBattery <= pb_table[j][i]) {
                        if (hh1_value == 0) {
                            for (k = 0; k < 4; k++) {
                                if (mm1_value == pb_table[0][k]) {
                                    if (i1_value <= pb_table[j][k]) {
                                        batteryTypeTextField.setText(String.valueOf(cells[j]));
                                        break;
                                    } else {
                                        batteryTypeTextField.setText(String.valueOf(cells[j + 1]));
                                        break;
                                    }
                                }
                            }
                        } else if (hh2_value == 0) {
                            for (k = 0; k < 4; k++) {
                                if (mm2_value == pb_table[0][k]) {
                                    if (i2_value <= pb_table[j][k]) {
                                        batteryTypeTextField.setText(String.valueOf(cells[j]));
                                        break;
                                    } else {
                                        batteryTypeTextField.setText(String.valueOf(cells[j + 1]));
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void results() {

        capacapacityOfBatteryTextField.setText(String.format("%.2f", capacityOffBattery));
        iAverageTextField.setText(String.format("%.2f", iAverage));
        noOfCellsTextField.setText(String.valueOf(noOffCells));
        noOfDiodesTextField.setText(String.valueOf(noOffDiodes));
        iBatteryTextField.setText(String.format("%.2f", iBattery));

    }

}