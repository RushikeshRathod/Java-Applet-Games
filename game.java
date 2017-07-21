/*
1.designing a game
group of the buttons ..
each indicating arrows which can be moved accordingly
size of the buttons...
each will have 20*20;
and their shape will fit in 60*60 pixels ..
now to perfrm the movement of the buttons...
we well initialise cellcounters..
row counter and colomn counter
now handling the endpts error
1.up error= row cant go behind zero and if action performed then it should retun the same value
object can now move anywhere in the grid..
setting up an obstacle..
properties required
1.when that grid approaches
	no movement should occour..
	mnz that if loop should have data which should be true
	so we can now store the grid no in matrix and collect them as a result of the perticula 
	position cheaker should be such that..
	when the perticular position is reached..
	it should match the list present ..
	and then give out the result..
	1.use matrix to store the data of the black cell..
	if call to matrix returns true then the position can be operated..
	and also here the matrix index and the pixel cordinates matches 
	so a bit ease ...
	ohh..
	we can set the level info .. and when it gets selected it throw
	out the info regarding the black boxex...
	now to introduce new concepts like ..
	1.bullets...
	when i press the central icon the bullet
	and when the path of the bullet will be
	till it collides with any object...

*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class game extends Applet implements ActionListener
{	
	Button r,l,u,d,f;//f foor fire..
	boolean positioncheaker,cellinfo[][]=new boolean[10][10];
	int rowcounter=0,columncounter=0,intinfo[][]={
						{0,1,1,1,1,1,0,0,0,0},
						{0,1,0,0,0,1,0,1,1,0},
						{0,1,0,1,0,1,0,1,0,0},
						{0,0,0,1,0,1,0,1,0,1},
						{1,1,1,1,0,1,0,1,0,1},
						{0,0,0,0,0,1,0,1,0,1},
						{0,1,1,1,1,1,0,1,0,1},
						{0,1,0,0,0,0,0,1,0,1},
						{0,1,0,1,1,1,1,1,0,1},
						{0,0,0,1,1,1,1,1,0,0}
												}
	;//int info stores the value of cell in int 

	 
	public void init()
	{ 
		u=new Button("^");
		d=new Button("!");
		r=new Button(">");
		l=new Button("<");
		f=new Button("F");
		setLayout(null);
		add(u);
		u.setBounds((columncounter+20),rowcounter,20,20);
		u.addActionListener(this);
		add(d);
		d.setBounds(columncounter+20,rowcounter+40,20,20);
		d.addActionListener(this);
		add(r);
		r.setBounds(columncounter+40,rowcounter+20,20,20);
		r.addActionListener(this);
		add(l);
		l.setBounds(columncounter+0,rowcounter+20,20,20);
		l.addActionListener(this);
		add(f);
		f.setBounds(columncounter+20,rowcounter+20,20,20);
		
		}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals(r.getLabel()))//right shift
		{	
			if(cellinfo[rowcounter/60][columncounter/60+1]||columncounter==540)//here the counter corresponds to last
			//position so the column counter when divided by 60 will give
			//column index.. that column index +1 th position have to be 
			//cheaked..or condition
			{
			}
			else
			{	
				rowcounter+=0;
				columncounter+=60;
				u.setBounds((columncounter+20),rowcounter,20,20);
				d.setBounds(columncounter+20,rowcounter+40,20,20);
				r.setBounds(columncounter+40,rowcounter+20,20,20);
				l.setBounds(columncounter+0,rowcounter+20,20,20);
			}		
		}
		if(ae.getActionCommand().equals(l.getLabel()))//left shift
		{	
			if(cellinfo[rowcounter/60][columncounter/60-1]||columncounter==0)
			{
			}
			else
			{	
				rowcounter+=0;
				columncounter-=60;
				u.setBounds((columncounter+20),rowcounter,20,20);
				d.setBounds(columncounter+20,rowcounter+40,20,20);
				r.setBounds(columncounter+40,rowcounter+20,20,20);
				l.setBounds(columncounter+0,rowcounter+20,20,20);
			}	
		}	
		if(ae.getActionCommand().equals(u.getLabel()))//up shift
		{	
			if(cellinfo[rowcounter/60-1][columncounter/60]||rowcounter==0)
			{
			}
			else
			{
				rowcounter-=60;
				columncounter+=0;
				u.setBounds((columncounter+20),rowcounter,20,20);
				d.setBounds(columncounter+20,rowcounter+40,20,20);
				r.setBounds(columncounter+40,rowcounter+20,20,20);
				l.setBounds(columncounter+0,rowcounter+20,20,20);
			}
		}
		if(ae.getActionCommand().equals(d.getLabel()))//down shift
		{
			if(cellinfo[rowcounter/60+1][columncounter/60]||rowcounter==540)
			{
			}
			else
			{
				rowcounter+=60;
				columncounter+=0;
				u.setBounds((columncounter+20),rowcounter,20,20);
				d.setBounds(columncounter+20,rowcounter+40,20,20);
				r.setBounds(columncounter+40,rowcounter+20,20,20);
				l.setBounds(columncounter+0,rowcounter+20,20,20);
			}
		}
		if(rowcounter==540&&columncounter==540)
		{	
			showStatus("you win");
		}
	}
	public void paint(Graphics g)
	{
		for(int i=0;i<10;i++)
		{
			for (int j=0;j<10 ;j++ )
			{
				g.drawRect(j*60,i*60,60,60);
			}
		}
		/*for(int i=0;i<10;i++)
		{
			for (int j=0;j<10 ;j++ )
			{
				if(i+j==9)
				g.fillRect(j*60,i*60,60,60);
			}
		}
		*/
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				if(intinfo[i][j]==1)
				{
					cellinfo[i][j]=true;//if occupy then true
					g.fillRect(j*60,i*60,60,60);		
				}
		
	}	
} 
/*
<applet code="game.java" width=601 height=601>
</applet>
*/