package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.*;

public class BarChartSample extends Application {

	public static Map<Double, Integer> countData;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Bar Chart Sample");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc =
				new BarChart<>(xAxis,yAxis);
		bc.setTitle("");
		xAxis.setLabel("score");
		yAxis.setLabel("score count");

		Map<String, Integer> countDataString = new TreeMap<>();
		for (var k : countData.keySet()) {
			Integer value = countData.get(k);
			countDataString.put(k.toString(), value);
		}

		List<XYChart.Series> series = new ArrayList<>();
		countDataString.forEach((k, v) -> {
			XYChart.Series<Double, Integer> chart = new XYChart.Series<>();
			chart.setName(k);
			chart.getData().add(new XYChart.Data("", v));
			series.add(chart);
		});

		Scene scene  = new Scene(bc,800,600);
		series.forEach(s -> bc.getData().add(s));
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}