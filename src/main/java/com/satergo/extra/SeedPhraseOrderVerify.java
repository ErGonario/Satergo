package com.satergo.extra;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class SeedPhraseOrderVerify extends TilePane {

	private static final int COL_PER_ROW = 5;

	public final ArrayList<String> userOrder = new ArrayList<>();

	public SeedPhraseOrderVerify(String[] words) {
		getStyleClass().add("seed-phrase-tiles");
		ArrayList<String> shuffled = new ArrayList<>(List.of(words));
		Collections.shuffle(shuffled);
		int col = 0, row = 0;
		for (String word : shuffled) {
			ToggleButton button = new ToggleButton(word);
			button.getStyleClass().add("seed-phrase-word");
			button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			button.selectedProperty().addListener((observable, oldValue, newValue) -> {
				if (newValue) {
					userOrder.add(word);
					onWordAdded.accept(word);
				} else {
					userOrder.remove(word);
					onWordRemoved.accept(word);
				}
				allSelected.set(words.length == userOrder.size());
				correct.set(Arrays.asList(words).equals(userOrder));
			});
			getChildren().add(button);
		}
		setPrefColumns(COL_PER_ROW);
		addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			int index = getChildren().indexOf((ToggleButton) e.getTarget());
			switch (e.getCode()) {
				case UP -> { if (index >= COL_PER_ROW) getChildren().get(index - COL_PER_ROW).requestFocus(); }
				case LEFT -> { if (index > 0) getChildren().get(index - 1).requestFocus(); }
				case DOWN -> { if (index < words.length - COL_PER_ROW) getChildren().get(index + COL_PER_ROW).requestFocus(); }
				case RIGHT -> { if (index < words.length - 1) getChildren().get(index + 1).requestFocus(); }
			}
		});
	}

	public Consumer<String> onWordAdded = w -> {}, onWordRemoved = w -> {};

	private final SimpleBooleanProperty allSelected = new SimpleBooleanProperty(false);
	private final SimpleBooleanProperty correct = new SimpleBooleanProperty(false);

	public SimpleBooleanProperty allSelectedProperty() {
		return allSelected;
	}

	public SimpleBooleanProperty correctProperty() {
		return correct;
	}

	public boolean isCorrect() {
		return correct.get();
	}
}
