package multithreading.liveliness;

/** Livelock Example
 *  From https://stackoverflow.com/questions/1036364/good-example-of-livelock
 *  A husband and wife are trying to eat, but only have one spoon between them.
 *  Each spouse is too polite, and will pass the spoon to their spouse if the spouse has not eaten
 * */
public class Livelock {
    static class Spoon {
        private Diner owner;
        public Spoon(Diner d) {
            owner = d;
        }

        public synchronized Diner getOwner() { return owner; }
        public synchronized void setOwner(Diner d) { owner = d; }
        public synchronized void use() {
            System.out.printf("%s has eaten!", owner.name);
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;

        public Diner(String n) {
            name = n;
            isHungry = true;
        }
        public String getName() { return name; }
        public boolean isHungry() { return isHungry; }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                // Don't have the spoon, so wait patiently for spouse.
                if (spoon.owner != this) {
                    try {
                        Thread.sleep(1);
                    }
                    catch(InterruptedException e) { continue; }
                    continue;
                }

                // If spouse is hungry, insist upon passing the spoon.
                if (spouse.isHungry()) {
                    System.out.printf(
                            "%s: You eat first my darling %s!%n",
                            name, spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }

                // Spouse wasn't hungry, so finally eat
                spoon.use();
                isHungry = false;
                System.out.printf(
                        "%s: I am stuffed, my darling %s!%n",
                        name, spouse.getName());
                spoon.setOwner(spouse);
            }
        }
    }

    public static void main(String[] args) {
        final Diner husband = new Diner("Bob");
        final Diner wife = new Diner("Alice");

        final Spoon s = new Spoon(wife);

        new Thread(new Runnable() {
            public void run() { husband.eatWith(s, wife); }
        }).start();

        new Thread(new Runnable() {
            public void run() { wife.eatWith(s, husband); }
        }).start();
    }
}