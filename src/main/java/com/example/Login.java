    package com.example;

    import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Alert;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.PasswordField;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.GridPane;
    import javafx.scene.layout.HBox;
    import javafx.scene.text.Font;
    import javafx.scene.text.FontWeight;
    import javafx.scene.text.Text;
    import javafx.scene.text.TextAlignment;
    import javafx.stage.Stage;

    public class Login extends Application {

    private String adminUsername = "login";
    private String adminPassword = "login";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Zakaryya");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(30);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Text sceneTitle = new Text("Connexion");
        sceneTitle.setTextAlignment(TextAlignment.JUSTIFY);
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("Email:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField passwordBox = new PasswordField();
        grid.add(passwordBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(
        new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            String username = userTextField.getText().toString();
            String password = passwordBox.getText().toString();

            if (userTextField.getText().isEmpty()) {
                showAlert(
                Alert.AlertType.ERROR,
                "Form Error!",
                "Please enter your email id"
                );
                return;
            }
            if (passwordBox.getText().isEmpty()) {
                showAlert(
                Alert.AlertType.ERROR,
                "Form Error!",
                "Please enter a password"
                );
                return;
            }

            if (
                adminUsername.equals(username) && adminPassword.equals(password)
            ) {
                infoBox(Alert.AlertType.CONFIRMATION,"Connexion réussie!", null, "Success");
            } else {
                infoBox(Alert.AlertType.CONFIRMATION,"Veuillez entrer un bon email et mot de passe", null, "Failed");
            }
            }
        }
        );
        

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();

         // CSS 
        scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());

       
    }

    private static void showAlert(
        Alert.AlertType alertType,
        String title,
        String message
    ) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public static void infoBox(
        Alert.AlertType alertType,
        String infoMessage,
        String headerText,
        String title
    ) {
        Alert alert = new Alert(alertType);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    }
