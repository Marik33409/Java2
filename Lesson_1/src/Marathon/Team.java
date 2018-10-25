package Marathon;

public class Team {
    String name;

    Competitor[] competitors;


    public Team(String name, Competitor... competitors) {
        this.name = name;
        this.competitors = competitors;
    }

    public void winners() {
        for (Competitor с : competitors) {
            if (с.isOnDistance()) {
                с.info();
            }
        }
    }

    public void showResults() {
        for (Competitor с : competitors) {
            с.info();
        }
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

}
