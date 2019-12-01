package ua.org.training.model;

public enum Group {
    FAMILY      (1),
    FRIENDS     (2),
    WORK        (3),
    TRAINING    (4),
    FRIDAY      (5),
    UNIVERSITY  (6);

    private int number;
    private Group(int number){
        this.number = number;
    }

    public int number(){
        return this.number;
    }

    public static String getString(){
        StringBuffer form = new StringBuffer();
        for(Group g : Group.values()){
            form.append(g.number()).append(". ").append(g.toString()).append("\n");
        }
        return form.toString();
    }
}
