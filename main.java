import java.io.*;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.prediction.*;
import hex.genmodel.MojoModel;

public class main {
  public static void main(String[] args) throws Exception {
    EasyPredictModelWrapper model = new EasyPredictModelWrapper(MojoModel.load("GBM_4_AutoML_20200729_235759.zip"));

    RowData row = new RowData();
    row.put("vendor_id", "1");
    row.put("passenger_count", "3");
    row.put("pickup_longitude", "-73.9");
    row.put("pickup_latitude", "40.79");
    row.put("dropoff_longitude", "-73.89");
    row.put("dropoff_latitude", "40.80");
    row.put("store_and_fwd_flag", "N");
    row.put("distance", "10");
    row.put("speed", "28");
    row.put("pickup_datetime_moy", "4");
    row.put("pickup_datetime_hour", "18");
    row.put("pickup_datetime_woy", "7");
    row.put("pickup_datetime_dow", "5");
    row.put("pickup_datetime_doy", "50");

    RegressionModelPrediction p = model.predictRegression(row);
    System.out.println("The values of your independent variables are as follows: ");
    System.out.println(row);
    System.out.println("Trip duration in seconds: " + p.value);
  	}
  }

    