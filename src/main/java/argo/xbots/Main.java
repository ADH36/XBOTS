package argo.xbots;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fancy JavaFX UI");

        Button clickButton = new Button("Click Me!");
        Label messageLabel = new Label("Hello, this is a fancy JavaFX UI!");

        // Style the button with CSS for a more modern look
        clickButton.setStyle(
                "-fx-background-color: #4CAF50; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px;"
        );

        clickButton.setOnAction(e -> showMessage());

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(messageLabel, clickButton);

        StackPane root = new StackPane();
        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showMessage() {
        AlertBox.display("Button Clicked", "The button was clicked!");
    }

    public static class AlertBox {
        public static void display(String title, String message) {
            Stage window = new Stage();

            window.setTitle(title);
            window.setWidth(300);

            Label label = new Label(message);

            Button closeButton = new Button("OK");
            closeButton.setOnAction(e -> window.close());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, closeButton);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            window.setScene(scene);

            window.showAndWait();
        }
    }
}
