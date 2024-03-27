interface Button {
    paint(): void;
}

interface Checkbox {
    paint(): void;
}

interface GUIFactory {
    createButton(): Button;
    createCheckbox(): Checkbox;
}

class WinButton implements Button {
    paint(): void {
        console.info("Render a button in Windows style.")
    }
}

class WinCheckbox implements Checkbox {
    paint(): void {
        console.info("Render a checkbox in Windows style.")
    }
}

class MacButton implements Button {
    paint(): void {
        console.info("Render a button in Mac style.")
    }
}

class MacCheckbox implements Checkbox {
    paint(): void {
        console.info("Render a checkbox in Mac style.")
    }
}

class WinFactory implements GUIFactory {
    createButton(): Button {
        return new WinButton();
    }

    createCheckbox(): Checkbox {
        return new WinCheckbox();
    }
}

class MacFactory implements GUIFactory {
    createButton(): Button {
        return new MacButton();
    }

    createCheckbox(): Checkbox {
        return new MacCheckbox()
    }
}

class Application {
    private factory: GUIFactory;
    private button: Button | null;

    constructor(factory: GUIFactory) {
        this.factory = factory;
        this.button = null;
    }

    createUI(): void {
        this.button = this.factory.createButton();
    }

    paint(): void {
        if (this.button) {
            this.button.paint();
        }
    }
}

class ApplicationConfigurator {
    readApplicationConfigFile(): { OS: string } {
        return { OS: 'Windows' };
    }

    main(): void {
        const config = this.readApplicationConfigFile();
        let factory: GUIFactory;

        if (config.OS === "Windows") {
            factory = new WinFactory();
        } else if (config.OS === "Mac") {
            factory = new MacFactory()
        } else {
            throw new Error("Error! Unknows operating system.")
        }

        const app = new Application(factory);
        app.createUI();
        app.paint();
    }
}

const configurator = new ApplicationConfigurator();
configurator.main();