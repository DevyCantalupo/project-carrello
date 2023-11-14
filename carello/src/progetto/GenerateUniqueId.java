package progetto;

import java.util.Random;

public class GenerateUniqueId {

    public static int generateUniqueID(){
        Random rand = new Random();
        Integer uniqueId = rand.nextInt(100);
        boolean isUnique = false;
        if(Warehouse.warehouse.isEmpty()){
            return uniqueId;
        }
        do{
            for(int i = 0; i < Warehouse.warehouse.size(); i++){
                if(uniqueId.equals(Warehouse.warehouse.get(i).getId())){
                    uniqueId = rand.nextInt(100);
                }
                else{
                    isUnique = true;
                }
            }
        }while(!isUnique);
        return uniqueId;
    }
}
