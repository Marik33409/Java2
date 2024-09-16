package Marathon;

public class Human implements Competitor {

    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean active;

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxJumpHeight = 40;
        this.maxSwimDistance = 200;
        this.active = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " " + "успешно пробежал");
        } else {
            System.out.println(name + " " + name + "провал");
            active = false;
        }

    }

    @Override
    public void swim(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " " + "успешно проплыл");
        } else {
            System.out.println(name + " " + name + "провал");
            active = false;
        }


    }

    @Override
    public void jump(int height) {
        if (height <= maxRunDistance) {
            System.out.println(name + " " + "успешно прыгнул");
        } else {
            System.out.println(name + " " + name + "провал");
            active = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(name + " " + active);
    }
}
