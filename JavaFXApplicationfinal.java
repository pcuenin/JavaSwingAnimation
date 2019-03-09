/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationfinal;


 

import javafx.scene.paint.Color;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author paul.cuenin
 */
public class JavaFXApplicationfinal extends Application {

    /**
     * @param args the command line arguments
     */
    ArrayList<Dance> persons;
    int ptr;
    Button next;
    Dance P;
    ImageView imageView;
        
        TextField danceName = null;
        
         ChoiceBox firstmv = new ChoiceBox(FXCollections.observableArrayList("null","Bounce", "Flip", "Slide","Shuffle", "Worm"));
         ChoiceBox secondmv = new ChoiceBox(FXCollections.observableArrayList("null","Bounce", "Flip", "Slide","Shuffle", "Worm"));
        ChoiceBox thirdmv = new ChoiceBox(FXCollections.observableArrayList("null","Bounce", "Flip", "Slide","Shuffle", "Worm"));
        ChoiceBox fourthmv = new ChoiceBox(FXCollections.observableArrayList("null","Bounce", "Flip", "Slide","Shuffle", "Worm"));
         ChoiceBox fifthmv = new ChoiceBox(FXCollections.observableArrayList("null","Bounce", "Flip", "Slide","Shuffle", "Worm"));
        
         
        
        Button prev;
    public static void main(String[] args) {
        launch(args);
        
        
        
     
    }
    
    @Override
    public void start(Stage primaryStage) {

         
                // declare buttons and text feilds here
       try
           {
               persons= readFile("data.dat");
           }
       catch(java.io.IOException e){e.printStackTrace();}
       ptr =0;
       Dance P = persons.get(0);
        
        
        
        
        
        primaryStage.setTitle("CIS 231 Final Project");
        
        next = new Button("next");
        
        next.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                enable DoTheDance;
                ptr++;
                Dance P = persons.get(ptr);
                danceName.setText(P.name);
                firstmv.setValue(P.first);
                secondmv.setValue(P.second);
                thirdmv.setValue(P.third);
                fourthmv.setValue(P.fourth);
                fifthmv.setValue(P.fifth);//resets text in blank
                prev.setDisable(false);//enable previous
                //firstblk.isEditable();secondmv.isEditable();thirdmv.isEditable();fourthmv.isEditable();fifthmv.isEditable();
                if(ptr==persons.size()-1)//disable next if ptr ==size-1
                    next.setDisable(true);
                
                System.out.println("Next");
            }
        });
        
        prev = new Button("Previous");
        prev.setDisable(true);
        
        prev.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                enable DoTheDance;
                ptr--;
                Dance P = persons.get(ptr);
                danceName.setText(P.name);
                firstmv.setValue(P.first);
                secondmv.setValue(P.second);
                thirdmv.setValue(P.third);
                fourthmv.setValue(P.fourth);
                fifthmv.setValue(P.fifth);//resets text in blank
                
                next.setDisable(false);//enable previous
                if(ptr==0)//disable next if ptr ==size-1
                    prev.setDisable(true);
                System.out.println("Previous");
            }
        });
        
        Button ins = new Button("Save");
        
        ins.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    //                enable DoTheDance;
                     Dance P = persons.get(ptr);
                    
                    
                    P.name= danceName.getText();
                    P.first=(String) firstmv.getValue();
                    P.second=(String) secondmv.getValue();
                    P.third=(String) thirdmv.getValue();
                    P.fourth=(String) fourthmv.getValue();
                    P.fifth=(String) fifthmv.getValue();
                    
                    
                    
                    
                    
                    
                    saveFile();
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaFXApplicationfinal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("Save");
            }
        });
        
        Button del = new Button("Delete");
        
        del.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                enable DoTheDance;
                Dance P = persons.get(ptr);
                    danceName.setText("blank");
                    P.name="null";
                    firstmv.setValue("null");
                    P.first="null";
                    secondmv.setValue("null");
                    P.second="null";
                    thirdmv.setValue("null");
                    P.third="null";
                    fourthmv.setValue("null");
                    P.fourth="null";
                    fifthmv.setValue("null");
                    P.fifth="null";
                    //firstblk.isEditable();secondmv.isEditable();thirdmv.isEditable();fourthmv.isEditable();fifthmv.isEditable();
                try {
                    saveFile();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaFXApplicationfinal.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Delete");
            }
        });
        
        Button exit = new Button("Exit");
        
        exit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                enable DoTheDance;
                System.out.println("Exit");
                System.exit(1);
            }
        });
        
        Button dance = new Button("Dance");
        
        dance.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    saveFile();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaFXApplicationfinal.class.getName()).log(Level.SEVERE, null, ex);
                }
                  DoTheDance(ptr);
                System.out.println("Dance");
                //need to fix
//                doTheDance(persons.get(ptr));
            }
        });
        
        
        
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        
        
        // First Name in column 1, row 1
        Text dName = new Text("Dance Name");
        dName.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(dName, 0, 0); 
        

        
        danceName = new TextField(P.name);
        
        firstmv.setValue(P.first);
        secondmv.setValue(P.second);
        thirdmv.setValue(P.third);
        fourthmv.setValue(P.fourth);
        fifthmv.setValue(P.fifth);
                
        grid.add(danceName, 1, 0); 
        
        
        Text first = new Text("Move 1");
        first.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(first, 0, 1); 
        

        
        
        
        grid.add(firstmv, 1, 1); 
        
        
        // Last Name in column 1, row 2
        Text last = new Text("Move 2");
        last.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(last, 0, 2); 
        
