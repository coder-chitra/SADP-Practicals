
interface BeatModel {
    void start();

    void stop();

    int getBPM();
}

class HeartModel {
    private int heartRate = 72;

    public int getHeartRate() {
        return heartRate;
    }
}

class HeartAdapter implements BeatModel {
    private HeartModel heart;

    HeartAdapter(HeartModel heart) {
        this.heart = heart;
    }

    public void start() {
        System.out.println("Heart monitoring started");
    }

    public void stop() {
        System.out.println("Heart monitoring stopped");
    }

    public int getBPM() {
        return heart.getHeartRate();
    }
}

public class HeartAdapterDemo {
    public static void main(String[] args) {
        HeartModel heart = new HeartModel();
        BeatModel adapter = new HeartAdapter(heart);

        adapter.start();
        System.out.println("Heart rate: " + adapter.getBPM()
                + " BPM");
        adapter.stop();
    }
}
