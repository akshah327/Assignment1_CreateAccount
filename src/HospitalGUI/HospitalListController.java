package HospitalGUI;

import groovy.util.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Model.Hospital;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by tkanchanawanchai6403 on 7/25/2016.
 */
public class HospitalListController {
    @FXML
    private TableView<Hospital> hospitalTable;
    @FXML
    private TextField searchKey;
    @FXML
    private TableColumn<Hospital, String> nameColumn;
    @FXML
    private TableColumn<Hospital, String> streetAddressColumn;
    @FXML
    private TableColumn<Hospital, String> cityColumn;
    @FXML
    private TableColumn<Hospital, String> stateColumn;
    @FXML
    private TableColumn<Hospital, String> zipColumn;
    @FXML
    private TableColumn<Hospital, String> latitudeColumn;
    @FXML
    private TableColumn<Hospital, String> longitudeColumn;
    @FXML
    private TableColumn<Hospital, String> phoneNoColumn;
    @FXML
    private TableColumn<Hospital, String> photoColumn;

    // Reference to the main application.
    private HospitalView hospitalApp;


    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        streetAddressColumn.setCellValueFactory(cellData -> cellData.getValue().streetAddressProperty());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        stateColumn.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        zipColumn.setCellValueFactory(cellData -> cellData.getValue().zipProperty());
        latitudeColumn.setCellValueFactory(cellData -> cellData.getValue().latitudeProperty());
        longitudeColumn.setCellValueFactory(cellData -> cellData.getValue().longitudeProperty());
        phoneNoColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNoProperty());
        photoColumn.setCellValueFactory(cellData -> cellData.getValue().photoProperty());
    }

    public void setHospitalApp(HospitalView hospitalApp)
    {
        this.hospitalApp = hospitalApp;

        // Add observable list data to the table
        hospitalTable.setItems(hospitalApp.getHospitalData());
    }

    public void handleEnterPressed(KeyEvent event)
    {
        String latitude = "";
        String longitude = "";
        String key = "";
        boolean coordinate = true;
        Hospital hospitalKey;
        javafx.collections.ObservableList<Hospital> searchHospitalResultTable = FXCollections.observableArrayList();

        if (event.getCode() == KeyCode.ENTER)
        {
            key = searchKey.getText();
            if (coordinate)
            {
                key.split(",");
                latitude = key.split(",")[0];
                longitude = key.split(",")[1];
                hospitalKey = new Hospital(latitude, longitude);
                if (hospitalApp.getHospitalBSTTree().contains(hospitalKey));
                {
                    searchHospitalResultTable.add(hospitalApp.getHospitalBSTTree().get(hospitalKey));
                    hospitalApp.setHospitalData(searchHospitalResultTable);
                    hospitalTable.setItems(hospitalApp.getHospitalData());
                }
            }
        }
    }
}
