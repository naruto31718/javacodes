/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dynata
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
public class MapGenerator {
    public int[][] map;
    public int brickwidth;
    public int brickheight;

    public MapGenerator(int r,int c){
        map=new int[r][c];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                map[i][j]=1;
            }
        }
        brickwidth=540/c;
        brickheight=150/r;
    }

    public void draw(Graphics2D g){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]>0){
                    g.setColor(Color.white);
                    g.fillRect(j * brickwidth+80,i * brickheight+50,brickwidth,brickheight);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickwidth+80,i * brickheight+50,brickwidth,brickheight);
                }
            }
        }
    }

    public void setbrickvalue(int val,int row,int col){
        map[row][col]=val;
    }
}
