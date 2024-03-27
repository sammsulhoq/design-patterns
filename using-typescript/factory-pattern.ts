interface Button {
    render(): void;
    onClick(f: Function): void;
}

class WindowsButton implements Button {
    public render(): void {
        console.info("This is a Windows Button")
    }

    public onClick(f: Function): void {
        console.info("Window button click functionality")
    }
}

class HTMLButton implements Button {
    public render(): void {
        console.info("This is an HTML Button")
    }

    public onClick(f.Function): void {
        console.info("HTML button click functionality")
    }
}

abstract class Dialog {
    abstract createButton(): Button;

    closeDialog(): void {
        // Implement for closing dialog
    }

    render(): void {
        const okButton = this.createButton();
        okButton.onClick(this.closeDialog);
        okButton.render();
    }
}

class WindowsDialog implements Dialog {
    public createButton(): Button {
        return new WindowsButton();
    }
}

class HTMLDialog implements Dialog {
    public createButton(): Button {
        return new HTMLButton();
    }
}

class Application {
    private dialog: Dialog | null = null;

    readApplicationConfigFile(): {Target:string} {
        // Dummy method to read application config file
        return { Target = 'Windows'};
    }

    initialize(): void {
        const config = this.readApplicationConfigFile();
        if (config.Target == "Windows") {
            this.dialog = new WindowsDialog();
        } else if (config.Target == "Web") {
            this.dialog = new HTMLButton();
        } else {
            throw new Error("Error! Unknown target environment")
        }
    }

    main(): void {
        this.initialize();
        if (this.dialog) {
            this.dialog.render();
        }
    }
}

// Usage
const app = new Application();
app.main();