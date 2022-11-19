package city;

/**
 *
 * @author Lucas Moragas Melo Oliveira
 */
public class City {
    private String Id;
    private String name;
    private boolean fireBrigade; //Fire brigade presence
    private boolean penitentiary; //Penitentiary presence
    private int collection; //Collection category
    private int economicActivity; //Type of economic activity
    private float funds;
    private String notes;
    private static int amountOfCities;
    
    /*
    The Id it's aways formed by 3 letters and 6 number
    
    Kind of collections:
        1 - Human Development Index above 0.8
        2 - Human Development Index between 0.7 and 0.8
        3 - Other cities
    
    Kind of economic activities:
        1 - Farming
        2 - Industrial
        3 - Services provision
    */

    public City() {
        this.Id = "";
        this.name = "";
        this.fireBrigade = false;
        this.penitentiary = false;
        this.collection = 0;
        this.economicActivity = 0;
        this.funds = 0;
        this.notes = "";
    }
    
    public City(String Id, String name, boolean fireBrigade, boolean penitentiary, int collection, int economicActivity, float funds, String notes) {
        this.Id = Id;
        this.name = name;
        this.fireBrigade = fireBrigade;
        this.penitentiary = penitentiary;
        this.collection = collection;
        this.economicActivity = economicActivity;
        this.funds = funds;
        this.notes = notes;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFireBrigade() {
        return fireBrigade;
    }

    public void setFireBrigade(boolean fireBrigade) {
        this.fireBrigade = fireBrigade;
    }

    public boolean isPenitentiary() {
        return penitentiary;
    }

    public void setPenitentiary(boolean penitentiary) {
        this.penitentiary = penitentiary;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public int getEconomicActivity() {
        return economicActivity;
    }

    public void setEconomicActivity(int economicActivity) {
        this.economicActivity = economicActivity;
    }

    public float getFunds() {
        return funds;
    }

    public void setFunds(float funds) {
        this.funds = funds;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static int getAmountOfCities() {
        return amountOfCities;
    }

    public static void setAmountOfCities(int amountOfCities) {
        City.amountOfCities = amountOfCities;
    }

    @Override
    public String toString() {
        return "City{" + "Id=" + Id + ", name=" + name + ", fireBrigade=" + fireBrigade + ", penitentiary=" + penitentiary + ", collection=" + collection + ", economicActivity=" + economicActivity + ", funds=" + funds + ", notes=" + notes + '}';
    }
    
}
