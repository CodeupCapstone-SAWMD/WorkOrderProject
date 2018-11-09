package SandBox;

public class SleepIn{

	public Boolean weekday;
	public Boolean vacation;
	public SleepIn (){
	}

	public Boolean sleepIn(Boolean weekday, Boolean vacation){
			if (weekday != true || vacation == true){
				return true;
			}else{
				return false;
			}
	}

	public static void main (String[] args){
		SleepIn test = new SleepIn();
			System.out.println(test.sleepIn(true, false));
	}

}