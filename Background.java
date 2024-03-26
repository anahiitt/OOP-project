public class Background {
    private String traits;
    private String ideals;
    private String bonds;
    private String flaws;
    private String features;
    // No-arg constructor
    public Background(){
        this.traits = "No information";
        this.ideals = "No information";
        this.bonds = "No information";
        this.flaws = "No information";
        this.features = "No information";
    }
    // Constructor
    public Background(String traits, String ideals,
                      String bonds, String flaws, String features) {
        this.traits = traits;
        this.ideals = ideals;
        this.bonds = bonds;
        this.flaws = flaws;
        this.features = features;
    }

    // Getters
    public String getTraits(){
        return traits;
    }
    public String getIdeals(){
        return ideals;
    }
    public String getBonds(){
        return bonds;
    }
    public String getFlaws(){
        return flaws;
    }
    public String getFeatures(){
        return features;
    }
    // Setters
    public void setTraits(String newTraits){
        if (newTraits != null)
            traits = newTraits;
        else {
            System.out.println("Not a valid trait");
            System.exit(0);
        }
    }
    public void setIdeals(String newIdeals){
        if (newIdeals != null)
            ideals = newIdeals;
        else {
            System.out.println("Not a valid ideal");
            System.exit(0);
        }
    }
    public void setBonds(String newBonds){
        if (newBonds != null)
            bonds = newBonds;
        else {
            System.out.println("Not a valid bond");
            System.exit(0);
        }
    }
    public void setFlaws(String newFlaws){
        if (newFlaws != null)
            flaws = newFlaws;
        else {
            System.out.println("Not a valid flaw");
            System.exit(0);
        }
    }
    public void setFeatures(String newFeatures){
        if (newFeatures != null)
            features = newFeatures;
        else {
            System.out.println("Not a valid feature");
            System.exit(0);
        }
    }
    // toString method
    @Override
    public String toString() {
        return "Background{" +
                "traits ='" + traits + '\'' +
                ", ideals ='" + ideals + '\'' +
                ", bonds ='" + bonds + '\'' +
                ", flaws ='" + flaws + '\'' +
                ", features ='" + features + '\'' +
                '}';
    }
}

