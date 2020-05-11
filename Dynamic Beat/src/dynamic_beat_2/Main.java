package dynamic_beat_2;

public class Main {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 3;   //note 떨어지는 speed
	public static final int SLEEP_TIME = 10;   // note 간격 두고 떨어지게 하는 
	public static final int REACH_TIME = 2;
	
	public static void main(String[] args) {
		
		new DynamicBeat(); 

	}

}


