interface FileSystemReceiver {
  openFile(): void
  writeFile(): void
  closeFile(): void
}

class UnixFileSystemReceiver implements FileSystemReceiver {
  openFile(): void {
    console.log("Opening file in Unix OS")
  }

  writeFile(): void {
    console.log("Writing file in Unix OS")
  }

  closeFile(): void {
    console.log("Closing file in Unix OS")
  }
}

class WindowsFileSystemReceiver implements FileSystemReceiver {
  openFile(): void {
    console.log("Opening file in Windows OS")
  }

  writeFile(): void {
    console.log("Writing file in Windows OS")
  }

  closeFile(): void {
    console.log("Closing file in Windows OS")
  }
}

interface Command {
  execute(): void
}

class OpenFileCommand implements Command {
  private fileSystem: FileSystemReceiver

  constructor(fs: FileSystemReceiver) {
    this.fileSystem = fs
  }

  execute(): void {
    this.fileSystem.openFile()
  }
}

class WriteFileCommand implements Command {
  private fileSystem: FileSystemReceiver

  constructor(fs: FileSystemReceiver) {
    this.fileSystem = fs
  }

  execute(): void {
    this.fileSystem.writeFile()
  }
}

class CloseFileCommand implements Command {
  private fileSystem: FileSystemReceiver

  constructor(fs: FileSystemReceiver) {
    this.fileSystem = fs
  }

  execute(): void {
    this.fileSystem.closeFile()
  }
}

class FileInvoker {
  private command: Command

  constructor(c: Command) {
    this.command = c
  }

  execute(): void {
    this.command.execute()
  }
}

class FileSystemReceiverUtil {
  static getUnderlyingFileSystem(): FileSystemReceiver {
    const osName = "Windows" // Hardcoded for demonstration
    console.log("Underlying OS is:", osName)
    if (osName === "Windows") {
      return new WindowsFileSystemReceiver()
    } else {
      return new UnixFileSystemReceiver()
    }
  }
}

function main(): void {
  // Creating the receiver object
  const fs: FileSystemReceiver =
    FileSystemReceiverUtil.getUnderlyingFileSystem()

  // Creating command and associating with receiver
  const openFileCommand: Command = new OpenFileCommand(fs)

  // Creating invoker and associating with Command
  const file: FileInvoker = new FileInvoker(openFileCommand)

  // Perform action on invoker object
  file.execute()

  const writeFileCommand: Command = new WriteFileCommand(fs)
  const file2: FileInvoker = new FileInvoker(writeFileCommand)
  file2.execute()

  const closeFileCommand: Command = new CloseFileCommand(fs)
  const file3: FileInvoker = new FileInvoker(closeFileCommand)
  file3.execute()
}

// Usage
main()
