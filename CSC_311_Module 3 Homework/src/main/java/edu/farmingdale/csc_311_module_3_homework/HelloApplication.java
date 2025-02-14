package edu.farmingdale.csc_311_module_3_homework;          //Package Name

import javafx.application.Application;          //All the imports
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {

        //This is where we have created our labels and input fields.
        //We created a new Label object named AnnualInterestRate for the Annual Interest Rate.
        Label AnnualInterestRate = new Label("Annual Interest Rate:");
        TextField AInterestRate = new TextField();

        //We created a new Label object named NumYears for the Number of Years.
        Label NumYears = new Label("Number of Years:");
        TextField nYears = new TextField();

        //We created a new Label object named LoanAmount for the Loan Amount.
        Label LoanAmount = new Label("Loan Amount:");
        TextField tLoanAmount = new TextField();

        //We created a new Label object named MonthlyPayment for the Monthly Payment.
        Label MonthlyPayment = new Label("Monthly Payment:");
        TextField eMonthlyPayment = new TextField();
        eMonthlyPayment.setEditable(true);

        //We created a new Label object named TotalPayment for the Total Payment. This is the only text field that we are not able to edit because we calculate the total payment using the Annual Interest Rate, Number of Years, Loan Amount, and Monthly Payment.
        Label TotalPayment = new Label("Total Payment:");
        TextField xTotalPayment = new TextField();
        xTotalPayment.setEditable(false);

        //We created a new Button object named sCalculate for the Calculator.
        Button sCalculate = new Button("Calculator");

        //We are setting up the grid pane.
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        //We are adding components to the grid.
        grid.add(AnnualInterestRate, 0, 0);
        grid.add(AInterestRate, 1, 0);
        grid.add(NumYears, 0, 1);
        grid.add(nYears, 1, 1);
        grid.add(LoanAmount, 0, 2);
        grid.add(tLoanAmount, 1, 2);
        grid.add(MonthlyPayment, 0, 3);
        grid.add(eMonthlyPayment, 1, 3);
        grid.add(TotalPayment, 0, 4);
        grid.add(xTotalPayment, 1, 4);
        grid.add(sCalculate, 1, 5);

        //This is the Button event handler.
        sCalculate.setOnAction(e -> {

                double annualInterestRate = Double.parseDouble(AInterestRate.getText());
                int numberOfYears = Integer.parseInt(nYears.getText());
                double loanAmount = Double.parseDouble(tLoanAmount.getText());

                double monthlyInterestRate = annualInterestRate / 1200;
                int numberOfMonths = numberOfYears * 12;
                double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfMonths));
                double totalPayment = monthlyPayment * numberOfMonths;

                xTotalPayment.setText(String.format("$%.2f", totalPayment));
           {

            }
        });

        //We are setting the scene.
        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setTitle("LoanCalculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
