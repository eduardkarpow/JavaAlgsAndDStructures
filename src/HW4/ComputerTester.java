package HW4;

public class ComputerTester {
    public static void main(String[] args) {
        Computer comp1 = new Computer(ComputerEnum.NOTEBOOK);
        System.out.println(comp1);
    }
}

class Computer {
    private Processor processor;
    private Memory memory;
    private Monitor monitor;
    public Computer(ComputerEnum comp){
        this.processor = new Processor(comp.getProcessorModel(), comp.getClockSpeed());
        this.memory = new Memory(comp.getMemorySize());
        this.monitor = new Monitor(comp.getDiagonal());
    }

    @Override
    public String toString() {
        return this.processor.toString() + " " + this.memory.toString() + " "+ this.monitor.toString();
    }
}
enum ComputerEnum{
    POWERFULL_PC("intel core i9", 4.1, 64, 17),
    LIGHT_PC("intel core i5", 3.2, 16,16),
    NOTEBOOK("intel core i3", 3.5, 16,14);
    private String processorModel;
    private double clockSpeed;
    private int memorySize, diagonal;
    ComputerEnum(String processorModel, double clockSpeed, int memorySize, int diagonal){
        this.processorModel = processorModel;
        this.clockSpeed = clockSpeed;
        this.memorySize = memorySize;
        this.diagonal = diagonal;
    }

    public String getProcessorModel() {
        return processorModel;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getDiagonal() {
        return diagonal;
    }
}
class Processor{
    private String model;
    private double clockSpeed;

    public Processor(String model, double clockSpeed) {
        this.model = model;
        this.clockSpeed = clockSpeed;
    }
    public String toString(){
        return "HW4.Processor: model: "+this.model+" clockSpeed: " + this.clockSpeed+"Ghz";
    }
}
class Memory{
    private int memorySize;

    public Memory(int memorySize) {
        this.memorySize = memorySize;
    }

    @Override
    public String toString() {
        return "memory: memory size: "+ this.memorySize+"GB";
    }
}
class Monitor{
    private int diagonal;

    public Monitor(int diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "monitor: diagonal: "+ this.diagonal+"dm";
    }
}