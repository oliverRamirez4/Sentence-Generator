import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;

public class Window {
    JFrame topFrame;
    textGenerator guide;


    public Window(){

        File dir=new File("WordCounterData");

        guide = new textGenerator();


        //initialize the JFrame
        topFrame=new JFrame();
            topFrame.setVisible(true);
            topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            topFrame.setTitle("Sentence Generator");

        //Create the JPanel which will have the JButton and JTextArea
        JPanel panel=new JPanel();
            topFrame.add(panel);
            panel.setBackground(Color.LIGHT_GRAY);

        //Create a JLabel that tells the user what to do
        JLabel title = new JLabel("Insert text here, then press the button to auto generate a sentence");
            panel.add(title);

        //Create a JTextArea for the user to put their started sentence
        JTextArea inputBox= new JTextArea(6,30);
            inputBox.setLineWrap(true);
            inputBox.setWrapStyleWord(true);
            panel.add(inputBox);

            JTextArea outputBox=new JTextArea(6,30);
                outputBox.setLineWrap(true);
                outputBox.setWrapStyleWord(true);
                outputBox.setEditable(false);
                panel.add(outputBox);

        //Button that when pressed generates the rest of the sentence
        JButton btn=new JButton("generate sentence");
        panel.add(btn);

        //takes the string in the text box and finishes the sentence
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputBox.setText(guide.generateSentence(inputBox));



            }
        });



        topFrame.setSize(500,600);

    }

}
