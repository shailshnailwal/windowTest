class StopWatch implements Runnable{

	int i;
	Thread t;
	public StopWatch(int hr){
		
		i = hr * 60 * 60;
		t = new Thread(this, "Stop Watch Thread");
		t.start();
	}
	
	public void run(){
		
		int temp;
		try{
			for(int j = 0; j < i; j ++){
		
				int hour = j / 3600;
				temp = j % 3600;
				int minut = temp / 60;
				temp = temp % 60;
				int second = temp;
				System.out.println(" " + hour + " : " + minut + " : " + second);
				t.sleep(1000);
			}	
		}
		catch(Exception e){
		
		}
	}
}

public class MainThread{

	public static void main(String[] arg){
		
		StopWatch sw = new StopWatch(1);
	}
}