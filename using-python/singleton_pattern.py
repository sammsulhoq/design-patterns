class Database:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)

        return cls._instance


# Usage
databaseObj = Database()
anotherDatabaseObj = Database()

print(databaseObj is anotherDatabaseObj)