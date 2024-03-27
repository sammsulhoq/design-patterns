from abc import ABC, abstractmethod

# Abstract factory interface
class GUIFactory(ABC):
    
    @abstractmethod
    def create_button(self):
        pass

    @abstractmethod
    def create_checkbox(self):
        pass


class Button(ABC):
    @abstractmethod
    def paint(self):
        pass


class Checkbox(ABC):
    @abstractmethod
    def paint(self):
        pass


class WinButton(Button):
    def paint(self):
        print("Render a button in Windows style.")

class MacButton(Button):
    def paint(self):
        print("Render a button in Mac style.")

class WinCheckbox(Checkbox):
    def paint(self):
        print("Render a checkbox in Windows style.")


class MacCheckbox(Checkbox):
    def paint(self):
        print("Render a checkbox in Mac style.")


# Windows factory implmentation (Concrete)
class WinFactory(GUIFactory):
    def create_button(self):
        return WinButton()
    
    def create_checkbox(self):
        return WinCheckbox()
    

class MacFactory(GUIFactory):
    def create_button(self):
        return MacButton()
    
    def create_checkbox(self):
        return MacCheckbox()
    

class Application:
    def __init__(self, factory: GUIFactory) -> None:
            self.factory = factory
            self.button = None

    def create_ui(self):
        self.button = self.factory.create_button()

    def paint(self):
        self.button.paint()


class ApplicationConfigurator:

    def read_application_config_file(self):
        return {'OS': 'Windows'}

    def main(self):
        config = self.read_application_config_file()

        if config['OS'] == "Windows":
            factory = WinFactory()
        elif config['OS'] == "Mac":
            factory = MacFactory()
        else: 
            raise Exception("Error! Unknown operating system.")
        
        app = Application(factory)
        app.create_ui()
        app.paint()


configurator = ApplicationConfigurator()
configurator.main()