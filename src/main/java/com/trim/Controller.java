package com.trim;

//import com.sun.org.apache.xpath.internal.operations.Or;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.LoadOut;
import model.Ordinance;

import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Controller implements Initializable{

    ArrayList<Ordinance> OrdinanceTable = new ArrayList<>();
    LoadOut[] loadOuts = new LoadOut[20];

    List Station1and9 = new ArrayList<>();
    List<Ordinance> Station2and8 = new ArrayList<>();
    List<Ordinance> Station3and7 = new ArrayList<>();
    List<Ordinance> Station4Ord = new ArrayList<>();
    List<Ordinance> Station5Ord = new ArrayList<>();
    List<Ordinance> Station6Ord = new ArrayList<>();
    int OrdinanceWeight;
    float FuelWeight;
    double BulletWeight;
    int externalTanks;
    float TotalWeight;
    int pitchTrim;
    int loadindex = 0;
    double asymmetry;
    double asymmetricTrim;
    boolean left;
    double CG;
    String noseLiftOff;
    String TakeOff;


    boolean  noPylonStation2;
    boolean  noPylonStation3;
    boolean noPylonStation7;
    boolean  noPylonStation8;

    @FXML
    MenuButton Station1;
    @FXML
    MenuButton Station2;
    @FXML
    MenuButton Station3;
    @FXML
    MenuButton Station4;
    @FXML
    MenuButton Station5;
    @FXML
    MenuButton Station6;
    @FXML
    MenuButton Station7;
    @FXML
    MenuButton Station8;
    @FXML
    MenuButton Station9;


    //Station1 menu types
    @FXML
    Menu AAMissilesStation1;
    @FXML
    Menu PodsStation1;

    //station 2 menu types
    @FXML
    Menu AAMissilesStation2;
    @FXML
    Menu PodsStation2;
    @FXML
    Menu AGMissilesStation2;
    @FXML
    Menu BombsStation2;
    @FXML
    Menu RocketsStation2;


    //station 3 menu types;
    @FXML
    Menu AAMissilesStation3;
    @FXML
    Menu PodsStation3;
    @FXML
    Menu AGMissilesStation3;
    @FXML
    Menu BombsStation3;
    @FXML
    Menu RocketsStation3;
    @FXML
    Menu FuelStation3;

    //station 4 menu types
    @FXML
    Menu AAMissilesStation4;
    @FXML
    Menu PodsStation4;

    //station 5 menu types
    @FXML
    Menu PodsStation5;
    @FXML
    Menu FuelStation5;
    @FXML
    Menu BombsStation5;

    //station 6 menu types
    @FXML
    Menu AAMissilesStation6;

    //station 7 menu types
    @FXML
    Menu AAMissilesStation7;
    @FXML
    Menu PodsStation7;
    @FXML
    Menu AGMissilesStation7;
    @FXML
    Menu BombsStation7;
    @FXML
    Menu RocketsStation7;
    @FXML
    Menu FuelStation7;

    //station 8 menu types
    @FXML
    Menu AAMissilesStation8;
    @FXML
    Menu PodsStation8;
    @FXML
    Menu AGMissilesStation8;
    @FXML
    Menu BombsStation8;
    @FXML
    Menu RocketsStation8;

    //station 9 menu types
    @FXML
    Menu AAMissilesStation9;
    @FXML
    Menu PodsStation9;



    @FXML
    ChoiceBox<String> loadoutSelector;

    //Results text
    @FXML
    Text TotalWeightText;
    @FXML
    Text AsymmetricTorqueText;
    @FXML
    Text CenterOfGravityText;
    @FXML
    Text FuelWeightText;
    @FXML
    Text CatPitchTrimText;
    @FXML
    Text AsymmetricTrimText;
    @FXML
    Text NoseLiftoffText;
    @FXML
    Text TakeoffSpeedText;

    // Results labels
    @FXML
    Label TotalWeightLabel;
    @FXML
    Label AsymmetryLabel;
    @FXML
    Label COGLabel;
    @FXML
    Label FuelWeightLabel;
    @FXML
    Label CatPitchLabel;
    @FXML
    Label AsymmetricTrimLabel;
    @FXML
    Label NoseLiftoffLabel;
    @FXML
    Label TakeoffSpeedLabel;
    @FXML
    Label nameError;
    @FXML
    Label usedNameError;
    @FXML
    Label selectLoadoutError;

    @FXML
    TextField FuelLoad;

    @FXML
    TextField GunLoad;

    @FXML
    TextField LoadoutName;

    @FXML
    Button submitButton;

    @FXML
    Button deleteButton;

    @FXML
    Slider bulletSlider;

    @FXML
    Slider fuelSlider;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createData();
        setupSelectionBoxes();
        //getLoadoutList();
        loadoutSelector.setValue("Choose Loadout");
    }

    EventHandler<ActionEvent> Select1 = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
          Station1.setText(((MenuItem) e.getSource()).getText());
      }
  };
    EventHandler<ActionEvent> Select2 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            Station2.setText(((MenuItem) e.getSource()).getText());
        }
    };
    EventHandler<ActionEvent> Select3 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            Station3.setText(((MenuItem) e.getSource()).getText());
        }
    };
    EventHandler<ActionEvent> Select4 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            Station4.setText(((MenuItem) e.getSource()).getText());
        }
    };
    EventHandler<ActionEvent> Select5 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            Station5.setText(((MenuItem) e.getSource()).getText());
        }
    };
    EventHandler<ActionEvent> Select6 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            Station6.setText(((MenuItem) e.getSource()).getText());
        }
    };
    EventHandler<ActionEvent> Select7 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            Station7.setText(((MenuItem) e.getSource()).getText());
        }
    };
    EventHandler<ActionEvent> Select8 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            Station8.setText(((MenuItem) e.getSource()).getText());
        }
    };
    EventHandler<ActionEvent> Select9 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            Station9.setText(((MenuItem) e.getSource()).getText());
        }
    };

    public void setupSelectionBoxes(){

        Station1.setText("Station 1");
        Station2.setText("Station 2");
        Station3.setText("Station 3");
        Station4.setText("Station 4");
        Station5.setText("Station 5");
        Station6.setText("Station 6");
        Station7.setText("Station 7");
        Station8.setText("Station 8");
        Station9.setText("Station 9");



        //setup station 1
        Station1and9 = sortOrdinance1("AAMissile");
        setUpMenu(Station1and9,AAMissilesStation1,Select1);
        Station1and9 = sortOrdinance1("Pod");
        setUpMenu(Station1and9,PodsStation1,Select1);
         addMenuItem(Station1, OrdinanceTable,3,Select1,0);

        //setup station 2
        Station2and8 = sortOrdinance2("AAMissile");
        setUpMenu(Station2and8,AAMissilesStation2,Select2);
        Station2and8 = sortOrdinance2("Pod");
        setUpMenu(Station2and8,PodsStation2,Select2);
        Station2and8 = sortOrdinance2("AGMissile");
        setUpMenu(Station2and8,AGMissilesStation2,Select2);
        Station2and8 = sortOrdinance2("bomb");
        setUpMenu(Station2and8,BombsStation2,Select2);
       Station2and8 = sortOrdinance2("rocket");
        setUpMenu(Station2and8,RocketsStation2,Select2);
        addMenuItem(Station2,OrdinanceTable,6,Select2,0);
        addMenuItem(Station2,OrdinanceTable,7,Select2,1);

        //setup station 3
        Station3and7 = sortOrdinance3("AAMissile");
        setUpMenu(Station3and7,AAMissilesStation3,Select3);
        Station3and7 = sortOrdinance3("Pod");
        setUpMenu(Station3and7,PodsStation3,Select3);
        Station3and7 = sortOrdinance3("AGMissile");
        setUpMenu(Station3and7,AGMissilesStation3,Select3);
        Station3and7 = sortOrdinance3("bomb");
        setUpMenu(Station3and7,BombsStation3,Select3);
        Station3and7 = sortOrdinance3("rocket");
        setUpMenu(Station3and7,RocketsStation3,Select3);
        Station3and7 = sortOrdinance3("fuel");
        setUpMenu(Station3and7,FuelStation3,Select3);
        addMenuItem(Station3,OrdinanceTable,7,Select3,0);
        addMenuItem(Station3,OrdinanceTable,8,Select3,1);

        //setup station 4
        Station4Ord = sortOrdinance4("AAMissile");
        setUpMenu(Station4Ord,AAMissilesStation4,Select4);
        Station4Ord = sortOrdinance4("Pod");
        setUpMenu(Station4Ord,PodsStation4,Select4);
        addMenuItem(Station4,OrdinanceTable,3,Select4,0);


        //setup station 5
        Station5Ord = sortOrdinance5("Pod");
        setUpMenu(Station5Ord,PodsStation5,Select5);
        Station5Ord = sortOrdinance5("fuel");
        setUpMenu(Station5Ord,FuelStation5,Select5);
        Station5Ord = sortOrdinance5("bomb");
        setUpMenu(Station5Ord,BombsStation5,Select5);
        addMenuItem(Station5,OrdinanceTable,4,Select5,0);

        //setup station 6
        Station6Ord = sortOrdinance6("AAMissile");
        setUpMenu(Station6Ord,AAMissilesStation6,Select6);
        addMenuItem(Station6,OrdinanceTable,2,Select6,0);

        //setup station 7
        Station3and7 = sortOrdinance3("AAMissile");
        setUpMenu(Station3and7,AAMissilesStation7,Select7);
        Station3and7 = sortOrdinance3("Pod");
        setUpMenu(Station3and7,PodsStation7,Select7);
        Station3and7 = sortOrdinance3("AGMissile");
        setUpMenu(Station3and7,AGMissilesStation7,Select7);
        Station3and7 = sortOrdinance3("bomb");
        setUpMenu(Station3and7,BombsStation7,Select7);
        Station3and7 = sortOrdinance3("rocket");
        setUpMenu(Station3and7,RocketsStation7,Select7);
        Station3and7 = sortOrdinance3("fuel");
        setUpMenu(Station3and7,FuelStation7,Select7);
        addMenuItem(Station7,OrdinanceTable,7,Select7,0);
        addMenuItem(Station7,OrdinanceTable,8,Select7,1);

        //setup station 8

        Station2and8 = sortOrdinance2("AAMissile");
        setUpMenu(Station2and8,AAMissilesStation8,Select8);
        Station2and8 = sortOrdinance2("Pod");
        setUpMenu(Station2and8,PodsStation8,Select8);
        Station2and8 = sortOrdinance2("AGMissile");
        setUpMenu(Station2and8,AGMissilesStation8,Select8);
        Station2and8 = sortOrdinance2("bomb");
        setUpMenu(Station2and8,BombsStation8,Select8);
        Station2and8 = sortOrdinance2("rocket");
        setUpMenu(Station2and8,RocketsStation8,Select8);
        addMenuItem(Station8,OrdinanceTable,6,Select8,0);
        addMenuItem(Station8,OrdinanceTable,7,Select8,1);


        //setup station 9
        Station1and9 = sortOrdinance1("AAMissile");
        setUpMenu(Station1and9,AAMissilesStation9,Select9);
        Station1and9 = sortOrdinance1("Pod");
        setUpMenu(Station1and9,PodsStation9,Select9);
        addMenuItem(Station9, OrdinanceTable,3,Select9,0);


    }

    private void addMenuItem(MenuButton station, List ordinanceList, int MenuIndex,EventHandler event, int  OrdinanceID) {
        Ordinance ords1;
        ords1 = (Ordinance) ordinanceList.get(OrdinanceID);
        station.getItems().add(MenuIndex,(new MenuItem(ords1.name)));
        station.getItems().get(MenuIndex).setOnAction(event);
    }

    private void setUpMenu(List ordinanceList,Menu menu, EventHandler event) {
      Ordinance ords2;
        for(int i =0;i < ordinanceList.size();i++){
        ords2 = (Ordinance) ordinanceList.get(i);
            try {
                menu.getItems().add(new MenuItem(ords2.name));
                menu.getItems().get(i).setOnAction(event);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private List sortOrdinance1( String type) {
       List ordinanceList1 = OrdinanceTable.stream().filter(Ord -> Ord.station1and9 && Ord.type.contentEquals(type))
                .collect(Collectors.toList());
        return ordinanceList1;
    }
    private List sortOrdinance2( String type) {
        List ordinanceList2 = OrdinanceTable.stream()
                .filter(Ordinance -> Ordinance.station2and8 && Ordinance.getType().contentEquals(type))
                .collect(Collectors.toList());
        return ordinanceList2;
    }
    private List sortOrdinance3( String type) {
        List ordinanceList3 = OrdinanceTable.stream()
                .filter(Ordinance -> Ordinance.station3and7 && Ordinance.getType().contentEquals(type))
                .collect(Collectors.toList());
        return ordinanceList3;
    }
    private List sortOrdinance4( String type) {
        List ordinanceList4 = OrdinanceTable.stream()
                .filter(Ordinance -> Ordinance.station4 && Ordinance.getType().contentEquals(type))
                .collect(Collectors.toList());
        return ordinanceList4;
    }
    private List sortOrdinance5( String type) {
        List ordinanceList5 = OrdinanceTable.stream()
                .filter(Ordinance -> Ordinance.station5 && Ordinance.getType().contentEquals(type))
                .collect(Collectors.toList());
        return ordinanceList5;
    }
    private List sortOrdinance6( String type) {
        List ordinanceList6 = OrdinanceTable.stream()
                .filter(Ordinance -> Ordinance.station6 && Ordinance.getType().contentEquals(type))
                .collect(Collectors.toList());
        return ordinanceList6;
    }
    public void calculateTrim(){

        DecimalFormat df = new DecimalFormat("#.0");

        externalTanks = 0;
        OrdinanceWeight = 0;
        TotalWeight = 0;
        asymmetry = 0;
        asymmetricTrim = 0;
        BulletWeight = 0;

        calculateGunWeight();
        calculateFuelWeight();
        calculateOrdinanceWeight();
        calculatePitchTrim();
        calculateAsymmetry();
        calculateAsymmetricTrim();
        calculateCG();
        calculateNWLiftoffandTakeOffSpeed();

        TotalWeightLabel.setText(String.valueOf(Math.round(TotalWeight)));
        AsymmetryLabel.setText(String.valueOf(Math.round(asymmetry)));

        FuelWeightLabel.setText(String.valueOf(Math.round(FuelWeight)));
        CatPitchLabel.setText(String.valueOf(Math.round(pitchTrim)));
        if(left && asymmetricTrim != 0){AsymmetricTrimLabel.setText(String.valueOf(Math.round(asymmetricTrim)) + " Left");}
        else if(asymmetricTrim != 0){AsymmetricTrimLabel.setText(String.valueOf(Math.round(asymmetricTrim)) + " Right");}
        else{AsymmetricTrimLabel.setText("0");}

        COGLabel.setText(String.valueOf(df.format(CG)));
        NoseLiftoffLabel.setText(noseLiftOff);
        TakeoffSpeedLabel.setText(TakeOff);

   }

    public void calculateFuelWeight(){
        if(FuelLoad.getText() == ""){FuelLoad.setText("100");}
        if(getOrdinanceName(Station3.getText()) == "330 Gallon Fuel"){externalTanks++;}
        if(getOrdinanceName(Station5.getText()) == "330 Gallon Fuel"){externalTanks++;}
        if(getOrdinanceName(Station7.getText()) == "330 Gallon Fuel"){externalTanks++;}
        float internalFuel = Integer.parseInt(FuelLoad.getText());
        FuelWeight = (internalFuel / 100 * 10803) + (externalTanks * 2535) ;
   }

    public void setFuelText(){
        FuelLoad.setText(String.valueOf(Math.round(fuelSlider.getValue())));
   }

    public void setBulletText(){
        GunLoad.setText(String.valueOf(Math.round(bulletSlider.getValue())));
   }

    public void calculateOrdinanceWeight(){
       OrdinanceWeight = OrdinanceWeight + getOrdinanceWeight(Station1.getText());
       OrdinanceWeight = OrdinanceWeight + getOrdinanceWeight(Station2.getText());
       OrdinanceWeight = OrdinanceWeight + getOrdinanceWeight(Station3.getText());
       OrdinanceWeight = OrdinanceWeight + getOrdinanceWeight(Station4.getText());
       OrdinanceWeight = OrdinanceWeight + getOrdinanceWeight(Station5.getText());
       OrdinanceWeight = OrdinanceWeight + getOrdinanceWeight(Station6.getText());
       OrdinanceWeight = OrdinanceWeight + getOrdinanceWeight(Station7.getText());
       OrdinanceWeight = OrdinanceWeight + getOrdinanceWeight(Station8.getText());
       OrdinanceWeight = OrdinanceWeight + getOrdinanceWeight(Station9.getText());
       TotalWeight = FuelWeight + OrdinanceWeight + Math.round(BulletWeight) + 25093;
   }

    public int getOrdinanceWeight(String value){
       Optional<Ordinance> weight = OrdinanceTable.stream()
               .filter(p -> p.name.equals(value))
               .findFirst();

        return weight.get().weight;
   }

    public String getOrdinanceName(String value){
       Optional<Ordinance> name = OrdinanceTable.stream()
               .filter(p -> p.name.equals(value))
               .findFirst();

       return name.get().name;
   }

    public void calculatePitchTrim(){
       if(TotalWeight >= 49000){ pitchTrim = 19; }
       if(TotalWeight >= 45000 && TotalWeight < 49000){ pitchTrim = 17;}
       if(TotalWeight <45000){ pitchTrim = 16; }
   }

    public void calculateAsymmetry() {
       asymmetry = asymmetry + (getOrdinanceWeight(Station1.getText()) * -19.5);
       asymmetry = asymmetry + (getOrdinanceWeight(Station2.getText()) * -11.2);
         if(getOrdinanceName(Station3.getText()) == "330 Gallon Fuel"){
          asymmetry = asymmetry + ((getOrdinanceWeight(Station3.getText())+2244) * -7.3);
        }else{
            asymmetry = asymmetry + (getOrdinanceWeight(Station3.getText()) * -7.3);
         }
        asymmetry = asymmetry + (getOrdinanceWeight(Station4.getText()) * -3.7);
        asymmetry = asymmetry + (getOrdinanceWeight(Station6.getText()) * 3.7);
        if(getOrdinanceName(Station7.getText()) == "330 Gallon Fuel"){
           asymmetry = asymmetry + ((getOrdinanceWeight(Station7.getText())+2244) * 7.3);
        }else{
            asymmetry = asymmetry + (getOrdinanceWeight(Station7.getText()) * 7.3);
        }
        asymmetry = asymmetry + (getOrdinanceWeight(Station8.getText()) * 11.2);
        asymmetry = asymmetry + (getOrdinanceWeight(Station9.getText()) * 19.5);
   }

    public void calculateAsymmetricTrim(){
        if(Math.abs(asymmetry) >= 18000){ asymmetricTrim = 6;}
        if(Math.abs(asymmetry) >= 11000 && Math.abs(asymmetry) < 18000){
            asymmetricTrim = (0.5714 * (Math.abs(asymmetry) * 0.001))  -4.2852;
        }
        if(asymmetry < -11000){left = false;}
        if(asymmetry > 11000){left = true;}
   }

    public double getStation1and9GG(String value){
        Optional<Ordinance> CG = OrdinanceTable.stream()
                .filter(p -> p.name.equals(value))
                .findFirst();

        return CG.get().station1and9CG;
    }

    public double getStation2and8GG(String value){
        Optional<Ordinance> CG = OrdinanceTable.stream()
                .filter(p -> p.name.equals(value))
                .findFirst();

        return CG.get().station2and8CG;
    }

    public double getStation3and7GG(String value){
        Optional<Ordinance> CG = OrdinanceTable.stream()
                .filter(p -> p.name.equals(value))
                .findFirst();

        return CG.get().station3and7CG;
    }

    public double getStation4CG(String value){
        Optional<Ordinance> CG = OrdinanceTable.stream()
                .filter(p -> p.name.equals(value))
                .findFirst();

        return CG.get().station4CG;
    }

    public double getStation5CG(String value){
        Optional<Ordinance> CG = OrdinanceTable.stream()
                .filter(p -> p.name.equals(value))
                .findFirst();

        return CG.get().station5CG;
    }

    public double getStation6CG(String value){
        Optional<Ordinance> CG = OrdinanceTable.stream()
                .filter(p -> p.name.equals(value))
                .findFirst();

        return CG.get().station6CG;
    }

    public void calculateGunWeight(){
        if(GunLoad.getText() == ""){GunLoad.setText("578"); }
        int bullets = Integer.parseInt(GunLoad.getText());
        BulletWeight = bullets * 0.576;
   }

    public void calculateCG(){
    CG = 22.3;
    CG = CG - ((Integer.parseInt(GunLoad.getText())) * 0.00346);
    CG = CG + getStation1and9GG(Station1.getText());
    CG = CG + getStation2and8GG(Station2.getText());
    CG = CG + getStation3and7GG(Station3.getText());
    CG = CG + getStation4CG(Station4.getText());
    CG = CG + getStation5CG(Station5.getText());
    CG = CG + getStation6CG(Station6.getText());
    CG = CG + getStation3and7GG(Station7.getText());
    CG = CG + getStation2and8GG(Station8.getText());
    CG = CG + getStation1and9GG(Station9.getText());
   }

    public void calculateNWLiftoffandTakeOffSpeed(){

       if(TotalWeight>50000){
            if(CG<=25){ noseLiftOff = "158";TakeOff = "165";}
            if(CG<=23){ noseLiftOff = "165";TakeOff = "171";}
            if(CG<=21){ noseLiftOff = "172";TakeOff = "179";}
            if(CG<=19){ noseLiftOff = "178";TakeOff = "186";}
            if(CG>25){ noseLiftOff = "150";TakeOff = "158";}
        }
       if(TotalWeight<=50000){
            if(CG<=25){ noseLiftOff = "151";TakeOff = "158";}
            if(CG<=23){ noseLiftOff = "158";TakeOff = "164";}
            if(CG<=21){ noseLiftOff = "164";TakeOff = "171";}
            if(CG<=19){ noseLiftOff = "170";TakeOff = "178";}
            if(CG>25){ noseLiftOff = "142";TakeOff = "151";}
       }

        if(TotalWeight<=46000){
            if(CG<=25){ noseLiftOff = "142";TakeOff = "154";}
            if(CG<=23){ noseLiftOff = "149";TakeOff = "160";}
            if(CG<=21){ noseLiftOff = "157";TakeOff = "167";}
            if(CG<=19){ noseLiftOff = "164";TakeOff = "174";}
            if(CG>25){ noseLiftOff = "135";TakeOff = "147";}
       }

       if(TotalWeight<=42000){
           if(CG<=25){ noseLiftOff = "134";TakeOff = "147";}
           if(CG<=23){ noseLiftOff = "141";TakeOff = "152";}
           if(CG<=21){ noseLiftOff = "148";TakeOff = "158";}
           if(CG<=19){ noseLiftOff = "154";TakeOff = "163";}
           if(CG >25){ noseLiftOff = "127";TakeOff = "141";}
       }
       if(TotalWeight<=38000){
            if(CG<=25){ noseLiftOff = "126";TakeOff = "140";}
            if(CG<=23){ noseLiftOff = "132";TakeOff = "144";}
            if(CG<=21){ noseLiftOff = "139";TakeOff = "150";}
            if(CG<=19){ noseLiftOff = "145";TakeOff = "155";}
            if(CG>25){ noseLiftOff = "119";TakeOff = "135";}
       }
        if(TotalWeight<=34000){
            if(CG<=25){ noseLiftOff = "119";TakeOff = "134";}
            if(CG<=23){ noseLiftOff = "125";TakeOff = "138";}
            if(CG<=21){ noseLiftOff = "131";TakeOff = "142";}
            if(CG<=19){ noseLiftOff = "136";TakeOff = "146";}
            if(CG>25){ noseLiftOff = "112";TakeOff = "130";}
        }
   }

    public void createData(){
         OrdinanceTable.add(new Ordinance(0,"Empty",0,0,0.1,0.1,0,-0.2,0,true,true,true,true,true,true," "));
         OrdinanceTable.add(new Ordinance(1,"No Pylon",0,0,0.1,0.1,0,-0.2,0,false,false,false,false,false,false,""));
        //aa missiles
         OrdinanceTable.add(new Ordinance(2,"AIM-9X",185,0.2,0,0,0,0,0,true,false,false,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(3,"AIM-9L",187,0.2,0,0,0,0,0,true,false,false,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(4,"AIM-9M",189,0.2,0,0,0,0,0,true,false,false,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(5,"CAP-9",189,0.2,0,0,0,0,0,true,false,false,false,false,false,"AAMissile"));
        //pods
         OrdinanceTable.add(new Ordinance(6,"ACMI Pod",136,0.2,0,0,0,0,0,true,false,false,false,false,false,"Pod"));
         OrdinanceTable.add(new Ordinance(7,"AWW-13 Datalink Pod",440,0,-0.025,-0.05,0,0,0,false,true,true,false,true,false,"Pod"));
         OrdinanceTable.add(new Ordinance(8,"Litening Pod",661,0,0,0,0.5,0.1,0.5,false,false,false,true,false,false,"Pod"));
         OrdinanceTable.add(new Ordinance(9,"ATFLIR pod",429,0,0,0,0.5,0.1,0.5,false,false,false,true,false,false,"Pod"));
        //bombs
         OrdinanceTable.add(new Ordinance(10,"AGM-62 Walleye II Guided Weapon Mk 5 (TV Guided)",2339,0,-0.1,-0.2,0,0,0,false,true,false,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(11,"BDU-45 500lb Practice Bomb",511,0,-0.5,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(12,"BDU-45 LG 500lb Practice Bomb",610,0,-0.5,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(13,"BDU-45B 500lb Practice Bomb",511,0,-0.5,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(14,"2x BDU-45 500lb Practice Bomb",1223,0,-0.5,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(15,"2x BDU-45 LG 500lb Practice Bomb",1422,0,-0.5,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(16,"2x BDU-45B 500lb Practice Bomb",1223,0,-0.5,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(17,"2x CBU-99 490lbs,247 x HEAT Bomblets",1153,0,-0.5,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(18,"2x GBU-12 500lb Laser Guided Bomb",1387,0,-0.05,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(19,"2x MK 20 Rockeye 490lbs CBU, 247 x HEAT Bomblets",1153,0,-0.05,-0.1,0,0,0,false,true,true,false,false,false,"bomb"));
         OrdinanceTable.add(new Ordinance(20,"2x MK 82 500lb GP Bomb LD",1237,0,-0.05,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(21,"2x MK 82 Snakeeye 500lb GP Bomb HD",1197,0,-0.05,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(22,"2x MK 82Y 500lb GP Chute Retarded HD",1223,0,-0.05,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(23,"2x MK 83 1000lb GP Bomb LD",2145,0,-0.1,-0.2,0,0,0,false,true,true,false,false,false,"bomb"));
         OrdinanceTable.add(new Ordinance(24,"6 x BDU-33 25lb Practice Bomb",432,0,-0.025,-0.05,0,-0.7,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(25,"2x GBU-38 JDAM, 500lb GPS Guided Bomb",1237,0,-0.05,-0.1,0,0,0,false,true,true,false,false,false,"bomb"));
         OrdinanceTable.add(new Ordinance(26,"CBU-99 490lbs,247 x HEAT Bomblets",489,0,-0.025,-0.5,0,-0.7,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(27,"GBU-10 2000lb laser Guided Bomb",2562,0,-0.125,-0.25,0,-3.6,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(28,"GBU-12 500lb Laser Guided Bomb",606,0,-0.025,-0.05,0,-0.7,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(29,"GBU-16 1000lb laser Guided Bomb",1243,0,-0.05,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(30,"GBU-24A/B Paveway III 2000lb laser Guided Bomb",2396,0,-0.125,-0.25,0,-3.6,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(31,"GBU-31(V)1/B JDAM 2000lb GPS Guided Bomb",2059,0,-0.1,-0.2,0,-2.4,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(32,"GBU-31(V)2/B JDAM 2000lb GPS Guided Bomb",2059,0,-0.1,-0.2,0,-2.4,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(33,"GBU-31(V)3/B JDAM 2000lb GPS Guided Penetrator Bomb",2162,0,-0.1,-0.2,0,-2.4,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(34,"GBU-31(V)4/B JDAM 2000lb GPS Guided Penetrator Bomb",2138,0,-0.1,-0.2,0,-2.4,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(35,"GBU-32(V)2/B JDAM 1000lb GPS Guided Bomb",985,0,-0.05,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(36,"GBU-38 JDAM, 500lb GPS Guided Bomb",531,0,-0.025,-0.5,0,-0.7,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(37,"MK 20 Rockeye 490lbs CBU, 247 x HEAT Bomblets",489,0,-0.025,-0.05,0,-0.7,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(38,"MK 82 500lb GP Bomb LD",531,0,-0.025,-0.05,0,-0.7,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(39,"MK 82 Snakeeye 500lb GP Bomb HD",511,0,-0.025,-0.05,0,-0.7,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(40,"MK 82Y 500lb GP Chute Retarded HD",511,0,-0.025,-0.05,0,-0.7,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(41,"MK 83 1000lb GP Bomb LD",985,0,-0.05,-0.1,0,-1.2,0,false,true,true,false,true,false,"bomb"));
         OrdinanceTable.add(new Ordinance(42,"MK 84 2000lb GP Bomb LD",1971,0,-0.1,-0.2,0,-2.4,0,false,true,true,false,true,false,"bomb"));
         //fuel
         OrdinanceTable.add(new Ordinance(43,"330 Gallon Fuel",114,0,0,-0.25,0,-3.6,0,false,false,true,false,true,false,"fuel"));
         //ag missiles
         OrdinanceTable.add(new Ordinance(44,"AGM-154A JSOW CEB (CBU-type)",1069,0,-0.05,-0.1,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(45,"AGM-154C JSOW Unitary BROACH",1067,0,-0.1,-0.1,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(46,"AGM-84D harpoon AShM",1190,0,-0.05,-0.1,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(47,"AGM-84E Harpoon/SLAM",1384,0,-0.05,-0.1,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(48,"AGM-84H SLAM-ER",1598,0,-0.05,-0.1,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(49,"AGM-88C HARM ",795,0,-0.03,-0.8,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(50,"BRU-42 with 2 x ADM-141A TALD",906,0,-0.03,-0.8,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(51,"BRU-42 with 2 x ADM-141A TALD",1302,0,-0.03,-0.8,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(52,"BRU-42 with ADM-141A TALD",509,0,-0.03,-0.8,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(53,"2x AGM-154A JSOW CEB (CBU-type)",2249,0,-0.1,-0.2,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(54,"2x AGM-154C JSOW Unitary BROACH",2244,0,-0.1,-0.2,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(55,"AGM-65E maverick Laser",760,0,-0.025,-0.07,0,0,0,false,true,true,false,false,false,"AGMissile"));
         OrdinanceTable.add(new Ordinance(56,"AGM-65F  Marverick IR",793,0,-0.03,-0.07,0,0,0,false,true,true,false,false,false,"AGMissile"));
         //rockets
         OrdinanceTable.add(new Ordinance(57,"LAU-10 pod 4 x 127mm ZUNI MK71 UnGd Rkts HE/FRAG",899,0,-0.025,-0.1,0,0,0,false,true,true,false,false,false,"rocket"));
         OrdinanceTable.add(new Ordinance(58,"LAU-61 pod 19 x 2.75in Hydra M151 UnGd Rkts HE",804,0,-0.025,-0.05,0,0,0,false,true,true,false,false,false,"rocket"));
         OrdinanceTable.add(new Ordinance(59,"LAU-68 pod 7 x 2.75in Hydra M151 UnGd Rkts HE",452,0,-0.025,-0.05,0,0,0,false,true,true,false,false,false,"rocket"));
         OrdinanceTable.add(new Ordinance(60,"LAU-68 pod 7 x 2.75in Hydra UnGd Rkts Mk5, HEAT",425,0,0.025,-0.05,0,0,0,false,true,true,false,false,false,"rocket"));
         OrdinanceTable.add(new Ordinance(61,"2 x LAU-10 pod 4 x 127mm ZUNI MK71 UnGd Rkts HE/FRAG",1596,0,-0.1,-0.2,0,0,0,false,true,true,false,false,false,"rocket"));
         OrdinanceTable.add(new Ordinance(62,"2 x LAU-61 pod 19 x 2.75in Hydra M151 UnGd Rkts HE",1406,0,-0.03,-0.5,0,0,0,false,true,true,false,false,false,"rocket"));
         OrdinanceTable.add(new Ordinance(63,"2 x LAU-68 pod 7 x 2.75in Hydra M151 UnGd Rkts HE",703,0,-0.025,-0.05,0,0,0,false,true,true,false,false,false,"rocket"));
         OrdinanceTable.add(new Ordinance(64,"2 x LAU-68 pod 7 x 2.75in Hydra UnGd Rkts Mk5, HEAT",650,0,-0.025,-0.05,0,0,0,false,true,true,false,false,false,"rocket"));
         //pylon aa missiles
         OrdinanceTable.add(new Ordinance(65,"AIM-120B + LAU-115",668,0,-0.03,-0.05,0,0,0,false,true,true,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(66,"AIM-120C + LAU-115",676,0,-0.03,-0.05,0,0,0,false,true,true,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(67,"AIM-9L + LAU-115",509,0,-0.025,-0.05,0,0,0,false,true,false,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(68,"AIM-9M + LAU-115",509,0,-0.025,-0.05,0,0,0,false,true,false,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(69,"AIM-9X + LAU-115",507,0,-0.025,-0.05,0,0,0,false,true,false,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(70,"CAP-9 + LAU-115",509,0,-0.025,-0.05,0,0,0,false,true,false,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(71,"2x AIM-120B + LAU-115",1016,0,-0.05,-0.1,0,0,0,false,true,true,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(72,"2x AIM-120C + LAU-115",1031,0,-0.05,-0.1,0,0,0,false,true,true,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(73,"2x AIM-9L + LAU-115",698,0,-0.03,-0.6,0,0,0,false,true,false,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(74,"2x AIM-9M + LAU-115",698,0,-0.03,-0.6,0,0,0,false,true,false,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(75,"2x AIM-9X + LAU-115",698,0,-0.03,-0.6,0,0,0,false,true,false,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(76,"2x CAP-9 + LAU-115",698,0,-0.03,-0.6,0,0,0,false,true,false,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(77,"AIM-7F + LAU-115C",630,0,-0.03,-0.05,0,0,0,false,true,true,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(78,"AIM-7M + LAU-115",630,0,-0.03,-0.05,0,0,0,false,true,true,false,false,false,"AAMissile"));
         OrdinanceTable.add(new Ordinance(79,"AIM-7MH + LAU-115C",630,0,-0.03,-0.05,0,0,0,false,true,true,false,false,false,"AAMissile"));
         //Hip missiles
         OrdinanceTable.add(new Ordinance(80,"AIM-120B AMRAAM",343,0,0,0,0.3,0,0.3,false,false,false,true,false,true,"AAMissile"));
         OrdinanceTable.add(new Ordinance(81,"AIM-120C AMRAAM",357,0,0,0,0.3,0,0.3,false,false,false,true,false,true,"AAMissile"));
         OrdinanceTable.add(new Ordinance(82,"AIM-7F Sparrow",509,0,0,0,0.5,0,0.5,false,false,false,true,false,true,"AAMissile"));
         OrdinanceTable.add(new Ordinance(83,"AIM-7M Sparrow",509,0,0,0,0.5,0,0.5,false,false,false,true,false,true,"AAMissile"));
         OrdinanceTable.add(new Ordinance(84,"AIM-7MH Sparrow",509,0,0,0,0.5,0,0.5,false,false,false,true,false,true,"AAMissile"));
         OrdinanceTable.add(new Ordinance(85,"AIM-7P Sparrow",509,0,0,0,0.5,0,0.5,false,false,false,true,false,true,"AAMissile"));
         OrdinanceTable.add(new Ordinance(86,"Station 1",0,0,0.1,0.1,0,-0.2,0,true,true,true,true,true,true," "));
         OrdinanceTable.add(new Ordinance(87,"Station 2",0,0,0.1,0.1,0,-0.2,0,true,true,true,true,true,true," "));
         OrdinanceTable.add(new Ordinance(88,"Station 3",0,0,0.1,0.1,0,-0.2,0,true,true,true,true,true,true," "));
         OrdinanceTable.add(new Ordinance(89,"Station 4",0,0,0.1,0.1,0,-0.2,0,true,true,true,true,true,true," "));
         OrdinanceTable.add(new Ordinance(90,"Station 5",0,0,0.1,0.1,0,-0.2,0,true,true,true,true,true,true," "));
         OrdinanceTable.add(new Ordinance(91,"Station 6",0,0,0.1,0.1,0,-0.2,0,true,true,true,true,true,true," "));
         OrdinanceTable.add(new Ordinance(92,"Station 7",0,0,0.1,0.1,0,-0.2,0,true,true,true,true,true,true," "));
         OrdinanceTable.add(new Ordinance(93,"Station 8",0,0,0.1,0.1,0,-0.2,0,true,true,true,true,true,true," "));
         OrdinanceTable.add(new Ordinance(94,"Station 9",0,0,0.1,0.1,0,-0.2,0,true,true,true,true,true,true," "));

   }
    String username = System.getProperty("user.name");
    String part1 = "C:\\Users\\";
    String part2 = "\\AppData\\Local\\";
   File filePath = new File(part1 + username + part2 +"./loadOuts");

   public void saveLoadout(){
        loadindex = 0;
        if(LoadoutName.getText() == ""){
            nameError.setVisible(true);
        }
        else {

            nameError.setVisible(false);
            LoadOut loadout = new LoadOut(LoadoutName.getText(), Station1.getText().toString(),

                    Station2.getText().toString(), Station3.getText().toString(),
                    Station4.getText().toString(), Station5.getText().toString(),
                    Station6.getText().toString(), Station7.getText().toString(),
                    Station8.getText().toString(), Station9.getText().toString(),
                    FuelLoad.getText(), GunLoad.getText(),
                    noPylonStation2, noPylonStation3,
                    noPylonStation7, noPylonStation8);

            for (int a = 0; a < 20; a++) {
                if (loadOuts[a] != null) {
                    loadindex++;
                }
            }
            loadOuts[loadindex] = loadout;


               try {
                   FileOutputStream fs = new FileOutputStream(filePath);
                   ObjectOutputStream os = new ObjectOutputStream(fs);
                   os.write(loadindex + 1);
                   System.out.println(loadindex + 1);
                   for (int a = 0; a < loadOuts.length; a++) {
                       os.writeObject(loadOuts[a]);
                   }
                   os.close();
                   fs.close();
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               }
               getLoadoutList();
           }
        LoadoutName.clear();
   }

   public void loadLoadout(){
        if(loadoutSelector.getValue() == null || loadoutSelector.getValue().contentEquals("Choose Loadout")){
            selectLoadoutError.setVisible(true);
        }else {
            selectLoadoutError.setVisible(false);
            Optional<LoadOut> loads = Arrays.stream(loadOuts)
                    .filter(p -> p.name.equals(loadoutSelector.getValue()))
                    .findFirst();
            LoadOut setloadout = new LoadOut(loads.get().name,
                    loads.get().Station1, loads.get().Station2,
                    loads.get().Station3, loads.get().Station4,
                    loads.get().Station5, loads.get().Station6,
                    loads.get().Station7, loads.get().Station8,
                    loads.get().Station9, loads.get().FuelLoad,
                    loads.get().GunLoad, loads.get().isStation2noPylon(),
                    loads.get().isStation3noPylon(), loads.get().isStation7noPylon(),
                    loads.get().isStation7noPylon());
            setLoadout(setloadout);
        }
   }

    List<String> names = new ArrayList<>();
    int Loadoutlength = 0;

   public void getLoadoutList(){
       loadoutSelector.getItems().removeAll(names);
        names.clear();

        for(int clear = 0; clear < loadOuts.length; clear++){
            loadOuts[clear] = null;
        }

        try{
           FileInputStream fi = new FileInputStream(filePath);

           ObjectInputStream os = new ObjectInputStream(fi);
           Loadoutlength = os.read();
           for(int a = 0; a < Loadoutlength; a++) {
               LoadOut check = (LoadOut) os.readObject();
               if(check != null){
                   loadOuts[a] = check;
               }
           }
           os.close();
           fi.close();
       }catch (FileNotFoundException e){
           e.printStackTrace();
       }catch(IOException e){
           e.printStackTrace();
       }catch(ClassNotFoundException e ){
           e.printStackTrace();
       }
       for(int b = 0; b < Loadoutlength; b++){
           names.add(loadOuts[b].name);
       }
       loadoutSelector.getItems().addAll(names);
   }

   public void deleteLoadout(){
       LinkedList<LoadOut> newloadout = new LinkedList<>() ;

        int listLen = 0;

       Arrays.stream(loadOuts).sorted(Comparator.comparing(LoadOut::getName));

       Optional<LoadOut> loads = Arrays.stream(loadOuts)
               .filter(p -> p.name.equals(loadoutSelector.getValue().toString()))
               .findFirst();

       for(int loadindex = 0; loadindex < Loadoutlength; loadindex++){
           if(loads.get().name.toString() == loadOuts[loadindex].name.toString()){}
           else{
               newloadout.add(loadOuts[loadindex]);
               listLen++;
           }
       }

       try {
           FileOutputStream fs = new FileOutputStream(filePath);
           ObjectOutputStream os = new ObjectOutputStream(fs);
           os.write(listLen);
           for (int a = 0; a < listLen; a++) {
               os.writeObject(newloadout.get(a));
           }
           os.close();
           fs.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       getLoadoutList();
   }

   public void setLoadout(LoadOut loadout){
        Station1.setText(loadout.Station1);
        Station2.setText(loadout.Station2);
        Station3.setText(loadout.Station3);
        Station4.setText(loadout.Station4);
        Station5.setText(loadout.Station5);
        Station6.setText(loadout.Station6);
        Station7.setText(loadout.Station7);
        Station8.setText(loadout.Station8);
        Station9.setText(loadout.Station9);
        FuelLoad.setText(loadout.FuelLoad);
        GunLoad.setText(loadout.GunLoad);
        fuelSlider.setValue(Integer.valueOf(FuelLoad.getText()));
        bulletSlider.setValue(Integer.valueOf(GunLoad.getText()));

   }
}
