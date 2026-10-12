
class CeilingFan {
    void on() {
        System.out.println("Ceiling fan is ON");
    }

    void off() {
        System.out.println("Ceiling fan is OFF");
    }
}

interface Command {
    void execute();

    void undo();
}

class FanOnCommand implements Command {
    private CeilingFan fan;

    FanOnCommand(CeilingFan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.on();
    }

    public void undo() {
        fan.off();
    }
}

class FanOffCommand implements Command {
    private CeilingFan fan;

    FanOffCommand(CeilingFan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.off();
    }

    public void undo() {
        fan.on();
    }
}

class RemoteControl {
    private Command lastCommand;

    void pressButton(Command command) {
        command.execute();
        lastCommand = command;
    }

    void pressUndo() {
        if (lastCommand != null) {
            lastCommand.undo();
            lastCommand = null;
        } else {
            System.out.println("Nothing to undo");
        }
    }
}

public class CeilingFanDemo {
    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();

        Command on = new FanOnCommand(fan);
        Command off = new FanOffCommand(fan);

        RemoteControl remote = new RemoteControl();

        remote.pressButton(on);
        remote.pressUndo();

        remote.pressButton(off);
        remote.pressUndo();
    }
}
