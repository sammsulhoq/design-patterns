class Observer:
    """
    Observer object which updates based on the subject
    """

    def update(self, observable, *args, **kwargs):
        pass


class Subject:
    """
    Somtimes referred to as 'Observable' is basically the 
    Subject/Publisher object which notifies the observers
    """

    def __init__(self) -> None:
        self.observers = []

    def add_observer(self, observer:Observer)-> None:
        if observer not in self.observers:
            self.observers.append(observer)

    def remove_observer(self, observer: Observer) -> None:
        if observer in self.observers:
            self.observers.remove(observer)

    def notify_observers(self, *args, **kwargs) -> None:
        for observer in self.observers:
            observer.update(self, *args, **kwargs)


class WeatherStation(Subject):
    """
    This class implements Subject/Publisher which will notify
    the subscribers when the temperature changes
    """

    def set_temperature(self, temperature) -> None:
        self.temperature = temperature
        self.notify_observers()

class PhoneDisplay(Observer):
    """
    This class implements Observer which will be benefited once 
    the subscriber publishes the changes
    """
    
    def update(self, subject, *args, **kwargs) -> None:
        if isinstance(subject, WeatherStation):
            temperature = subject.temperature
            print(f"Temperature is {temperature} deg Celsius")


if __name__ == "__main__":
    weather_station = WeatherStation()
    phone_display = PhoneDisplay()

    weather_station.add_observer(phone_display)
    weather_station.set_temperature(25)