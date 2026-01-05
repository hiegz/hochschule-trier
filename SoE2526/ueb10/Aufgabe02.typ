Klassen sollten ihre Abhängigkeiten bekommen, nicht selbst bauen:

```java
class Repository {
  Database database;

  public Repository(Database database) {
    this.database = database;
  }

  public User findById() {
    database.query(...);
  }
}

...

new Repository(new MySQLDatabase());


```
