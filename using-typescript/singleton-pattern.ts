class Database {
  private static instance: Database | null = null

  private constructor() {}

  public static getInstance(): Database {
    if (!Database.instance) {
      Database.instance = new Database()
    }

    return Database.instance
  }

  public query(sql: string): void {
    // This will execute the queries
  }
}

class Application {
  public main(): void {
    const database = Database.getInstance()
    database.query("SELECT..")

    const anotherDbConnection = Database.getInstance()
    anotherDbConnection.query("SELECT..")

    console.info(database === anotherDbConnection)
  }
}

const app = new Application()
app.main()
