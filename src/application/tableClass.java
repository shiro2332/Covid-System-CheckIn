package application;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class tableClass extends RecursiveTreeObject<tableClass> {

    private final StringProperty date;
    private final StringProperty time;
    private final StringProperty shop;
    private final StringProperty no;
    
    //StringProperty = Datatype for table column
    public tableClass(int no, String date, String time, String shop) {
    	this.no = new SimpleStringProperty(String.valueOf(no));
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.shop = new SimpleStringProperty(shop);
    }
    
    public StringProperty getNo() { 
    	return no; 
    }
    public StringProperty getDate() { 
    	return date; 
    }
    public StringProperty getTime() {
    	return time; 
    }
    public StringProperty getShop() { 
    	return shop; 
    }

}