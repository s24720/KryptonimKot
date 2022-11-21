package org.example.lambda;

import org.example.model.Gender;

import java.util.ArrayList;
import java.util.List;

public class SearchParameters {
   private List<Gender> genders=new ArrayList<>();

   public List<Gender> getSelectedGenders(){
        return genders;
    }
}
