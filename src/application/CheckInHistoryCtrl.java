package application;
import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeTableColumn;

public class CheckInHistoryCtrl {
	
	//Changeable element that is inside CustomerCheckInHistory FXML 
	private ObservableList<tableClass> data;

    @FXML
    private JFXTreeTableView<tableClass> table;

    @FXML
    private TreeTableColumn<tableClass, String> noCol;

    @FXML
    private TreeTableColumn<tableClass, String> dateCol;

    @FXML
    private TreeTableColumn<tableClass, String> timeCol;

    @FXML
    private TreeTableColumn<tableClass, String> shopCol;
    
    @FXML
    void initialize() {
    	CustomerSession currentSession = CustomerSession.getSession();
    	
    	//Read data from file to recordList
        FileHandler file = new FileHandler();
    	ArrayList<history> recordList = new ArrayList<history>();
		try {
			recordList = file.readRecordFile("RecordList.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		//Add recordList data to table data
    	int count = 0;
    	data = FXCollections.observableArrayList();
    	for (int i = 0; i < recordList.size(); i++) {
    		if(recordList.get(i).fetchCustomerName().equals(currentSession.fetchCustomer().fetchUsername())) {
    			count += 1;
    			data.add(new tableClass(count, recordList.get(i).fetchDate(), recordList.get(i).fetchTime(), recordList.get(i).fetchShopName()));
    		}else {
    			continue;
    		}
    	}
    	
    	//Set value to their respective column
        noCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<tableClass, String> param) -> param.getValue().getValue().getNo());
        dateCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<tableClass, String> param) -> param.getValue().getValue().getDate());
        timeCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<tableClass, String> param) -> param.getValue().getValue().getTime());
        shopCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<tableClass, String> param) -> param.getValue().getValue().getShop());

        //Assign data to table and show it
        table.setRoot(new RecursiveTreeItem<tableClass>(data, RecursiveTreeObject::getChildren));
        table.setShowRoot(false);
    }

}
