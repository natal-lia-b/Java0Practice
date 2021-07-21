package topic4.part1_SimpleClasses.task10;

enum WeekDays {
    SUN("Sun"),
    MON("Mon"),
    TUE("Tue"),
    WED("Wed"),
    THU("Thu"),
    FRI("Fri"),
    SAT("Sat");

    private String name;

    WeekDays(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
