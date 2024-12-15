package mongojava;

import java.util.*;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class first {

    public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to MongoDB!");
     
        
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        System.out.println("MongoDB client created successfully.");

       
        MongoDatabase db = mongoClient.getDatabase("mongodbjava");
        System.out.println("Connected to the 'mongodbjava' database successfully.");

     
        System.out.println("Listing all databases:");
       MongoCursor<String> dbCursor = mongoClient.listDatabaseNames().iterator();
            while (dbCursor.hasNext()) {
                System.out.println(dbCursor.next());
            }
            System.out.println("Enter the database name to view its collections: ");
          
			
            String dbName = sc.next();
            System.out.println("The collection in " +dbName+ " database");
            db=mongoClient.getDatabase(dbName);
            for (String collectionName : db.listCollectionNames()) {
                System.out.println(collectionName);
            }
        } 
    }

