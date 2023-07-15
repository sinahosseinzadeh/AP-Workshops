import java.time.Clock;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        ClockDisplay clock=new ClockDisplay(5,59,57);
        for(int i=1;i<=5;i++){
            System.out.println(clock.getTime());
            clock.timeTick();
        }
        ClockDisplay systemClock=new ClockDisplay(new Date());
        System.out.println("this is System Clock :");
        for(int i=1;i<=60;i++){
            System.out.println(systemClock.getTime());
            systemClock.timeTick();
        }
    }
}
