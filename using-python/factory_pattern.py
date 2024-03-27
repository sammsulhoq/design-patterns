from abc import ABC, abstractmethod

# Product interface
class Button(ABC):
    
    @abstractmethod
    def render(self):
        pass

    @abstractmethod
    def on_click(self, f):
        pass


# Concrete products
class WindowsButton(Button):
    def render(self):
        # Render a button in Windows style
        print("This is a Windows Button")
        pass

    def on_click(self, f):
        # Bind a native OS click event
        pass


class HTMLButton(Button):
    def render(self):
        # Render an HTML representation of a button
        print("This is an HTML Button")
        pass

    def on_click(self, f):
        # Bind a web browser click event
        pass

# Creator class
class Dialog(ABC):
    @abstractmethod
    def create_button(self) -> Button:
        pass

    def close_dialog(self):
        pass

    def render(self):
        ok_button = self.create_button()
        ok_button.on_click(self.close_dialog)
        ok_button.render()


# Concrete Creators
class WindowsDialog(Dialog):
    def create_button(self) -> Button:
        return WindowsButton()
    

class WebDialog(Dialog):
    def create_button(self) -> Button:
        return HTMLButton()

# Application class
class Application:

    def __init__(self) -> None:
        self.dialog = None

    def read_application_config_file(self):
        # Dummy method to read application config file
        return {'Target': 'Windows'}

    def initialize(self):
        config = self.read_application_config_file()
        if config['Target'] == "Windows":
            self.dialog = WindowsDialog()
        elif config['Target'] == "Web":
            self.dialog = WebDialog()
        else:
            raise Exception("Error! Unknown environment passed.")
        
    def main(self):
        self.initialize()
        self.dialog.render()


# Usage
app = Application()
app.main()