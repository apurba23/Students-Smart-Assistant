/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import controller.DateParse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.batch_status;
import model.trainer_details;
import model.university_details;
import views.StudentModel;

/**
 *
 * @author Sk Faisal
 */
public class FireBase {
    Firestore db;
    public FireBase() {
        
FileInputStream serviceAccount =
        null;
        try {
             serviceAccount = new FileInputStream("studentperformancereport-firebase-adminsdk-bjz0n-975a6afbae.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        boolean hasBeenInitialized=false;
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
        FirebaseOptions options;
        for(FirebaseApp app : firebaseApps){
    if(app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)){
        hasBeenInitialized=true;
     //   finestayApp = app;
    }
}
        if(hasBeenInitialized!=true){
     options    = new FirebaseOptions.Builder()
                .setCredentials(credentials)
             .setDatabaseUrl("https://studentperformancereport.firebaseio.com")
                .build();
     
        FirebaseApp.initializeApp(options);
        }
        db = FirestoreClient.getFirestore();
        System.out.println("Connection Established!!");
           // serviceAccount = new FileInputStream("quizappserver-b8919-firebase-adminsdk-5ktll-c110ef08fb.json");
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setDatabaseUrl("https://quizappserver-b8919.firebaseio.com")
//                    .build(); FirebaseApp.initializeApp(options);
//                    System.out.println("Connection Established!");
//                    db=FirestoreClient.getFirestore();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                serviceAccount.close();
            } catch (IOException ex) {
                Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
   public boolean login(String username,String password)
   {
       
            boolean flag=false;
           
        try {
            
            ApiFuture<QuerySnapshot> future=  db.collection("user_manage").whereEqualTo("email", username).get();
            List<QueryDocumentSnapshot> docs=future.get().getDocuments();
            if(docs.size()==0)
                return false;
            QueryDocumentSnapshot doc=docs.get(0);
            
            if(doc.get("email").equals(username)&&doc.get("access").equals("special")&&password.equals("lict123456"))
            {
                flag=true;
              //  db.close();
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
   }
    public void insertData(String tablename,Map<String,String> data)
    {
        
        try {
            ApiFuture<DocumentReference> future=  db.collection(tablename).add(data);
            System.out.println("Id : " + future.get().getId());
        } catch (InterruptedException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
    public List<StudentModel> getAllData(){
        List<StudentModel> slist=new ArrayList<>();
         try {
            ApiFuture<QuerySnapshot> future=  db.collection("tbl_student").get();
          List<QueryDocumentSnapshot> doclist= future.get().getDocuments();
          for(QueryDocumentSnapshot doc:doclist)
          {
              StudentModel b=doc.toObject(StudentModel.class);
             // b.setId(doc.getId());
              slist.add(b);
          }
        } catch (InterruptedException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        }
         return slist;
        
    }
            
     public void insertSingleData(String tablename,Map<String,String> data)
    {
        
        try {
            ApiFuture<DocumentReference> future=  db.collection(tablename).add(data);
            //System.out.println("Update time : " + future.get().);
            
        } catch (Exception ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
     public void updateChild(String tablename,Map<String,String> data,String id,String childname)
     {
         try {
            ApiFuture<DocumentReference> future=  db.collection(tablename).document(id).collection(childname).add(data);
            //System.out.println("Update time : " + future.get().);
            
        } catch (Exception ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        }   
     }
    public void updateData(String tablename,Map<String,String> data,String id)
    {
        
        try {
            ApiFuture<WriteResult> future=  db.collection(tablename).document(id).set(data);
            //System.out.println("Update time : " + future.get().);
            
        } catch (Exception ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    public List<batch_status> getBatch()
    {
        List<batch_status> blist=new ArrayList<>();
         try {
            ApiFuture<QuerySnapshot> future=  db.collection("batch_status").get();
          List<QueryDocumentSnapshot> doclist= future.get().getDocuments();
          for(QueryDocumentSnapshot doc:doclist)
          {
              batch_status b=doc.toObject(batch_status.class);
              b.setId(doc.getId());
              blist.add(b);
          }
        } catch (InterruptedException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        }
         return blist;
    }
    public void deleteData(String tableName,String id)
    {
        try{
            
             ApiFuture<WriteResult> future=  db.collection(tableName).document(id).delete();
            }
            
            
        catch(Exception e)
        {
            System.out.println("Delete Error: "+e);
        }
    }
    public DocumentSnapshot getSingleData(String tablename,String docname)
    {
        ApiFuture<DocumentSnapshot> future=  db.collection(tablename).document(docname).get();
        DocumentSnapshot docref=null;
        try {
             docref=future.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docref;
    }
    public String dateTransform(String dateString,String inputformat,String outputformat)
{
    String outString="";
        try {
            Date date=new SimpleDateFormat(inputformat).parse(dateString);
            outString=new SimpleDateFormat(outputformat).format(date);
            
           // System.out.println("***** "+outString);
        } catch (ParseException ex) {
            Logger.getLogger(DateParse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return outString;
}
     public List<QueryDocumentSnapshot> getData(String tablename)
    {
        List<QueryDocumentSnapshot> blist=new ArrayList<>();
         try {
            ApiFuture<QuerySnapshot> future=  db.collection(tablename).get();
          List<QueryDocumentSnapshot> doclist= future.get().getDocuments();
          blist=doclist;
        } catch (InterruptedException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(FireBase.class.getName()).log(Level.SEVERE, null, ex);
        }
         return blist;
    }
    
   
    
}
