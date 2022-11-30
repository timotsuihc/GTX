import javafx.application.______1_____;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.______2_______;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout._____3______;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.stage.Stage;

  public class DollarsToPounds extends _______4_______ {

      final static double EXCHANGE_RATE = 0.81;

      public void _____5____(_____6_____ stage) {

      Label valueLbl = new Label(____7_____);

      Label poundsLbl = new Label();

      ______8______ dollarsTxt = new ____9______();

      Button ____10_____ = new Button();

      exchangeBtn.____11____(______12______);

      _______13______(____14_____ {
         String dollarsStr = ______15______.toString();
         try {
              double dollars = Double.parseDouble(dollarsStr);
              double pounds = ____16_____(dollars);
              poundsLbl.setText(String.format("%.2f", pounds));
             } catch (NumberFormatException e) {
                    ___17___ a = new ____18____(___19_____);
                    _____20______("Error");
                     a.setHeaderText("Invalid Dollar Amount");
                     a.setContentText("Please only use digits.");
                     a.showAndWait();
            }
        });

        ___21___ input = new _____22_____();
        input.setAlignment(Pos.CENTER);
        _______23_____(valueLbl, _____24_____);

        _____25_____ root = new ____26____();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(8);
        root._____27____(_______28________, ________29________, ________30_______);

        _____31____ scene = new _____32_____(____33_____, 400, 400);
        _______34____("Dollars to Pounds");
        stage.setScene(____35___);
        stage.show();

    }

    private double exchange(double dollars) {
       return dollars*_______36________;
    }
}
