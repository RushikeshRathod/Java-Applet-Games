/*
when i will press the key only user button will move....
now making the comp box to move automatically...
means it should get the row cor and col cor in runtime only ...
how can we manage that...?
surely we have to draw that in paint only..
thing is we will write algo in paint and call it back...
now the problem is when it is looping the the paint and again the paint is called ..
wont that loop will mix..
half the game have done..
now health...
we can take up the variable count which can be initially given 
value 10 later ..
when the position mathches value can be deducted ..
and 

*/import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class wave extends Applet implements KeyListener  
{
	Button com1,user;
	boolean goingup=false,goingdown=true,goingright=true,goingleft=false, colorchoice=true;
	int userrow=300,usercol=250,userwidth=50,userheight=50,maxcol=499,maxrow=599,userstep=10;
	int comprow=0,compcol=0,compwidth=50,compheight=50,level=0;
	int counter=10,compstep=10;
	Font f;
	public  void init() 
	{
		f=new Font("calibre",Font.BOLD|Font.ITALIC,32);
		addKeyListener(this);

	}
	
	public void keyPressed(KeyEvent ke)
	{
		int k=ke.getKeyCode();
		if(k==KeyEvent.VK_UP)
			if(userrow==10)
			{
			}else
			{	
				userrow-=userstep;
				repaint();
			}

		if(k==KeyEvent.VK_RIGHT)
			if(usercol==440)
			{
			}else
			{	
				usercol+=userstep;
				repaint();
			}
		if(k==KeyEvent.VK_DOWN)
			if(userrow==540)
			{
			}else
			{	
				userrow+=userstep;
				repaint();
			}
		if(k==KeyEvent.VK_LEFT)
			if(usercol==10)
			{
			}else
			{
				usercol-=userstep;
				repaint();
			}
	}
	public void keyReleased(KeyEvent ke)
	{
	}
	public void keyTyped(KeyEvent ke)
	{
	}
	public  void paint(Graphics g)//if comp reaches bottom of the row 
	//then going down must change its value...
	{
		
		if(colorchoice==true)//take choice true and returns false
		{
			g.setColor(Color.black);
			g.fillRect(10,10,480,580);
			colorchoice=false;
		}else
		{
			g.setColor(Color.black);
			g.fillRect(10,10,480,580);
			colorchoice=true;

		}
		if(userrow==comprow&&usercol==compcol)
			counter-=1;
		if(counter==9)
		{
			g.drawString("Game Over",200,200);
			 System.exit(0);
		}
		g.drawString(Integer.toString(counter),600,200);
		g.drawRect(10,10,480,580);
		g.setColor(Color.red);
		g.fillRect(usercol,userrow,userwidth,userheight);
		//g.drawRect(10,10,430,530);
		g.fillRect(compcol,comprow,compwidth,compheight);
		if(goingdown==true)
		{	
			try
			{
				comprow+=compstep;
				if(comprow==530 )
				goingdown=!goingdown;
				Thread.sleep(10-level);
				repaint();
			}
			catch(Exception e)
			{
			}
		}else
		{
			try
			{
				comprow-=compstep;
				if(comprow==10 )
				goingdown=!goingdown;
				Thread.sleep(10-level);
				repaint();
				
			}
			catch (Exception e)
			{
			}
		}
		if (goingright==true)
		{
			try
			{
				compcol+=compstep;
				if(compcol==430 )
				goingright=!goingright;
				Thread.sleep(10-level);
				repaint();
				
			}
			catch (Exception e)
			{
			}
			
		}else
		{
				try
			{
				compcol-=compstep;
				if(compcol==10 )
				goingright=!goingright;
				Thread.sleep(10-level);
				repaint();
			}
			catch (Exception e)
			{
			}
				
		}
 	}
}
/*
<applet code="wave" width=700 height=600>
</applet>
*/