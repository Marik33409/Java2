package Marathon;

public class Course {
    Barrier[] barriers;

    public Course(Barrier... obstacles) {
        this.barriers = obstacles;
    }

    public void doIt(Team team) {
        System.out.println("Препятствия проходит команда" + " " + team.name + ":");
        for (Competitor c : team.getCompetitors()) {
            for (Barrier b : barriers) {
                b.doIt(c);
                if (!c.isOnDistance())
                    break;
            }
        }
    }

}
