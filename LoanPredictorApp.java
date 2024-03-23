// LoanPredictorApp.java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoanPredictorApp {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Label incomeLabel = new Label("Income:");
        TextField incomeField = new TextField();
        Label creditScoreLabel = new Label("Credit Score:");
        TextField creditScoreField = new TextField();
        Label loanAmountLabel = new Label("Loan Amount:");
        TextField loanAmountField = new TextField();
        Button predictButton = new Button("Predict");
        Label resultLabel = new Label();

        // Set action for the predict button
        predictButton.setOnAction(e -> {
            // Get input values
            double income = Double.parseDouble(incomeField.getText());
            int creditScore = Integer.parseInt(creditScoreField.getText());
            double loanAmount = Double.parseDouble(loanAmountField.getText());

            // Perform prediction (replace with your prediction logic)
            boolean approved = predictLoanApproval(income, creditScore, loanAmount);

            // Display prediction result
            if (approved) {
                resultLabel.setText("Loan Approved");
            } else {
                resultLabel.setText("Loan Rejected");
            }
        });

        // Layout
        VBox root = new VBox(10);
        root.getChildren().addAll(
                incomeLabel, incomeField,
                creditScoreLabel, creditScoreField,
                loanAmountLabel, loanAmountField,
                predictButton, resultLabel
        );

        // Create scene and set it on the stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Loan Predictor");
        primaryStage.show();
    }

    // Dummy prediction method (replace with your actual prediction logic)
    private boolean predictLoanApproval(double income, int creditScore, double loanAmount) {
        // Example logic: approve loan if income > 50000 and creditScore > 600
        return income > 50000 && creditScore > 600;
    }
}
