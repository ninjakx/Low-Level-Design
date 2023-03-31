package MeetingScheduler;


public class Main {
    public static void main (String[] args) {
        Room room1 = new Room("room1");
        Room room2 = new Room("room2");
        Room room3 = new Room("room3");

        Scheduler schedule = new Scheduler();
        schedule.addRoom(room1);
        schedule.addRoom(room2);
        schedule.addRoom(room3);


        String allotedBook = schedule.book(1, 3, 7);
        allotedBook = schedule.book(1, 4, 5);
        allotedBook = schedule.book(1, 5, 7);
        allotedBook = schedule.book(1, 6, 7);

        System.out.printf("Room Alloted: %s\n", allotedBook);

    }
}
