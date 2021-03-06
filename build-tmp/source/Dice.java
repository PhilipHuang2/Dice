import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

int x, y;
Die Philip;
Die Joe;
Die Jam;
Die Jill;

public void setup()
{
  noLoop();
   background(220);
  size(400,400);
  Philip = new Die(160,60);
  Joe = new Die(60,160);
  Jam =  new Die(260,160);
  Jill = new Die(160,260);
  
}
public void draw()
{
  background(220);
  Philip.roll();
  Philip.meter("UP");
  Joe.roll();
  Joe.meter("LEFT");
  Jam.roll();
  Jam.meter("RIGHT");
  Jill.roll();
  Jill.meter("DOWN");
  strokeWeight(1);
   stroke(255);
  line(0,0,400,400);
  line(400,0,0,400);
  stroke(0);
  strokeWeight(5);
  point(200,200);
  
  Philip.show();
  Joe.show();
  Jam.show();
  Jill.show();
}

public void mousePressed()
{
  redraw();
}

class Die //models one single dice cube
{
  int DX, DY, DieNum,DieSize;
 String Dir;
 int bar, lap;
  
  Die(int x, int y) //constructor
  {
    DX = x;
    DY = y;
    DieNum = 0;
    DieSize = 14;
    Dir = "";
    bar = 0;

  }
  public void roll()
  {
    DieNum = (int)(Math.random()*6 + 1);
  }
  public void show()
  {
    strokeWeight(1);
    fill(172,194,186);
    rect(DX, DY, 80, 80);
    fill(255);
    
    //Die 1-6
    if(DieNum == 1){
      ellipse(DX+40, DY+40, DieSize, DieSize); //middle dot
    }
    else if(DieNum == 2){
         ellipse(DX+20, DY+60, DieSize, DieSize);//Left Bottom dot
         ellipse(DX+60, DY+20, DieSize, DieSize);//Right Top dot
    }
    else if (DieNum == 3){
      ellipse(DX+40, DY+40, DieSize, DieSize); //middle dot
      ellipse(DX+20, DY+60, DieSize, DieSize);//Left Bottom dot
         ellipse(DX+60, DY+20, DieSize, DieSize);//Right Top  dot
    }
    else if (DieNum == 4){
      ellipse(DX+20, DY+60, DieSize, DieSize);//Left Bottom dot
         ellipse(DX+60, DY+20, DieSize, DieSize);//Right Top  dot
         ellipse(DX+20, DY+20, DieSize, DieSize);//Left Top dot
         ellipse(DX+60, DY+60, DieSize, DieSize);//Right Bottom dot
    }
    else if(DieNum == 5){
         ellipse(DX+40, DY+40, DieSize, DieSize); //middle dot
      ellipse(DX+20, DY+60, DieSize, DieSize);//Left Bottom dot
      ellipse(DX+60, DY+60, DieSize, DieSize);//Right Bottom dot
      ellipse(DX+20, DY+20, DieSize, DieSize);//Left Top dot
         ellipse(DX+60, DY+20, DieSize, DieSize);//Right Top  dot
    }
    else {
      ellipse(DX+20, DY+20, DieSize, DieSize);//Left Top dot
      ellipse(DX+40, DY+20, DieSize, DieSize);//Middle Top dot
      ellipse(DX+60, DY+20, DieSize, DieSize);//Right Top dot
      ellipse(DX+20, DY+60, DieSize, DieSize);//Left Bottom dot
      ellipse(DX+40, DY+60, DieSize, DieSize);//Middle Bottom dot
      ellipse(DX+60, DY+60, DieSize, DieSize);//Right Bottom dot 
      
    }
    if(lap>2){
      fill(0);
      rect(DX, DY, 80, 80);
      lap = 0;
    }
  }
   public void meter(String Dir)
  {
    bar = bar + DieNum*5;
    if (Dir=="LEFT")
    {
      fill(255,0,0);
      triangle(200, 200, 200 - bar, 200 + bar, 200 - bar, 200 - bar);
    }
    else if (Dir.equals("RIGHT"))
    {
       fill(0,255,0);
      triangle(200,200,200 + bar,200 + bar,200 + bar,200 - bar);
    }
    else if (Dir.equals("UP"))
    {
       fill(0,0,255);
      triangle(200,200,200 - bar,200 - bar,200 + bar,200 - bar);
    }
    else if (Dir.equals("DOWN"))
    {
      fill(128,0,128);
      triangle(200, 200, 200 - bar, 200 + bar, 200 +bar, 200 + bar);
    }
    
    if(bar > 200)
    {
      bar = 0;
      lap++;
    } 
  }
}   
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
