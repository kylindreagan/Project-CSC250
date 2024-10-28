/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author giann
 */
public class DownPaymentHelper {
    public static int homePriceCalculate(float uCash, float dPayment, float intRate, float lTerm, float cCost){
        return 0;
    }
    
    public static int cashCalculate(){
        return 0;
    }
    
    public static int downPaymentCalculate(){
        return 0;
    }
    public static Dictionary<String, Integer> createVals(){
        Dictionary <String, Integer> stateClosingCosts = new Hashtable<>();
        String [] names = {"Alabama", "Alaska", "Arizona","Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia" , "Hawaii", "Idaho", "Illinios", "Indiana", "Iowa", "Kansas", "Kentucky", "Lousiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "Washington, DC", "West Virginia", "Wisconsin", "Wyoming"};
        int [] costs = {2986, 3581, 4701, 3115, 7953, 3881, 8821, 17859, 8554, 3762, 7463, 4082, 5929, 2200, 3146, 2793, 2802, 3711, 4420, 14721, 7964, 5714, 4011, 2756, 2061, 3337, 2781, 6383, 8183, 7915, 3513, 16849, 3406, 2501, 4223, 2893, 4327, 10634, 5568, 3447, 3105, 3911, 4548, 4837, 7906, 6346, 13927, 29888, 3406, 3459, 2589};
        for (int i = 0; i < 51; i++){
            stateClosingCosts.put(names[i], costs[i]);
        }
        return stateClosingCosts;
    }
}
