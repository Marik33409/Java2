package Marathon;

public abstract class Barrier {
    public abstract void doIt(Competitor competitor);
}

class Wall extends Barrier {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}

class Water extends Barrier {
    int lenght;

    public Water(int height) {
        this.lenght = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(lenght);
    }
}

class Cross extends Barrier {
    int lenght;

    public Cross(int lenght) {
        this.lenght = lenght;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(lenght);
    }
}

class MainCross {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Bob"), new Cat("Vaska"), new Dog("Sharik")};
        Barrier[] barriers = {new Cross(80), new Wall(5), new Water(3)};

        for (Competitor c : competitors) {
            for (Barrier b : barriers) {
                b.doIt(c);
                if (!c.isOnDistance()) {
                    break;
                }
            }
        }
        for (Competitor c : competitors) {
            c.info();
        }
    }
}
