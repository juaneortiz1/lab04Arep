package org.myorg.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class LogService {

    public static void main(String[] args) {
        port(getPort());
        get("/consume/:name", ((request, response) -> {
            response.type("application/json");
            return mongoLog(request.params(":name"));
        }));
    }

    public static Object mongoLog(String name) {
        MongoClient mongoClient = MongoClients.create(getMongoUri());
        MongoDatabase database = mongoClient.getDatabase("myMongoDb");

        if (!database.listCollectionNames().into(new ArrayList<>()).contains("users")) {
            database.createCollection("users");
        }

        MongoCollection<Document> collection = database.getCollection("users");
        Document user = new Document();
        user.put("name", name);
        user.put("created_at", LocalDateTime.now());
        collection.insertOne(user);

        List<Document> users = collection.find().sort(Sorts.descending("_id"))
                .limit(10)
                .into(new ArrayList<>());


        return users.stream().map((Document us) -> "\"" + us.get("name").toString() + "\": \"" +
                        us.get("created_at").toString() + "\"")
                .toList().toString().replace("[", "{").replace("]", "}");
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static String getMongoUri() {
        if (System.getenv("MONGO_URI") != null) {
            return System.getenv("MONGO_URI");
        }
        return "mongodb://localhost:27017/myMongoDb";
    }
}
