
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
class WeatherStation extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void setMeasurement(float temperature,
            float humidity,
            float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

@SuppressWarnings("deprecation")
class WeatherDisplay implements Observer {
    public void update(Observable source, Object arg) {
        WeatherStation weather = (WeatherStation) source;

        System.out.println("Temperature: "
                + weather.getTemperature());
        System.out.println("Humidity: "
                + weather.getHumidity());
        System.out.println("Pressure: "
                + weather.getPressure());
        System.out.println();
    }
}

public class WeatherStationDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        WeatherDisplay display = new WeatherDisplay();
        station.addObserver(display);

        station.setMeasurement(30.5f, 65.0f, 1012.0f);
        station.setMeasurement(32.0f, 70.0f, 1010.0f);
    }
}
