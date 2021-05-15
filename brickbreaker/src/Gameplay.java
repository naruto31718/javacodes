/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Dynata
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;
    private int totalb = 21;
    private final Timer timer;
    private final int delay = 8;

    private int playerx = 310;
    private int ballx = 120;
    private int bally = 350;
    private int balldirx = -2;
    private int balldiry = -1;
    private MapGenerator map;

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
        map = new MapGenerator(3, 7);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 692, 592);
        //draw map
        map.draw((Graphics2D) g);
        //border
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
        //scores
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30);
        //paddle
        g.setColor(Color.GREEN);
        g.fillRect(playerx, 550, 100, 8);
        //ball
        g.setColor(Color.YELLOW);
        g.fillOval(ballx, bally, 20, 20);

        if (bally <= 0) {
            play = false;
            balldirx = 0;
            balldiry = 0;
            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 40));
            g.drawString("You Won", 260, 300);
        }

        if (bally > 570) {
            play = false;
            balldirx = 0;
            balldiry = 0;
            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 40));
            g.drawString("GameOver" + " " + "Score: " + score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Enter to restart", 230, 350);
        }
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerx >= 600) {
                playerx = 600;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerx < 10) {
                playerx = 10;
            } else {
                moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (play) {
                play = true;
                ballx = 120;
                bally = 350;
                balldirx = -1;
                balldiry = -2;
                playerx = 310;
                score = 0;
                totalb = 21;
                map = new MapGenerator(3, 7);
                repaint();
            }
        }
    }

    public void moveRight() {
        play = true;
        playerx += 30;
    }

    public void moveLeft() {
        play = true;
        playerx -= 30;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play) {
            if (new Rectangle(ballx, bally, 20, 20).intersects(new Rectangle(playerx, 550, 100, 8))) {
                balldiry = -balldiry;
            }

            A:
            for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int brickx = j * map.brickwidth + 80;
                        int bricky = i * map.brickheight + 50;
                        int brickwidth = map.brickwidth;
                        int brickheight = map.brickheight;

                        Rectangle rect = new Rectangle(brickx, bricky, brickwidth, brickheight);
                        Rectangle ballrect = new Rectangle(ballx, bally, 20, 20);
                        Rectangle brickrect = rect;

                        if (ballrect.intersects(brickrect)) {
                            map.setbrickvalue(0, i, j);
                            totalb--;
                            score += 5;

                            if (ballx + 19 <= brickrect.x || ballx + 1 >= brickrect.x + brickrect.width) {
                                balldirx = -balldirx;
                            } else {
                                balldiry = -balldiry;
                            }

                            break A;
                        }
                    }
                }
            }

            ballx += balldirx;
            bally += balldiry;

            if (ballx < 0) {
                balldirx = -balldirx;
            }

            if (bally < 0) {
                balldiry = -balldiry;
            }

            if (ballx > 670) {
                balldirx = -balldirx;
            }
        }

        repaint();
    }
}
