package com.ecc.javalanguage.aboutClass.compara;

import com.ecc.javalanguage.aboutClass.Student;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

public class SortImpl implements ISort {
    public  void sortInt(List<Student> stuList){//List<Student>
        if (stuList == null || stuList.size() < 2) return;

        for(int i = 0;i<stuList.size();i++){
            int maxIndex = i;
            for (int j = i + 1;j < stuList.size() ;j++){
                if (stuList.get(j).getStuAge() > stuList.get(maxIndex).getStuAge()){
                    maxIndex  = j;
                }
            }
            if (maxIndex!=i){
                Collections.swap(stuList, i,maxIndex);
            }
        }
    }
}
