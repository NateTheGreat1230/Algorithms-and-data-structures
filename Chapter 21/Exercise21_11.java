import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
    private Map<String, Integer>[] mapForBoy = new HashMap[10];
    private Map<String, Integer>[] mapForGirl = new HashMap[10];

    private Button btFindRanking = new Button("Find Ranking");
    private ComboBox<Integer> cboYear = new ComboBox<>();
    private ComboBox<String> cboGender = new ComboBox<>();
    private TextField tfName = new TextField();
    private Label lblResult = new Label();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws IOException {
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Select a year:"), 0, 0);
        gridPane.add(new Label("Boy or girl?"), 0, 1);
        gridPane.add(new Label("Enter a name:"), 0, 2);
        gridPane.add(cboYear, 1, 0);
        gridPane.add(cboGender, 1, 1);
        gridPane.add(tfName, 1, 2);
        gridPane.add(btFindRanking, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(lblResult);
        BorderPane.setAlignment(lblResult, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 370, 160);
        primaryStage.setTitle("Exercise21_11"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        for (int year = 2001; year <= 2010; year++) {
            cboYear.getItems().add(year);
        }
        cboYear.setValue(2001);

        cboGender.getItems().addAll("Male", "Female");
        cboGender.setValue("Male");


        for(int i = 1; i <= 10; i++){
            URL file = null;
            if (i < 10) {
                file = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking200"+i+".txt");
            } else if (i == 10) {
                file = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking20"+i+".txt");
            }
            Scanner sc = new Scanner(file.openStream());
            mapForBoy[i-1] = new HashMap<>();
            mapForGirl[i-1] = new HashMap<>();
            while (sc.hasNext()) {
                int rank = sc.nextInt();
                String boy = sc.next();
                sc.nextInt();
                String girl = sc.next();
                sc.nextInt();
                mapForBoy[i-1].put(boy, rank);
                mapForGirl[i-1].put(girl, rank);
            }
        }

        btFindRanking.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblResult.setText(Search());
            }
        });
    }
    public String Search() {
        int parseYear = cboYear.getValue()-2000;
        System.out.println(parseYear);
        if (cboGender.getValue().equals("Male")) {
            return ("Boy name " + tfName.getText() + " is ranked #" + mapForBoy[parseYear-1].get(tfName.getText()) + " in year " + cboYear.getValue());
        } else if (cboGender.getValue().equals("Female")) {
            return ("Girl name " + tfName.getText() + " is ranked #" + mapForGirl[parseYear-1].get(tfName.getText()) + " in year " + cboYear.getValue());
        }
        return ("");
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}