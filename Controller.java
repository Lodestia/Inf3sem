package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import static java.lang.Math.*;
import static javafx.scene.paint.Color.color;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private ComboBox value;

    @FXML
    private AnchorPane parent;

    @FXML
    private TextField startX;

    @FXML
    private TextField startY;

    @FXML
    private TextField endX;

    @FXML
    private TextField endY;

    @FXML
    void click() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        Canvas canvas = new Canvas(300, 300); // создаем новый объект Canvas с шириной 300px, и высотой 300px
        parent.getChildren().add(canvas); // добавляем его в корневой контейнер
        GraphicsContext context = canvas.getGraphicsContext2D(); // и получаем GraphicContext

        if (value.getValue().equals("Овал")) {
            context.setFill(color(r, g, b, 0.5)); // устанавливаем цвет
            context.fillOval(random() * 100, random() * 100, random() * 100, random() * 100);
        } else if (value.getValue().equals("Овал незакрашенный")) {
            context.setStroke(color(r, g, b, 0.5)); // устанавливаем цвет
            context.strokeOval(Math.random() * 100, Math.random() * 100, Math.random() * 200, Math.random() * 200);
        } else if (value.getValue().equals("Прямоугольник")) {
            context.setFill(color(r, g, b, 0.5)); // устанавливаем цвет
            context.fillRect(Math.random() * 100, Math.random() * 100, Math.random() * 200, Math.random() * 200);
        } else if (value.getValue().equals("Прямоугольник незакрашенный")) {
            context.setStroke(color(r, g, b, 0.5)); // устанавливаем цвет
            context.strokeRect(Math.random() * 100, Math.random() * 100, Math.random() * 200, Math.random() * 200);
        } else if (value.getValue().equals("Треугольник")) {
            context.setFill(color(r, g, b, 0.5));
            context.fillPolygon(
                    new double[]{Math.random() * 100, Math.random() * 100, Math.random() * 100}, // X координаты вершин
                    new double[]{Math.random() * 100, Math.random() * 100, Math.random() * 100}, // Y координаты вершин
                    3 // количество вершин
            );
        } else if (value.getValue().equals("Треугольник незакрашенный")) {
            context.setStroke(color(r, g, b, 0.5));
            context.strokePolygon(
                    new double[]{Math.random() * 100, Math.random() * 100, Math.random() * 100}, // X координаты вершин
                    new double[]{Math.random() * 100, Math.random() * 100, Math.random() * 100}, // Y координаты вершин
                    3 // количество вершин
            );
        } else if (value.getValue().equals("Линия")) {
            context.setStroke(color(r, g, b, 0.5)); // устанавливаем цвет
            context.strokeLine(Math.random() * 200, Math.random() * 100, Math.random() * 100, Math.random() * 100); // рисуем прямоугльник 60x90px с левым верним углом в точке (200; 50)
        }
    }

}
