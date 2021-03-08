package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("лэйбл, метка");

        // обычный лэйбл, метка
        Label label = new Label();
        label.setText("Text One (1) / обычный лэйбл, метка");

        // с картинкой
        Image image = new Image(getClass().getResourceAsStream("enot.jpeg")); // подгрузка картинки
        ImageView img = new ImageView(image);
        img.setFitHeight(200); //размеры
        img.setFitWidth(200);

        // подпись картинки
        Label labelImg = new Label();
        labelImg.setGraphic(img);
        labelImg.setTranslateX(75); //место расположения форме
        labelImg.setTranslateY(75);

        labelImg.setText("Text two (2) / с картинкой"); // сам текст метки
        labelImg.setGraphicTextGap(20); // отступ от картинки
        labelImg.setContentDisplay(ContentDisplay.TOP); // что бы картинка была сверху

        // активная метка
        Label labelActive = new Label();
        labelActive.setText("Text three (3) / активная метка");
        labelActive.setTranslateX(80);
        labelActive.setTranslateY(340);

        labelActive.setOnMouseEntered(event ->{ // при наведении
            labelActive.setScaleX(1.5); // размеры
            labelActive.setScaleX(1.5);
            labelActive.setTextFill(Color.RED);
        });

        labelActive.setOnMouseExited(event ->{ // если убрать мышку
            labelActive.setScaleX(1);
            labelActive.setScaleX(1);
            labelActive.setTextFill(Color.BLACK);
        });


        // добавление на сцены на форму
        Pane root = new Pane(); // Основное
        root.getChildren().addAll(label, labelImg, labelActive);
        primaryStage.setScene(new Scene(root, 400, 400));  // размер формы и сцена
        primaryStage.show(); // отобразить
    }

    public static void main(String[] args) {
        launch(args);
    }
}