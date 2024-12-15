package mongojava;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
public class first {

	public static void main(String[] args) {
		System.out.print("welcome to JDBC");
		//creating a mongodb client
        MongoClient mongoclient=new MongoClient("localhost",27017);
        System.out.println("Created mongo successfully");
        
        MongoDatabase db=mongoclient.getDatabase("mongodbjava");
        System.out.println("get data successfully");
        
        System.out.println("here.... the list of data base");
        MongoCursor<String> dbcursor = null;
		try {
			dbcursor = mongoclient.listDatabaseNames().iterator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        while(dbcursor.hasNext()) {
        	System.out.println(dbcursor.next());
        }

}
}
