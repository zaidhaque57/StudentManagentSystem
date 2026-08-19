package inhertance;

public class Main {
    public static void main(String[]args){
        Car c = new Car("Maruti", "800", 4,5, "Automatic");
//        c.StartEngine();
//        c.StartAc();
//        c.StopEngine();

        MotorCycle m = new MotorCycle("KTM", "200", 2,"U style","hightrolicpress");
        m.StartEngine();
        m.wheelie();
        m.StopEngine();
    }
}
