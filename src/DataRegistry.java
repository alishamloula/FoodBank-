import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataRegistry {
    private static final String DATA_FILE = "Food_Donation_Files.txt";
    
    private List<Provider> providers = new ArrayList<>();
    private List<FoodItem> foodItems = new ArrayList<>();
    private List<Recipient> recipients = new ArrayList<>();
    private List<Delivery> deliveries = new ArrayList<>();
    private List<PickupRequest> pickupRequests = new ArrayList<>();
    
    private static DataRegistry instance;

    private DataRegistry() {
    }

    public static synchronized DataRegistry getInstance() {
        if (instance == null) {
            instance = new DataRegistry();
        }
        return instance;
    }

    public void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            writer.println("=== FOOD DONATION DATABASE ===");
            writer.println();

            writer.println("[PROVIDERS]");
            for (Provider p : providers) {
                writer.println(p.toString());
            }

            writer.println("\n[FOOD ITEMS]");
            for (FoodItem item : foodItems) {
                writer.println(item.toString());
            }

            writer.println("\n[RECIPIENTS]");
            for (Recipient r : recipients) {
                writer.println(r.toString());
            }

            writer.println("\n[PICKUP REQUESTS]");
            for (PickupRequest pr : pickupRequests) {
                writer.println(pr.toString());
            }

            writer.println("\n[DELIVERIES]");
            for (Delivery d : deliveries) {
                writer.println(d.toString());
            }
            
            System.out.println("\n--- Data successfully written to " + DATA_FILE + " ---");
            
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }

    public void addProvider(Provider p) { 
        providers.add(p); 
        save();
    }
    
    public void addFoodItem(FoodItem item) { 
        foodItems.add(item); 
        save();
    }
    
    public void addRecipient(Recipient r) { 
        recipients.add(r); 
        save();
    }
    
    public void addPickupRequest(PickupRequest r) { 
        pickupRequests.add(r); 
        save();
    }
    
    public void addDelivery(Delivery d) { 
        deliveries.add(d); 
        save();
    }

    public List<Provider> getProviders() { return providers; }
    public List<FoodItem> getFoodItems() { return foodItems; }
    public List<Recipient> getRecipients() { return recipients; }
    public List<Delivery> getDeliveries() { return deliveries; }
    public List<PickupRequest> getPickupRequests() { return pickupRequests; }
}