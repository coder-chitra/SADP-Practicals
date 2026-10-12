
class Light {
    void on() {
        System.out.println("Light is ON");
    }

    void off() {
        System.out.println("Light is OFF");
    }
}

class Television {
    void on() {
        System.out.println("TV is ON");
    }

    void off() {
        System.out.println("TV is OFF");
    }
}

interface Command {
    void execute();
}

class LightOnCommand implements Command {
    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}

class TVOnCommand implements Command {
    private Television tv;

    TVOnCommand(Television tv) {
        this.tv = tv;
    }w

    public void execute() {
        tv.on();
    }
}

class RemoteControl {
    void pressButton(Command command) {
        command.execute();
    }
}

public class RemoteControlDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Television tv = new Television();

        RemoteControl remote = new RemoteControl();

        remote.pressButton(new LightOnCommand(light));
        remote.pressButton(new LightOffCommand(light));
        remote.pressButton(new TVOnCommand(tv));
    }
}
