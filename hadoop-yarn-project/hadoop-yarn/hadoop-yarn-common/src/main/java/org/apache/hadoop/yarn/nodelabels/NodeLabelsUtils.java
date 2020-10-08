package org.apache.hadoop.yarn.nodelabels;

import java.util.Random;

public class NodeLabelsUtils {
    public static String[] getParsedLabels(String label){
        if(label==null){
                return new String[]{""};
           }
        if(label.indexOf("&&")>0){
                return label.split("&&");
            }else if(label.indexOf("||")>0){
                String labels[]= label.split("\\|\\|");
                if(labels.length==1){
                        return new String[]{labels[0], CommonNodeLabelsManager.NO_LABEL};
                    }else{
                        return labels;
                    }
            }
        return new String[]{label};
    }

    public static String getOrLabel(String[] labelList){
        Random df = new Random();
        int index=df.nextInt(labelList.length);
        return labelList[index];
    }
}
