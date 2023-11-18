import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

public class LoginPageAndHomePage extends Application {

    private Stage primaryStage;
    private Scene loginScene;
    private Scene homeScene;
    private TextField usernameField;
    private PasswordField passwordField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Login Page");

        // Login Page
        usernameField = new TextField();
        passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button signUpButton = new Button("Sign Up");

        VBox loginLayout = new VBox(10);

        loginLayout.setPadding(new Insets(10));
        loginLayout.getChildren().addAll(usernameField, passwordField, loginButton, signUpButton);
        loginScene = new Scene(loginLayout, 300, 200);

        Label countdownLabel = new Label();
        Button startConcentrationButton = new Button("Concentrate");
        Button disableImmediatelyButton = new Button("Disable Immediately");

        VBox concentrateModeLayout = new VBox(10);
        concentrateModeLayout.setPadding(new Insets(10));
        concentrateModeLayout.getChildren().addAll(countdownLabel, startConcentrationButton, disableImmediatelyButton);
        concentrateModeScene = new Scene(concentrateModeLayout, 300, 200);
        // Home Page
        ImageView profilePicture = new ImageView(new Image("profile_picture.jpg"));
        profilePicture.setFitWidth(100);
        profilePicture.setFitHeight(100);
        ProgressBar creditsProgressBar = new ProgressBar();
        Button addTaskButton = new Button("Add Task");
        Button editTaskButton = new Button("Edit Task");
        Button updateStatusButton = new Button("Update Status");
        Button addFriendButton = new Button("Add Friend");
        Button editFriendButton = new Button("Edit Friend");
        Button challengeFriendButton = new Button("Challenge Friend");
        Button completedTasksButton = new Button("Completed Tasks");
        Button concentrationModeButton = new Button("Concentration Mode");

        VBox profileBox = new VBox(10);
        profileBox.setPadding(new Insets(10));
        profileBox.getChildren().addAll(profilePicture, usernameField);

        HBox buttonsBox = new HBox(10);
        buttonsBox.setPadding(new Insets(10));
        buttonsBox.getChildren().addAll(addTaskButton, editTaskButton, updateStatusButton,
                addFriendButton, editFriendButton, challengeFriendButton,
                completedTasksButton, concentrationModeButton);

        VBox homeLayout = new VBox(10);
        homeLayout.setPadding(new Insets(10));
        homeLayout.getChildren().addAll(profileBox, creditsProgressBar, buttonsBox);
        homeScene = new Scene(homeLayout, 600, 400);

        loginButton.setOnAction(e -> handleLoginButton());
        signUpButton.setOnAction(e -> handleSignUpButton());

        startConcentrationButton.setOnAction(e -> startConcentrationMode());
        disableImmediatelyButton.setOnAction(e -> disableConcentrationMode());

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void handleLoginButton() {
        // Replace this with your actual authentication logic
        boolean isAuthenticated = authenticate(usernameField.getText(), passwordField.getText());

        if (isAuthenticated) {
            primaryStage.setScene(homeScene); // Switch to the home page
        } else {
            // Display an error message or dialog for login failure
        }
    }

    private void handleSignUpButton() {
        // Implement your sign-up logic here
        // You can open a sign-up window or navigate to a sign-up page
    }

    // Replace this with your actual authentication logic
    private boolean authenticate(String username, String password) {
        // For demonstration purposes, always allow login.
        return true;
    }

    private void startConcentrationMode() {
        // Display the Concentrate Mode scene
        primaryStage.setScene(concentrateModeScene);

        // Implement the concentration mode logic here
        // You can use a timer to update the countdownLabel dynamically
    }

    private void disableConcentrationMode() {
        // Implement logic to disable concentration mode immediately
        // Check for the actual password stored in the text file
        // Close the Concentrate Mode scene and switch back to the home page
        primaryStage.setScene(homeScene);
}
