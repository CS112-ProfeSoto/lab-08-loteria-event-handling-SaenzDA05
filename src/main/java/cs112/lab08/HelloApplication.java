package cs112.lab08;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;

public class HelloApplication extends Application {

    // Array of LoteriaCards to use for the game
    private final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matemáticas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9)
    };

    @Override
    public void start(Stage stage) {
        // GUI Components
        Label titleLabel = new Label("EChALE STEM Lotería");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        ImageView cardImageView = new ImageView();
        cardImageView.setFitWidth(200);
        cardImageView.setPreserveRatio(true);

        Label messageLabel = new Label("¡Presiona el botón para comenzar!");
        Button drawCardButton = new Button("Draw Random Card");

        // Progress bar (optional, for later)
        ProgressBar gameProgressBar = new ProgressBar(0);

        // Layout
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, cardImageView, messageLabel, drawCardButton, gameProgressBar);

        // Event Handling: Show a random card when button is clicked
        drawCardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index = (int) (Math.random() * LOTERIA_CARDS.length);
                LoteriaCard card = LOTERIA_CARDS[index];

                cardImageView.setImage(card.getImage());
                messageLabel.setText("Has sacado: " + card.getCardName());
            }
        });

        // Scene and Stage
        Scene scene = new Scene(layout, 350, 500);
        stage.setScene(scene);
        stage.setTitle("EChALE STEM Lotería");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}