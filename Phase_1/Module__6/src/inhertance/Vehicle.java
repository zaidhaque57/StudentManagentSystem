package inhertance;


public class Vehicle {
    protected String name;
    public String model;
    public int noOfTyres;

    public Vehicle(){
        this.name = "";
        this.model = "";
        this.noOfTyres = -1;
    }

    Vehicle(String name, String model, int noOfTyres){
        this.name = name;
        this.model = model;
        this.noOfTyres = noOfTyres;
    }

    void StartEngine(){
        System.out.printf("Engine is Starting of %s : %s\n",name, model);
    }

    void StopEngine(){
        System.out.printf("Engine is Stopping of %s : %s\n",name, model);
    }

}
