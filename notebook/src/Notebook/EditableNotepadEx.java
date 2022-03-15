package Notebook;

import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class EditableNotepadEx implements ActionListener{
    JFrame frame;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, helpMenu;
    JMenuItem cutItem, copyItem, pasteItem, selectAll, saveFile;
    JTextArea txtArea;

    EditableNotepadEx() {
        frame = new JFrame();
        cutItem = new JMenuItem("cutItem");
        copyItem = new JMenuItem("copyItem");
        pasteItem = new JMenuItem("pasteItem");
        selectAll = new JMenuItem("selectAllItem");
        saveFile = new JMenuItem("saveFile");

        copyItem.addActionListener(this);
        cutItem.addActionListener(this);
        selectAll.addActionListener(this);
        pasteItem.addActionListener(this);
        saveFile.addActionListener(this);
        menuBar = new JMenuBar();
        menuBar.setBounds(5,5,400,30);
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");
        fileMenu.add(saveFile);
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(selectAll);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        txtArea = new JTextArea();
        txtArea.setBounds(5, 30, 450, 450);
        frame.add(menuBar);
        frame.add(txtArea);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setVisible(true);



    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cutItem) txtArea.cut();
        if (ae.getSource() == pasteItem) txtArea.paste();
        if (ae.getSource() == copyItem) txtArea.copy();
        if (ae.getSource() == selectAll) txtArea.selectAll();
        if (ae.getSource() == saveFile) {
            try {
                CreateFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new EditableNotepadEx();
    }

    public static void CreateFile() throws IOException {
        Scanner fileName = new Scanner(System.in);
        System.out.println("Enter file name");
        String fileStuff = fileName.nextLine();



        try {
            File myObj = new File("C:\\Downloads\\" + fileStuff + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            else System.out.println("File already exists.");
        }
        catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        FileWriter myWriter = new FileWriter("" + fileStuff + ".txt");
        System.out.println("");
        myWriter.write("");
    }



}
