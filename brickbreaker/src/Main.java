/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dynata
 */
import java.util.*;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame obj=new JFrame();
        Gameplay gameply=new Gameplay();
        obj.setBounds(10,10 ,700,600);
        obj.setTitle("Brick breaker");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameply);
    }
}
