package Marathon;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(new Cross(300), new Wall(30), new Water(3));
        Team team = new Team("Простоквашино", new Human("Дядя Фёдор"), new Human("Печкин"), new Dog("Шарик"), new Cat("Матросскин"));
        course.doIt(team);
        team.winners();
    }
}
