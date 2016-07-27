package HospitalGUI;

import HospitalGUI.HospitalListController;
import Model.ReadExcel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Model.Hospital;
import Model.ReadExcel;
import utils.BinarySearchTree;

import java.io.IOException;
import java.util.List;

/**
 * Created by tkanchanawanchai6403 on 7/25/2016.
 */
public class HospitalView {
    private static Stage hospitalListStage = new Stage();
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String latitude;
    private String longitude;
    private String phoneNo;
    private String photo;
    private ObservableList<Hospital> hospitalData = FXCollections.observableArrayList();
    private BorderPane rootLayout;
    private BinarySearchTree<Hospital> hospitalBSTTree;


    public BinarySearchTree<Hospital> getHospitalBSTTree()
    {
        return hospitalBSTTree;
    }

    public HospitalView() throws IOException
    {
        loadHospital();
        initRootLayout();
        showHospitalView();
        //   Parent hospitalListView = FXMLLoader.load(getClass().getResource("HospitalListJavaFx.fxml"));
        hospitalListStage.setTitle("Hospital List Page");
        //  Scene hospitalListScene = new Scene(hospitalListView, 575, 575);
        // hospitalListStage.setScene(hospitalListScene);
        // hospitalListStage.show();
    }

    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HospitalView.class.getResource("rootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            hospitalListStage.setScene(scene);
            hospitalListStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadHospital() {
        List hospitalList = null;
        try {
            hospitalList = ReadExcel.excelReader("HospitalList.xls");
        } catch (Exception e) {
            System.err.println("Problem reading HospitalLis.xls file");
            e.printStackTrace();
        }
        //ReadExcelFile.showExcelData(hospitalList);
        for (int i = 0; i < hospitalList.size(); i++) {
            List record = (List) hospitalList.get(i);
            //System.out.println(record);
            //System.out.println(record.get(col));
            name = String.valueOf(record.get(0));
            streetAddress = String.valueOf(record.get(1));
            city = String.valueOf(record.get(2));
            state = String.valueOf(record.get(3));
            zip = String.valueOf(record.get(4));
            latitude = String.valueOf(record.get(5));
            longitude = String.valueOf(record.get(6));
            phoneNo = String.valueOf(record.get(7));
            photo = String.valueOf(record.get(8));

            Hospital hospital = new Hospital(name, streetAddress, city, state, zip, latitude, longitude, phoneNo, photo);
            hospitalBSTTree = new BinarySearchTree<Hospital>();
            hospitalBSTTree.add(hospital);
            hospitalData.add(hospital);
        }
    }

    public void showHospitalView()
    {
        try
        {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HospitalView.class.getResource("hospitalJavaFX.fxml"));
            AnchorPane hospitalOverview = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(hospitalOverview);

            // Give the controller access to the main app.
            HospitalListController controller = loader.getController();
            controller.setHospitalApp(this);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Returns the data as an observable list of Hospitals.
     *
     * @return
     */
    public ObservableList<Hospital> getHospitalData()
    {
        return hospitalData;
    }

    public void setHospitalData(ObservableList<Hospital> data)
    {
        this.hospitalData = data;
    }


}