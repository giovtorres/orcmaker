package com.example.orcmaker.orcer.json;

import com.example.orcmaker.orcer.Orcer;
import org.apache.hadoop.hive.ql.exec.vector.ColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;

import java.math.BigDecimal;

public class TinyIntOrcer implements Orcer {

        public static TinyIntOrcer getInstance() {
            if (instance == null) {
                instance = new TinyIntOrcer();
            }
            return instance;
        }
        @Override
        public void addObject(ColumnVector columnVector, int columnIndex, Object obj) {
            LongColumnVector longColumnVector = (LongColumnVector) columnVector;
            byte[] bytes= null;
            if(obj instanceof Integer) {
                longColumnVector.vector[columnIndex] = (Integer)obj;
                longColumnVector.isNull[columnIndex] = false;
            }else if(obj instanceof Long) {
                longColumnVector.vector[columnIndex] = (Long)obj;
                longColumnVector.isNull[columnIndex] = false;
            } else if(obj instanceof BigDecimal) {
                longColumnVector.vector[columnIndex] = ((BigDecimal)obj).longValue();
                longColumnVector.isNull[columnIndex] = false;
            }else{
                longColumnVector.isNull[columnIndex]=true;
            }
        }

        private static TinyIntOrcer instance = null;
}
