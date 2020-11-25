/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.utils;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 *
 * @author user
 */
public class FormValidator {
    
    public  static  void isDouble(TextField field){
       field.setTextFormatter(new TextFormatter<>(t->{
                    if(t.isContentChange()){
                        if(t.getControlNewText().length()==0){
                            return t;
                        }
                        try{
                            //CONDITION DE VALIDITE
                             Double.parseDouble(t.getControlNewText());
                             return t;
                        }catch(Exception ex){
                           return null; 
                        }
                       
                    }   
                       return null;
               }
       )
       ); 
    }
 
    
    
    
    public static void disabledBtn(Button btn,TextField field){
        btn.disableProperty().bind(
          Bindings.createBooleanBinding(()-> field.getText().trim().isEmpty(), 
                  field.textProperty())
       );
    }
    public static void disabledBtn(Button btn,TextField field1,TextField field2){
        btn.disableProperty().bind(
          Bindings.createBooleanBinding(
                  ()-> field1.getText().trim().isEmpty(), 
                  field1.textProperty()
          ).or(
              Bindings.createBooleanBinding(
                  ()-> field2.getText().trim().isEmpty(), 
                  field2.textProperty()
               )    
          )
       );
    }
}
