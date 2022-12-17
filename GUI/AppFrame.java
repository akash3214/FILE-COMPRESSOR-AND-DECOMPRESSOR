/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import compressor.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

import org.apache.commons.io.FilenameUtils;
/**
 *
 * @author Admin
 */
public class AppFrame extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("FILE COMPRESSOR AND DECOMPRESSOR");
        ImageIcon FrameIcon = new ImageIcon("C:\\Users\\Admin\\Downloads\\frameLogo.png");
        this.setIconImage(FrameIcon.getImage());
        Icon icon = new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\compressorDecompressor\\src\\main\\java\\images\\data-compression.png");
        compressButton = new JButton(icon);
        compressButton.setText("SELECT FILE TO COMPRESS");
        compressButton.setForeground(new java.awt.Color(255, 153, 0));
        
        compressButton.addActionListener(this);
        compressButton.setBounds(50, 100, 250, 40);
        compressButton.setBackground(new java.awt.Color(255, 255, 255));
        compressButton.setFocusPainted(false);
        Icon icon2 = new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\compressorDecompressor\\src\\main\\java\\images\\zip.png");
        decompressButton = new JButton(icon2);
        decompressButton.setText("SELECT FILE TO DECOMPRESS");
        decompressButton.setForeground(new java.awt.Color(0, 0, 255));
        decompressButton.addActionListener(this);
        decompressButton.setBounds(350, 100, 250,40);
        decompressButton.setBackground(new java.awt.Color(255, 255, 255));
        decompressButton.setFocusPainted(false);
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(700, 300);
        this.getContentPane().setBackground(Color.orange);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    String name = file.getName();
                    compressor.method(file, name);
                }catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
           if(response==JFileChooser.APPROVE_OPTION){
               File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
               try{
                   String name = file.getName();
                   name  = FilenameUtils.removeExtension(name);
                   decompressor.method(file, name);
               }catch(Exception exc){
                   JOptionPane.showMessageDialog(null, exc.toString());
               }
           }
        }
    }
}
