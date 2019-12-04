package ua.org.training.model;

/**
 * Energy Label enum
 * @author      <a href="mailto:iryna.v.afanasieva@gmail.com">Ira Afanasieva</a>
 * @version     1.0, 12/4/2019
 */

public enum EnergyLabel {
    A_TRIPLE_PLUS   (0, 21, "A+++" ),
    A_DOUBLE_PLUS   (22, 32, "A++" ),
    A_PLUS          (33, 41, "A+"),
    A               (42, 54, "A"),
    B               (55, 74, "B"),
    C               (75, 94, "C"),
    D               (95, 109, "D"),
    E               (110, 124, "E"),
    F               (125, 149, "F"),
    G               (150, 1000, "G");

    private int minimumCapacity;
    private int maximumCapacity;
    private String label;

    private EnergyLabel(int minimumCapacity, int maximumCapacity, String label){
        this.maximumCapacity = maximumCapacity;
        this.minimumCapacity = minimumCapacity;
        this.label = label;
    }

    public int minimumCapacity(){
        return minimumCapacity;
    }

    public int maximumCapacity(){
        return maximumCapacity;
    }

    public String label(){
        return label;
    }

    public String getLabel(int capacity){
        for(EnergyLabel energyLabel : EnergyLabel.values()){
            if ((energyLabel.minimumCapacity() < capacity) && (capacity < energyLabel.maximumCapacity()))
                return G.label();
        }
        return G.label();
    }
}
