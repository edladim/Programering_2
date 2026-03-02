package src.main.edu.ntnu.idi.idatt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CardGameApp extends Application {

  private final DeckOfCards deck = new DeckOfCards();
  private HandOfCards currentHand;

  @Override
  public void start(Stage stage) {

    // Kort-område
    TextArea cardDisplay = new TextArea();
    cardDisplay.setEditable(false);
    cardDisplay.setPrefSize(400, 250);

    // Knapper
    Button dealButton = new Button("Deal hand");
    Button checkButton = new Button("Check hand");

    VBox buttonBox = new VBox(20, dealButton, checkButton);
    buttonBox.setPadding(new Insets(20));

    // Øvre layout
    HBox topSection = new HBox(40, cardDisplay, buttonBox);
    topSection.setPadding(new Insets(20));

    //Resultatfelt
    TextField sumField = new TextField();
    sumField.setEditable(false);

    TextField heartsField = new TextField();
    heartsField.setEditable(false);

    TextField flushField = new TextField();
    flushField.setEditable(false);

    TextField queenField = new TextField();
    queenField.setEditable(false);

    HBox row1 = new HBox(10,
        new Label("Sum of the faces:"), sumField,
        new Label("Cards of hearts:"), heartsField
    );

    HBox row2 = new HBox(20,
        new Label("Flush:"), flushField,
        new Label("Queen of spades:"), queenField
    );

    VBox bottomSection = new VBox(15, row1, row2);
    bottomSection.setPadding(new Insets(20));

    // Hovedlayout
    VBox root = new VBox(10, topSection, bottomSection);

    // Button logic
    dealButton.setOnAction(e -> {
      currentHand = deck.dealHand(5);
      cardDisplay.setText(currentHand.toString());

      // nullstill resultater
      sumField.clear();
      heartsField.clear();
      flushField.clear();
      queenField.clear();
    });

    checkButton.setOnAction(e -> {
      if (currentHand != null) {

        sumField.setText(String.valueOf(currentHand.sumOfCards()));
        heartsField.setText(currentHand.getHeartsAsString());
        flushField.setText(currentHand.isFlush() ? "Yes" : "No");
        queenField.setText(currentHand.hasQueenOfSpades() ? "Yes" : "No");
      }
    });

    Scene scene = new Scene(root, 750, 500);

    stage.setTitle("Card Game");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}