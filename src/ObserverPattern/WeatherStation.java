package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

// subject interface
interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}

// observer interface
interface Observer {
    public void update(float temp, float humidity, float pressure);
}

// common method interface in all the displays
interface DisplayElement {
    public void display();
}

// concrete impl of the subject interface
class WeatherData implements Subject { // youtube

    private List<Observer> observerList; //
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}

// concrete impl of the observer interface
class CurrentConditonsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData; // composition

    public CurrentConditonsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }



    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("CurrentConditonsDisplay{" +
                "pressure=" + pressure +
                ", humidity=" + humidity +
                ", temperature=" + temperature +
                '}');
    }
}

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditonsDisplay currentConditonsDisplay =
                new CurrentConditonsDisplay(weatherData);
//        weatherData.registerObserver(currentConditonsDisplay);
//        weatherData.removeObserver(currentConditonsDisplay);
        weatherData.setMeasurements(80, 65, 30.4F);
        weatherData.setMeasurements(82, 70, 29.2F);
        weatherData.setMeasurements(78, 90, 29.23F);
    }
}