//        secondmv = new TextField(P.lastName);
        
        grid.add(secondmv, 1, 2); 
        
         // Address in column 1, row 3
        Text addy = new Text("Move 3");
        addy.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(addy, 0, 3); 
        
//        thirdmv = new TextField(P.address);
        
        grid.add(thirdmv, 1, 3);
        
         // Age in column 1, row 4
        Text age = new Text("Move 4");
        age.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(age, 0, 4); 
        
//        fourthmv= new TextField(String.valueOf(P.age));
        
        grid.add(fourthmv, 1, 4);
        
        // Salary in column 1, row 5
        Text sal = new Text("Move 5");
        sal.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(sal, 0, 5); 
        
//        fifthmv = new TextField(String.valueOf(P.salary));
        
        grid.add(fifthmv, 1, 5);
        grid.setStyle("-fx-background-color: DAE6F3;");
        
        
        
         
         
         Image image = new Image("http://fc00.deviantart.net/fs70/i/2012/290/8/0/gangnam_style_1_by_belu_cute-d5i4daz.png", 350, 0, true, true);
         
         imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(100);
         imageView.setPreserveRatio(true);
         
         
         
         
        
        StackPane root = new StackPane();
        grid.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
        root.setMargin(imageView, new Insets(12,12,12,12));
        root.getChildren().add(imageView);
        
        
        
        
//        URL resource = getClass().getResource("put.mp3");
//        Media media = new Media(resource.toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.play();
//        
        
        
        
        BorderPane border = new BorderPane();
        HBox hbox = new HBox();
        hbox.getChildren().add(next);
        hbox.getChildren().add(prev);
        hbox.getChildren().add(ins);
        hbox.getChildren().add(del);
        hbox.getChildren().add(exit);
        hbox.getChildren().add(dance);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-background-color: DAE6F3;");
        border.setMargin(hbox, new Insets(30,30,30,30));
        border.setMargin(grid,new Insets(30,30,30,30));
        border.setBottom(hbox);
        border.setRight(grid);
        border.setCenter(root);
        
//        root.getChildren().add(border);
        primaryStage.setScene(new Scene(border, 900 , 700));
        
        primaryStage.show();
    }
    
   
    
    private ArrayList<Dance> readFile(String firstName) throws IOException {
	FileInputStream fis = new FileInputStream(new File(firstName));
 
        //Construct BufferedReader from InputStreamReader
       ArrayList<Dance> prs= new ArrayList();
                BufferedReader br = new BufferedReader(new InputStreamReader(fis)) ;
            String line = null;
            int n=0;
            while ((line = br.readLine()) != null) {
                
                System.out.println(line);
                String[] fields=line.split(",");
                
              
                Dance p1=new Dance(fields[0].trim(),fields[1].trim(),fields[2].trim(),fields[3].trim(), fields[4].trim(), fields[5].trim());
                prs.add(n, p1);
               
                n++;
                
               
            }
          return prs;  
   }
    void saveFile() throws FileNotFoundException {
    PrintWriter pw = new PrintWriter(new FileOutputStream("data.dat"));
   for(int i=0; i<persons.size(); i++){
       Dance p=persons.get(i);
       String sr=p.name+","+p.first+","+p.second+","+p.third+","+p.fourth+","+p.fifth; // fix this
               pw.println(sr);
   }
    pw.close();
}
    
    public void DoTheDance(int ptr) {
        
                Dance P = persons.get(ptr);
                String[] Moves={P.first,P.second,P.third,P.fourth,P.fifth};
                Path path = new Path();
                for(int i=0; i<Moves.length; i++){
                    
                    switch(Moves[i]){
                        case "Bounce":
                            path.getElements().add(new MoveTo(0, 0));
                            path.getElements().add(new LineTo(0,50));
                            path.getElements().add(new MoveTo(0, 0));
                            path.getElements().add(new LineTo(0,50));
                            break;
                        case "Flip":
                            path.getElements().add(new MoveTo(0,0));
                            path.getElements().add(new ArcTo(100.0,100.0,100.0,50.0,100.0,true,true));
                            break;
                        case "Slide":
                            path.getElements().add(new MoveTo(0, 0));
                            path.getElements().add(new HLineTo(300));
                            break;
                        case "Shuffle":
                            path.getElements().add(new MoveTo(0, 0));
                            path.getElements().add(new HLineTo(150));
                            path.getElements().add(new HLineTo(75));
                            path.getElements().add(new HLineTo(225));
                            path.getElements().add(new HLineTo(150));
                            path.getElements().add(new HLineTo(75));
                            path.getElements().add(new HLineTo(225));
                            path.getElements().add(new HLineTo(150));
                            path.getElements().add(new HLineTo(0));
                            break;
                        case "Worm":
                            path.getElements().add (new MoveTo (0, 50));
                             path.getElements().add (new CubicCurveTo (40, 10, 200, 240, 400, 50));
                             
                            break;
                        
                    }
                    
                    
                }
                
                
        
        
       
        

         
         PathTransition pathTransition = PathTransitionBuilder.create()
                .node(imageView)
                .path(path)
                .duration(Duration.millis(7500))
                .orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(3)
                .build();
        
         
        
        
        
        
        pathTransition.playFromStart();
    }
    
    
}
