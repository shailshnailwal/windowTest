import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
class FetchingData implements ActionListener,WindowListener
  {
	Frame frm;
	TextField tb;
	TextField tb1,tb2,tb3;
	Button btn,btn1;
    Connection con=null;	
	DataInputStream dis;	
	public FetchingData()
	  {
		frm=new Frame("my frame");
		frm.setLayout(new FlowLayout());
		tb=new TextField();
		tb1=new TextField();
		tb2=new TextField();
		tb3=new TextField();
		btn=new Button("add");
		btn.setBackground(Color.red);
		btn1=new Button("result");
		btn1.setBackground(Color.red);
		frm.add(tb);
		frm.add(tb1);
		frm.add(btn);
		frm.add(btn1);
		frm.add(tb2);
		frm.add(tb3);
		frm.setBackground(Color.red);
		frm.setForeground(Color.black);
		btn.addActionListener(this);
		btn1.addActionListener(this);
		frm.addWindowListener(this);
		//btn.addWindowListener(this);
		frm.setVisible(true);
		frm.setSize(500,500);
	  }
	  
	public void actionPerformed(ActionEvent ae)
		{
			try
			{
				String firstNo=tb.getText();
				int a=Integer.parseInt(firstNo);
				String secondNo=tb1.getText();
				int b=Integer.parseInt(secondNo);
				int c=a+b;
				tb2.setText(""+c);
				if(ae.getActionCommand()=="add")
				  {
						try
						{
						String str=tb2.getText();									
						FileOutputStream fos=new FileOutputStream("E:\\Read.txt");
						byte[] byt=str.getBytes();
						fos.write(byt);
						fos.close();
						System.out.println("connection going to start");		
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","jwala");						
						Statement stmt=con.createStatement();
						
						
						System.out.println("table created");
						String insertQuery="insert into sum1 (fno,secno,thadd) values("+a+","+b+","+c+")";
						stmt.executeUpdate(insertQuery);
						System.out.println("data inserted");
						}
				  catch(Exception e)
					{
						e.printStackTrace();
					}
				  finally
					{
						con.close();
					}
					
				  }
				  else if(ae.getActionCommand()=="result")
				    {
						int k=0;
						String str;
						try
						{
						//dis=new DataInputStream(new FileInputStream("E:\\addition.txt"));
						BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("E:\\addition.txt")));
						System.out.println(br);
						while((br.readLine())!=null)
						  {
							str=br.readLine();
							System.out.print(str);
							//System.out.print(""+k);
							tb3.setText(str);
							
						  }
						}
						catch(Exception e)
						  {
							e.printStackTrace();
						  }
					}
			}
			catch(Exception e)
			  {
				e.printStackTrace();
			  }
		}
	  
    
    public void windowOpened(WindowEvent e)
	  {
	  
	  }
	  
    public void windowClosing(WindowEvent e)
	  {
		System.exit(0);
		
      }
	  
    public void windowClosed(WindowEvent e)
	  {
	  
	  }
	
    public void windowIconified(WindowEvent e)
	  {
	  
	  }
	
    public void windowDeiconified(WindowEvent e)
	  {
	  
	  }
	
    public void windowActivated(WindowEvent e)
	  {
	  
	  }
	  
    public void windowDeactivated(WindowEvent e)
	  {
	  
	  }
	  
	public static void main(String args[])
		{  
			
			FetchingData fd = new FetchingData();
			
		}
		
  }