interface Observer {
    update(subject: Subject): void;
}

interface Subject {
    addObserver(observer: Observer): void;
    removeObserver(observer: Observer): void;
    notifyObservers(): void;
}

class Publisher implements Subject {
    private observers: Observer[] = [];

    public addObserver(observer: Observer): void {
        if (!this.observers.includes(observer)) {
            this.observers.push(observer);
        }
    }

    public removeObserver(observer: Observer): void {
        const observerIndex = this.observers.indexOf(observer);
        if (observerIndex !== -1) {
            this.observers.splice(observerIndex, 1);
        }   
    }

    public notifyObservers(): void {
        for (const observer of this.observers) {
            observer.update(this)
        }
    }
}

class WeatherStation extends Publisher {
    public temperature: Number;

    public setTemperature(temperature: Number): void {
        this.temperature = temperature;
        this.notifyObservers();
    }
}

class PhoneDisplay implements Observer {
    public update(subject: Subject): void {
        if (subject instanceof WeatherStation) {
            const temperature = subject.temperature;
            console.info(`Temperature is ${temperature} deg Celsuis`);
        }
    }
}

const weatherStation = new WeatherStation();
const phoneDisplay = new PhoneDisplay();

weatherStation.addObserver(phoneDisplay);
weatherStation.setTemperature(25)