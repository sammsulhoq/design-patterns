from abc import ABC, abstractmethod

# Interface for FileSystemReceiver
class FileSystemReceiver(ABC):
    @abstractmethod
    def open_file(self):
        pass

    @abstractmethod
    def write_file(self):
        pass

    @abstractmethod
    def close_file(self):
        pass

# Concrete implementations for Unix and Windows FileSystemReceiver
class UnixFileSystemReceiver(FileSystemReceiver):
    def open_file(self):
        print("Opening file in Unix OS")

    def write_file(self):
        print("Writing file in Unix OS")

    def close_file(self):
        print("Closing file in Unix OS")

class WindowsFileSystemReceiver(FileSystemReceiver):
    def open_file(self):
        print("Opening file in Windows OS")

    def write_file(self):
        print("Writing file in Windows OS")

    def close_file(self):
        print("Closing file in Windows OS")

# Interface for Command
class Command(ABC):
    @abstractmethod
    def execute(self):
        pass

# Concrete Command implementations
class OpenFileCommand(Command):
    def __init__(self, file_system):
        self.file_system = file_system

    def execute(self):
        self.file_system.open_file()

class WriteFileCommand(Command):
    def __init__(self, file_system):
        self.file_system = file_system

    def execute(self):
        self.file_system.write_file()

class CloseFileCommand(Command):
    def __init__(self, file_system):
        self.file_system = file_system

    def execute(self):
        self.file_system.close_file()

# Invoker class
class FileInvoker:
    def __init__(self, command):
        self.command = command

    def execute(self):
        self.command.execute()

# Utility class to get underlying FileSystemReceiver based on OS
class FileSystemReceiverUtil:
    @staticmethod
    def get_underlying_file_system():
        os_name = "Windows"  # For simplicity, hardcoded for demonstration
        print("Underlying OS is:", os_name)
        if os_name == "Windows":
            return WindowsFileSystemReceiver()
        else:
            return UnixFileSystemReceiver()

# Client code
def main():
    # Creating the receiver object
    fs = FileSystemReceiverUtil.get_underlying_file_system()

    # Creating command and associating with receiver
    open_file_command = OpenFileCommand(fs)

    # Creating invoker and associating with Command
    file = FileInvoker(open_file_command)

    # Perform action on invoker object
    file.execute()

    write_file_command = WriteFileCommand(fs)
    file = FileInvoker(write_file_command)
    file.execute()

    close_file_command = CloseFileCommand(fs)
    file = FileInvoker(close_file_command)
    file.execute()

if __name__ == "__main__":
    main()
