package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Main extends Application implements EventHandler<ActionEvent> {
	public static LinkedList<Tawjihi> listGazaScientific = new LinkedList<Tawjihi>();
	public static LinkedList<Tawjihi> listGazaLiterary = new LinkedList<Tawjihi>();
	public static LinkedList<Tawjihi> listWestBankScientific = new LinkedList<Tawjihi>();
	public static LinkedList<Tawjihi> listWestBankLiterary = new LinkedList<Tawjihi>();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {

		// Read from files and store in LinkedLists
		// _________________________________________________________________________________________________________________________________//

		File f1 = new File("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\Gaza_2022.csv");
		File f2 = new File(
				"C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\WestBank_2022.csv");
		// _________________________________________________________________________________________________________________________________//

		if (f1.exists() == false) { // check if Gaza file is existed or not
			System.out.println("Error: File Gaza is not exist");
			System.exit(0);
		}

		if (f2.exists() == false) { // check if WestBank file is existed or not
			System.out.println("Error: File Gaza is not exist");
			System.exit(0);
		}
		// _________________________________________________________________________________________________________________________________//
		Scanner sc1 = new Scanner(f1);
		Scanner sc2 = new Scanner(f2);

		while (sc1.hasNextLine()) { // while no empty line in Gaza file
			String g = sc1.nextLine();
			String[] n = g.split(",");

			if (n[1].equalsIgnoreCase("Scientific")) {
				listGazaScientific
						.insertSorted(new Tawjihi(Integer.parseInt(n[0]), n[1].trim(), Double.parseDouble(n[2])));
			}

			else {
				listGazaLiterary
						.insertSorted(new Tawjihi(Integer.parseInt(n[0]), n[1].trim(), Double.parseDouble(n[2])));
			}
		}

		while (sc2.hasNextLine()) { // while no empty line in Gaza file
			String s = sc2.nextLine();
			String[] r = s.split(",");

			if (r[1].equalsIgnoreCase("Scientific")) {
				listWestBankScientific
						.insertSorted(new Tawjihi(Integer.parseInt(r[0]), r[1].trim(), Double.parseDouble(r[2])));
			}

			else {
				listWestBankLiterary
						.insertSorted(new Tawjihi(Integer.parseInt(r[0]), r[1].trim(), Double.parseDouble(r[2])));
			}
		}

		Application.launch(args);
	}
	// _________________________________________________________________________________________________________________________________//

//	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {

		// ############################################################## Buttons
		// ##############################################################

		Button insert = new Button("Insert a new student");
		Button delete = new Button("Delete a student");
		Button search = new Button("Search student");
		Button size = new Button("Size");
		Button mean = new Button("Average Mean");
		Button percentage = new Button("Amount and Percentage");
		Button mode = new Button("Average Mode");
		Button display = new Button("Display the top ten students");

		FileInputStream input1 = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\Morroco.GIF");
		Image image1 = new Image(input1);
		image1.getHeight();
		ImageView iv1 = new ImageView(image1);

		insert.setTextFill(Color.BLACK);
		delete.setTextFill(Color.BLACK);
		search.setTextFill(Color.BLACK);
		size.setTextFill(Color.BLACK);
		mean.setTextFill(Color.BLACK);
		percentage.setTextFill(Color.BLACK);
		mode.setTextFill(Color.BLACK);
		display.setTextFill(Color.BLACK);
		insert.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		delete.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		search.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		size.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		mean.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		percentage.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		mode.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		display.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));

		FileInputStream bobo = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\back.gif");
		Image image11 = new Image(bobo);
		image11.getHeight();
		ImageView iv11 = new ImageView(image11);
		iv11.setFitHeight(20);
		iv11.setFitWidth(20);

		VBox vb1 = new VBox(13);
		vb1.getChildren().addAll(insert, delete, search, size, mean, percentage, mode, display, iv1);
		vb1.setAlignment(Pos.CENTER);
		vb1.setStyle("-fx-background-color: gray");

		Scene firstScreen = new Scene(vb1, 800, 750);
		
		Label lolo = new Label("ملاحظة : تمّ وضع صور اللاعبين لأن البروجيكت انعمل و أنا بحضر كأس العالم");
		Label lolo1 = new Label("ملاحظة : تمّ وضع صور اللاعبين لأن البروجيكت انعمل و أنا بحضر كأس العالم");
		Label lolo2 = new Label("ملاحظة : تمّ وضع صور اللاعبين لأن البروجيكت انعمل و أنا بحضر كأس العالم");
		Label lolo3 = new Label("ملاحظة : تمّ وضع صور اللاعبين لأن البروجيكت انعمل و أنا بحضر كأس العالم");
		Label lolo4 = new Label("ملاحظة : تمّ وضع صور اللاعبين لأن البروجيكت انعمل و أنا بحضر كأس العالم");
		Label lolo5 = new Label("ملاحظة : تمّ وضع صور اللاعبين لأن البروجيكت انعمل و أنا بحضر كأس العالم");
		Label lolo6 = new Label("ملاحظة : تمّ وضع صور اللاعبين لأن البروجيكت انعمل و أنا بحضر كأس العالم");
		Label lolo7 = new Label("ملاحظة : تمّ وضع صور اللاعبين لأن البروجيكت انعمل و أنا بحضر كأس العالم");
		
		lolo.setTextFill(Color.WHITE);
		lolo.setFont(new Font(15));
		lolo1.setTextFill(Color.BLUE);
		lolo1.setFont(new Font(15));
		lolo2.setTextFill(Color.BLACK);
		lolo2.setFont(new Font(15));
		lolo3.setTextFill(Color.RED);
		lolo3.setFont(new Font(15));
		lolo4.setTextFill(Color.RED);
		lolo4.setFont(new Font(15));
		lolo5.setTextFill(Color.WHITE);
		lolo5.setFont(new Font(15));
		lolo6.setTextFill(Color.RED);
		lolo6.setFont(new Font(15));
		lolo7.setTextFill(Color.BLACK);
		lolo7.setFont(new Font(15));

		primaryStage.setTitle("First Project");
		primaryStage.setScene(firstScreen);
		primaryStage.show();
		// _________________________________________________________________________________________________________________________________//
		// ############################################################## insert a new
		// student ###############################################

		Label lb1 = new Label("The seat number:");
		lb1.setTextFill(Color.WHITE);
		TextField tf1 = new TextField();
		tf1.setPromptText("Enter seat number");
		HBox hb3 = new HBox(400);
		hb3.getChildren().addAll(lb1, tf1);

		RadioButton gs2 = new RadioButton("Gaza-Scientific-Branch");
		RadioButton gl2 = new RadioButton("Gaza-Literary-Branch");
		RadioButton ws2 = new RadioButton("WestBank-Scientific-Branch");
		RadioButton wl2 = new RadioButton("WestBank-Literary-Branch");
		ToggleGroup tg2 = new ToggleGroup();
		gs2.setTextFill(Color.WHITE);
		gl2.setTextFill(Color.WHITE);
		ws2.setTextFill(Color.WHITE);
		wl2.setTextFill(Color.WHITE);
		gs2.setToggleGroup(tg2);
		gl2.setToggleGroup(tg2);
		ws2.setToggleGroup(tg2);
		wl2.setToggleGroup(tg2);
		HBox hb4 = new HBox(25);
		hb4.getChildren().addAll(gs2, gl2, ws2, wl2);

		Label lb2 = new Label("The average:");
		lb2.setTextFill(Color.WHITE);
		TextField tf2 = new TextField();
		tf2.setPromptText("Enter student average");
		HBox hb5 = new HBox(425);
		hb5.getChildren().addAll(lb2, tf2);

		FileInputStream nono = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\insert.gif");
		Image image12 = new Image(nono);
		image12.getHeight();
		ImageView iv12 = new ImageView(image12);
		iv12.setFitHeight(20);
		iv12.setFitWidth(20);

		Button ins = new Button("Insert", iv12);
		Button back1 = new Button("Back", iv11);
		HBox hb6 = new HBox(18);
		hb6.getChildren().addAll(ins, back1);
		hb6.setAlignment(Pos.CENTER);

		ins.setTextFill(Color.BLACK);
		back1.setTextFill(Color.BLACK);
		ins.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		back1.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));

		TextArea tArea = new TextArea();
		tArea.setPrefSize(100, 100);

		FileInputStream input2 = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\Hakimi.gif");
		Image image2 = new Image(input2);
		image2.getHeight();
		ImageView iv2 = new ImageView(image2);

		VBox vb3 = new VBox(15);
		vb3.setAlignment(Pos.CENTER);
		vb3.setStyle("-fx-background-color: blue");
		vb3.getChildren().addAll(lolo, hb3, hb4, hb5, hb6, tArea, iv2);

		Scene scene2 = new Scene(vb3, 720, 750);

		ins.setOnAction(e -> {
			if (tf1.getText().isEmpty()) {
				tArea.setText("You must enter a seat number");
				return;
			}
			if (tf2.getText().isEmpty()) {
				tArea.setText("You must enter the student average");
				return;
			}

			if (gs2.isSelected()) {
				if (listGazaScientific.search(Integer.parseInt(tf1.getText())) == false
						&& listGazaLiterary.search(Integer.parseInt(tf1.getText())) == false
						&& listWestBankScientific.search(Integer.parseInt(tf1.getText())) == false
						&& listWestBankLiterary.search(Integer.parseInt(tf1.getText())) == false) {
					listGazaScientific.insertSorted(new Tawjihi(Integer.parseInt(tf1.getText()), "Scientific",
							Double.parseDouble(tf2.getText())));
					tArea.setText("The student has been inserted");
				} else {
					tArea.setText("Error: the student has been already inserted");
				}
			}

			else if (gl2.isSelected()) {
				if (listGazaScientific.search(Integer.parseInt(tf1.getText())) == false
						&& listGazaLiterary.search(Integer.parseInt(tf1.getText())) == false
						&& listWestBankScientific.search(Integer.parseInt(tf1.getText())) == false
						&& listWestBankLiterary.search(Integer.parseInt(tf1.getText())) == false) {
					listGazaLiterary.insertSorted(new Tawjihi(Integer.parseInt(tf1.getText()), "Literary",
							Double.parseDouble(tf2.getText())));
					tArea.setText("The student has been inserted");
				} else {
					tArea.setText("Error: the student has been already inserted");
				}
			}

			else if (ws2.isSelected()) {
				if (listGazaScientific.search(Integer.parseInt(tf1.getText())) == false
						&& listGazaLiterary.search(Integer.parseInt(tf1.getText())) == false
						&& listWestBankScientific.search(Integer.parseInt(tf1.getText())) == false
						&& listWestBankLiterary.search(Integer.parseInt(tf1.getText())) == false) {
					listWestBankScientific.insertSorted(new Tawjihi(Integer.parseInt(tf1.getText()), "Scientific",
							Double.parseDouble(tf2.getText())));
					tArea.setText("The student has been inserted");
				} else {
					tArea.setText("Error: the student has been already inserted");
				}
			}

			else {
				if (listGazaScientific.search(Integer.parseInt(tf1.getText())) == false
						&& listGazaLiterary.search(Integer.parseInt(tf1.getText())) == false
						&& listWestBankScientific.search(Integer.parseInt(tf1.getText())) == false
						&& listWestBankLiterary.search(Integer.parseInt(tf1.getText())) == false) {
					listWestBankLiterary.insertSorted(new Tawjihi(Integer.parseInt(tf1.getText()), "Literary",
							Double.parseDouble(tf2.getText())));
					tArea.setText("The student has been inserted");
				} else {
					tArea.setText("Error: the student has been already inserted");
				}
			}
		});

		back1.setOnAction(e -> {
			primaryStage.setScene(firstScreen);
		});

		// _________________________________________________________________________________________________________________________________//
		// ############################################################## delete a
		// student ###################################################

		RadioButton gs3 = new RadioButton("Gaza-Scientific-Branch");
		RadioButton gl3 = new RadioButton("Gaza-Literary-Branch");
		RadioButton ws3 = new RadioButton("WestBank-Scientific-Branch");
		RadioButton wl3 = new RadioButton("WestBank-Literary-Branch");
		ToggleGroup tg3 = new ToggleGroup();
		gs3.setTextFill(Color.BLUE);
		gl3.setTextFill(Color.BLUE);
		ws3.setTextFill(Color.BLUE);
		wl3.setTextFill(Color.BLUE);
		gs3.setToggleGroup(tg3);
		gl3.setToggleGroup(tg3);
		ws3.setToggleGroup(tg3);
		wl3.setToggleGroup(tg3);
		HBox hb7 = new HBox(25);
		hb7.getChildren().addAll(gs3, gl3, ws3, wl3);

		Label lb3 = new Label("The seat number:");
		lb3.setTextFill(Color.BLUE);
		TextField tf3 = new TextField();
		tf3.setPromptText("Enter seat number");
		HBox hb8 = new HBox(400);
		hb8.getChildren().addAll(lb3, tf3);

		FileInputStream dodo = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\delete.gif");
		Image image13 = new Image(dodo);
		image13.getHeight();
		ImageView iv13 = new ImageView(image13);
		iv13.setFitHeight(20);
		iv13.setFitWidth(20);

		Button delete1 = new Button("Delete", iv13);
		Button back2 = new Button("Back", iv11);
		HBox hb9 = new HBox(18);
		hb9.getChildren().addAll(delete1, back2);
		hb9.setAlignment(Pos.CENTER);

		delete1.setTextFill(Color.WHITE);
		back2.setTextFill(Color.WHITE);
		delete1.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(5), Insets.EMPTY)));
		back2.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(5), Insets.EMPTY)));

		TextArea t1 = new TextArea();
		t1.setPrefSize(100, 100);

		FileInputStream input3 = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\Pedri.gif");
		Image image3 = new Image(input3);
		image3.getHeight();
		ImageView iv3 = new ImageView(image3);

		VBox vb4 = new VBox(25);
		vb4.setAlignment(Pos.CENTER);
		vb4.setStyle("-fx-background-color: pink");
		vb4.getChildren().addAll(lolo1,hb7, hb8, hb9, t1, iv3);

		Scene scene3 = new Scene(vb4, 720, 720);

		delete1.setOnAction(e -> {

			if (tf3.getText().isEmpty()) {
				t1.setText("You must enter a seat number");
				return;

			} else {
				t1.setText("Thank u!!!");
				if (gs3.isSelected()) {
					if (listGazaScientific.search(Integer.parseInt(tf3.getText()))) {
						t1.setText("The student is found and deleted");
						listGazaScientific.deleteSeatNumber(Integer.parseInt(tf3.getText()));
					} else
						t1.setText("The student is not found");
				} else if (gl3.isSelected()) {
					if (listGazaLiterary.search(Integer.parseInt(tf3.getText()))) {
						t1.setText("The student is found and deleted");
						listGazaLiterary.deleteSeatNumber(Integer.parseInt(tf3.getText()));
					} else
						t1.setText("The student is not found");
				} else if (ws3.isSelected()) {
					if (listWestBankScientific.search(Integer.parseInt(tf3.getText()))) {
						t1.setText("The student is found and deleted");
						listWestBankScientific.deleteSeatNumber(Integer.parseInt(tf3.getText()));
					} else
						t1.setText("The student is not found");
				} else {
					if (listWestBankLiterary.search(Integer.parseInt(tf3.getText()))) {
						t1.setText("The student is found and deleted");
						listWestBankLiterary.deleteSeatNumber(Integer.parseInt(tf3.getText()));
					} else
						t1.setText("The student is not found");
				}
			}
		});

		back2.setOnAction(e -> {
			primaryStage.setScene(firstScreen);
		});
		// _________________________________________________________________________________________________________________________________//
		// ############################################################## search a
		// student ###################################################

		RadioButton gs4 = new RadioButton("Gaza-Scientific-Branch");
		RadioButton gl4 = new RadioButton("Gaza-Literary-Branch");
		RadioButton ws4 = new RadioButton("WestBank-Scientific-Branch");
		RadioButton wl4 = new RadioButton("WestBank-Literary-Branch");
		ToggleGroup tg4 = new ToggleGroup();
		gs4.setTextFill(Color.BLACK);
		gl4.setTextFill(Color.BLACK);
		ws4.setTextFill(Color.BLACK);
		wl4.setTextFill(Color.BLACK);
		gs4.setToggleGroup(tg4);
		gl4.setToggleGroup(tg4);
		ws4.setToggleGroup(tg4);
		wl4.setToggleGroup(tg4);
		HBox hb10 = new HBox(25);
		hb10.getChildren().addAll(gs4, gl4, ws4, wl4);

		Label lb4 = new Label("The seat number:");
		lb4.setTextFill(Color.BLACK);
		TextField tf4 = new TextField();
		tf4.setPromptText("Enter seat number");
		HBox hb11 = new HBox(400);
		hb11.getChildren().addAll(lb4, tf4);

		FileInputStream search2 = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\search.gif");
		Image image10 = new Image(search2);
		image10.getHeight();
		ImageView iv10 = new ImageView(image10);
		iv10.setFitHeight(20);
		iv10.setFitWidth(20);

		Button search1 = new Button("Search", iv10);
		Button back3 = new Button("Back", iv11);
		HBox hb12 = new HBox(18);
		hb12.getChildren().addAll(search1, back3);
		hb12.setAlignment(Pos.CENTER);

		search1.setTextFill(Color.BLACK);
		back3.setTextFill(Color.BLACK);
		search1.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		back3.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));

		TextArea t2 = new TextArea();
		t2.setPrefSize(100, 100);

		FileInputStream input4 = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\Lewandowski.gif");
		Image image4 = new Image(input4);
		image4.getHeight();
		ImageView iv4 = new ImageView(image4);

		VBox vb5 = new VBox(25);
		vb5.setAlignment(Pos.CENTER);
		vb5.setStyle("-fx-background-color: cadetblue");
		vb5.getChildren().addAll(lolo2,hb10, hb11, hb12, t2, iv4);

		Scene scene4 = new Scene(vb5, 720, 720);

		search1.setOnAction(e -> {
			if (tf4.getText().isEmpty()) {
				t2.setText("You must enter a seat number");
				return;
			} else {
				if (gs4.isSelected()) {
					if (listGazaScientific.search(Integer.parseInt(tf4.getText())))
						t2.setText("The student is found");
					else
						t2.setText("The student is not found");
				} else if (gl4.isSelected()) {
					if (listGazaLiterary.search(Integer.parseInt(tf4.getText())))
						t2.setText("The student is found");
					else
						t2.setText("The student is not found");
				} else if (ws4.isSelected()) {
					if (listWestBankScientific.search(Integer.parseInt(tf4.getText())))
						t2.setText("The student is found");
					else
						t2.setText("The student is not found");
				} else {
					if (listWestBankLiterary.search(Integer.parseInt(tf4.getText())))
						t2.setText("The student is found");
					else
						t2.setText("The student is not found");
				}
			}
		});

		back3.setOnAction(e -> {
			primaryStage.setScene(firstScreen);
		});
		// _________________________________________________________________________________________________________________________________//
		// ############################################################## Size
		// ###################################################

		RadioButton gs5 = new RadioButton("Gaza-Scientific-Branch");
		RadioButton gl5 = new RadioButton("Gaza-Literary-Branch");
		RadioButton ws5 = new RadioButton("WestBank-Scientific-Branch");
		RadioButton wl5 = new RadioButton("WestBank-Literary-Branch");
		ToggleGroup tg5 = new ToggleGroup();
		gs5.setTextFill(Color.RED);
		gl5.setTextFill(Color.RED);
		ws5.setTextFill(Color.RED);
		wl5.setTextFill(Color.RED);
		gs5.setToggleGroup(tg5);
		gl5.setToggleGroup(tg5);
		ws5.setToggleGroup(tg5);
		wl5.setToggleGroup(tg5);
		HBox hb13 = new HBox(25);
		hb13.getChildren().addAll(gs5, gl5, ws5, wl5);

		FileInputStream soso = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\count.gif");
		Image image14 = new Image(soso);
		image14.getHeight();
		ImageView iv14 = new ImageView(image14);
		iv14.setFitHeight(20);
		iv14.setFitWidth(20);

		Button size1 = new Button("Size", iv14);
		TextField tf55 = new TextField();
		tf55.setEditable(false);
		HBox hb14 = new HBox(400);
		hb14.getChildren().addAll(size1, tf55);

		Button back4 = new Button("Back", iv11);
		HBox hb15 = new HBox(18);
		hb15.getChildren().add(back4);
		hb15.setAlignment(Pos.CENTER);

		size1.setTextFill(Color.BLACK);
		back4.setTextFill(Color.BLACK);
		size1.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		back4.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));

		FileInputStream input5 = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\Messi.gif");
		Image image5 = new Image(input5);
		image5.getHeight();
		ImageView iv5 = new ImageView(image5);

		VBox vb6 = new VBox(30);
		vb6.setAlignment(Pos.CENTER);
		vb6.setStyle("-fx-background-color: black");
		vb6.getChildren().addAll(lolo3,hb13, hb14, hb15, iv5);

		Scene scene5 = new Scene(vb6, 720, 720);

		size1.setOnAction(e -> {
			if (gs5.isSelected()) {
				tf55.setText(String.valueOf(listGazaScientific.size()));
			} else if (gl5.isSelected()) {
				tf55.setText(String.valueOf(listGazaLiterary.size()));
			} else if (ws5.isSelected()) {
				tf55.setText(String.valueOf(listWestBankScientific.size()));
			} else {
				tf55.setText(String.valueOf(listWestBankLiterary.size()));
			}

		});

		back4.setOnAction(e -> {
			primaryStage.setScene(firstScreen);
		});

		// _________________________________________________________________________________________________________________________________//
		// ############################################################## Average mean
		// ###################################################

		RadioButton gs6 = new RadioButton("Gaza-Scientific-Branch");
		RadioButton gl6 = new RadioButton("Gaza-Literary-Branch");
		RadioButton ws6 = new RadioButton("WestBank-Scientific-Branch");
		RadioButton wl6 = new RadioButton("WestBank-Literary-Branch");
		ToggleGroup tg6 = new ToggleGroup();
		gs6.setTextFill(Color.RED);
		gl6.setTextFill(Color.RED);
		ws6.setTextFill(Color.RED);
		wl6.setTextFill(Color.RED);
		gs6.setToggleGroup(tg6);
		gl6.setToggleGroup(tg6);
		ws6.setToggleGroup(tg6);
		wl6.setToggleGroup(tg6);
		HBox hb16 = new HBox(25);
		hb16.getChildren().addAll(gs6, gl6, ws6, wl6);

		FileInputStream mono = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\calculate.gif");
		Image image15 = new Image(mono);
		image15.getHeight();
		ImageView iv15 = new ImageView(image15);
		iv15.setFitHeight(20);
		iv15.setFitWidth(20);

		Button mavg = new Button("Find Mean Average", iv15);
		TextField tf5 = new TextField();
		tf5.setEditable(false);
		HBox hb17 = new HBox(50);
		hb17.getChildren().addAll(mavg, tf5);

		Button back5 = new Button("Back", iv11);
		HBox hb18 = new HBox(18);
		hb18.getChildren().add(back5);
		hb18.setAlignment(Pos.CENTER);

		mavg.setTextFill(Color.BLACK);
		back5.setTextFill(Color.BLACK);
		mavg.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		back5.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));

		FileInputStream input6 = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\Ronaldo.gif");
		Image image6 = new Image(input6);
		image6.getHeight();
		ImageView iv6 = new ImageView(image6);

		VBox vb7 = new VBox(30);
		vb7.setAlignment(Pos.CENTER);
		vb7.setStyle("-fx-background-color: yellow");
		vb7.getChildren().addAll(lolo4,hb16, hb17, hb18, iv6);

		Scene scene6 = new Scene(vb7, 720, 720);

		mavg.setOnAction(e -> {
			if (gs6.isSelected()) {
				tf5.setText(String.valueOf(listGazaScientific.Mean()));
			} else if (gl6.isSelected()) {
				tf5.setText(String.valueOf(listGazaLiterary.Mean()));
			} else if (ws6.isSelected()) {
				tf5.setText(String.valueOf(listWestBankScientific.Mean()));
			} else {
				tf5.setText(String.valueOf(listWestBankLiterary.Mean()));
			}
		});

		back5.setOnAction(e -> {
			primaryStage.setScene(firstScreen);
		});

		// _________________________________________________________________________________________________________________________________//
		// ############################################################## Amount &
		// percentage ###################################################

		RadioButton gs7 = new RadioButton("Gaza-Scientific-Branch");
		RadioButton gl7 = new RadioButton("Gaza-Literary-Branch");
		RadioButton ws7 = new RadioButton("WestBank-Scientific-Branch");
		RadioButton wl7 = new RadioButton("WestBank-Literary-Branch");
		ToggleGroup tg7 = new ToggleGroup();
		gs7.setTextFill(Color.WHITE);
		gl7.setTextFill(Color.WHITE);
		ws7.setTextFill(Color.WHITE);
		wl7.setTextFill(Color.WHITE);
		gs7.setToggleGroup(tg7);
		gl7.setToggleGroup(tg7);
		ws7.setToggleGroup(tg7);
		wl7.setToggleGroup(tg7);
		HBox hb19 = new HBox(25);
		hb19.getChildren().addAll(gs7, gl7, ws7, wl7);

		Label lb6 = new Label("Enter an average:");
		lb6.setTextFill(Color.WHITE);
		TextField tf6 = new TextField();
		tf6.setPromptText("Enter student average");
		HBox hb20 = new HBox(390);
		hb20.getChildren().addAll(lb6, tf6);

		Label lb7 = new Label("The amount of students whom avg is above or equal:");
		lb7.setTextFill(Color.WHITE);
		TextField tf7 = new TextField();
		tf7.setEditable(false);
		HBox hb21 = new HBox(200);
		hb21.getChildren().addAll(lb7, tf7);

		Label lb8 = new Label("The percenatge of students whom avg is above or equal:");
		lb8.setTextFill(Color.WHITE);
		TextField tf8 = new TextField();
		tf8.setEditable(false);
		HBox hb22 = new HBox(182);
		hb22.getChildren().addAll(lb8, tf8);

		FileInputStream roro = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\show.gif");
		Image image16 = new Image(roro);
		image16.getHeight();
		ImageView iv16 = new ImageView(image16);
		iv16.setFitHeight(20);
		iv16.setFitWidth(20);

		Button show = new Button("show", iv16);
		Button back6 = new Button("Back", iv11);
		HBox hb23 = new HBox(18);
		hb23.getChildren().addAll(show, back6);
		hb23.setAlignment(Pos.CENTER);

		show.setTextFill(Color.WHITE);
		back6.setTextFill(Color.WHITE);
		show.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
		back6.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));

		TextField t3 = new TextField();

		FileInputStream input7 = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\Neymar.gif");
		Image image7 = new Image(input7);
		image7.getHeight();
		ImageView iv7 = new ImageView(image7);

		VBox vb8 = new VBox(15);
		vb8.setAlignment(Pos.CENTER);
		vb8.setStyle("-fx-background-color: brown");
		vb8.getChildren().addAll(lolo5,hb19, hb20, hb21, hb22, hb23, t3, iv7);

		Scene scene7 = new Scene(vb8, 870, 720);

		show.setOnAction(e -> {

			if (tf6.getText().isEmpty()) {
				t3.setText("You must enter an average");
				return;
			} else {
				t3.setText("Thank u!!!");
				if (gs7.isSelected()) {
					String[] r = listGazaScientific.Percentage(Double.parseDouble(tf6.getText())).split(",");
					tf7.setText(r[0]);
					tf8.setText(r[1]);

				} else if (gl7.isSelected()) {
					String[] r = listGazaLiterary.Percentage(Double.parseDouble(tf6.getText())).split(",");
					tf7.setText(r[0]);
					tf8.setText(r[1]);
				} else if (ws7.isSelected()) {
					String[] r = listWestBankScientific.Percentage(Double.parseDouble(tf6.getText())).split(",");
					tf7.setText(r[0]);
					tf8.setText(r[1]);
				} else {
					String[] r = listWestBankLiterary.Percentage(Double.parseDouble(tf6.getText())).split(",");
					tf7.setText(r[0]);
					tf8.setText(r[1]);
				}
			}
		});

		back6.setOnAction(e -> {
			primaryStage.setScene(firstScreen);
		});

		// _________________________________________________________________________________________________________________________________//
		// ############################################################## Average Mode
		// ###################################################

		RadioButton gs8 = new RadioButton("Gaza-Scientific-Branch");
		RadioButton gl8 = new RadioButton("Gaza-Literary-Branch");
		RadioButton ws8 = new RadioButton("WestBank-Scientific-Branch");
		RadioButton wl8 = new RadioButton("WestBank-Literary-Branch");
		ToggleGroup tg8 = new ToggleGroup();
		gs8.setTextFill(Color.RED);
		gl8.setTextFill(Color.RED);
		ws8.setTextFill(Color.RED);
		wl8.setTextFill(Color.RED);
		gs8.setToggleGroup(tg8);
		gl8.setToggleGroup(tg8);
		ws8.setToggleGroup(tg8);
		wl8.setToggleGroup(tg8);
		HBox hb24 = new HBox(25);
		hb24.getChildren().addAll(gs8, gl8, ws8, wl8);

		Label lb9 = new Label("The Mode Avg");
		lb9.setTextFill(Color.RED);
		TextField tf9 = new TextField();
		tf9.setEditable(false);
		HBox hb25 = new HBox(200);
		hb25.getChildren().addAll(lb9, tf9);

		Button showMode = new Button("Find Mode", iv15);
		Button back7 = new Button("Back", iv11);
		HBox hb26 = new HBox(18);
		hb26.getChildren().addAll(showMode, back7);
		hb26.setAlignment(Pos.CENTER);

		showMode.setTextFill(Color.BLACK);
		back7.setTextFill(Color.BLACK);
		showMode.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		back7.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));

		FileInputStream input8 = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\Salah.gif");
		Image image8 = new Image(input8);
		image8.getHeight();
		ImageView iv8 = new ImageView(image8);

		VBox vb9 = new VBox(30);
		vb9.setAlignment(Pos.CENTER);
		vb9.setStyle("-fx-background-color: yellow");
		vb9.getChildren().addAll(lolo6,hb24, hb25, hb26, iv8);

		Scene scene8 = new Scene(vb9, 720, 720);

		showMode.setOnAction(e -> {
			if (gs8.isSelected()) {
				tf9.setText(String.valueOf(listGazaScientific.Mode(listGazaScientific)));
			} else if (gl8.isSelected()) {
				tf9.setText(String.valueOf(listGazaLiterary.Mode(listGazaLiterary)));
			} else if (ws8.isSelected()) {
				tf9.setText(String.valueOf(listWestBankScientific.Mode(listWestBankScientific)));
			} else {
				tf9.setText(String.valueOf(listWestBankLiterary.Mode(listWestBankLiterary)));
			}
		});

		back7.setOnAction(e -> {
			primaryStage.setScene(firstScreen);
		});

		// _________________________________________________________________________________________________________________________________//
		// ############################################################## The top ten
		// #########################################################
		Label top = new Label("The top ten students in:");
		top.setTextFill(Color.BLACK);
		top.setFont(new Font(15));

		RadioButton gs1 = new RadioButton("Gaza-Scientific-Branch");
		RadioButton gl1 = new RadioButton("Gaza-Literary-Branch");
		RadioButton ws1 = new RadioButton("WestBank-Scientific-Branch");
		RadioButton wl1 = new RadioButton("WestBank-Literary-Branch");
		ToggleGroup tg1 = new ToggleGroup();
		gs1.setTextFill(Color.BLACK);
		gl1.setTextFill(Color.BLACK);
		ws1.setTextFill(Color.BLACK);
		wl1.setTextFill(Color.BLACK);
		gs1.setToggleGroup(tg1);
		gl1.setToggleGroup(tg1);
		ws1.setToggleGroup(tg1);
		wl1.setToggleGroup(tg1);

		HBox hb1 = new HBox(25);
		hb1.getChildren().addAll(gs1, gl1, ws1, wl1);

		Button dis = new Button("Display top 10", iv16);
		Button back8 = new Button("Back", iv11);

		dis.setTextFill(Color.BLACK);
		back8.setTextFill(Color.BLACK);
		dis.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
		back8.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));

		HBox hb2 = new HBox(18);
		hb2.getChildren().addAll(dis, back8);
		hb2.setAlignment(Pos.CENTER);

		TextArea ta = new TextArea();
		ta.setEditable(false);

		FileInputStream input9 = new FileInputStream("C:\Users\Owner's\Desktop\Studies\Data Structure\Projects\SingleLinkedListProject\\Modric.gif");
		Image image9 = new Image(input9);
		image9.getHeight();
		ImageView iv9 = new ImageView(image9);

		VBox vb2 = new VBox(20);
		vb2.setAlignment(Pos.CENTER);
		vb2.setStyle("-fx-background-color: gray");
		vb2.getChildren().addAll(lolo7,top, hb1, hb2, ta, iv9);

		dis.setOnAction(e -> {
			if (gs1.isSelected()) {
				ta.setText(listGazaScientific.topTen(listGazaScientific));
			} else if (gl1.isSelected()) {
				ta.setText(listGazaLiterary.topTen(listGazaLiterary));
			} else if (ws1.isSelected()) {
				ta.setText(listWestBankScientific.topTen(listWestBankScientific));
			} else {
				ta.setText(listWestBankLiterary.topTen(listWestBankLiterary));
			}
		});

		Scene scene9 = new Scene(vb2, 750, 800);

		back8.setOnAction(e -> {
			primaryStage.setScene(firstScreen);
		});

		// _________________________________________________________________________________________________________________________________//
		// ###################################################################################################################################

		insert.setOnAction(e -> {
			primaryStage.setTitle("Insert Student");
			primaryStage.setScene(scene2);
		});

		delete.setOnAction(e -> {
			primaryStage.setTitle("Delete Student");
			primaryStage.setScene(scene3);
		});

		search.setOnAction(e -> {
			primaryStage.setTitle("Search Student");
			primaryStage.setScene(scene4);
		});

		size.setOnAction(e -> {
			primaryStage.setTitle("Find Size");
			primaryStage.setScene(scene5);
		});

		mean.setOnAction(e -> {
			primaryStage.setTitle("Find Mean Average");
			primaryStage.setScene(scene6);
		});

		percentage.setOnAction(e -> {
			primaryStage.setTitle("Find Percentage");
			primaryStage.setScene(scene7);
		});

		mode.setOnAction(e -> {
			primaryStage.setTitle("Find Mode");
			primaryStage.setScene(scene8);
		});

		display.setOnAction(e -> {
			primaryStage.setTitle("Display Top Ten");
			primaryStage.setScene(scene9);
		});

	}

	// @Override
	public void handle(ActionEvent t) {

	}

}
